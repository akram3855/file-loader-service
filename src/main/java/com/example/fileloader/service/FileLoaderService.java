package com.example.fileloader.service;

import com.example.fileloader.repository.CallDetailRecordRepository;
import com.example.fileloader.util.CsvParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Arrays;
import java.util.List;

@Service
public class FileLoaderService {

    private static final Logger logger = LoggerFactory.getLogger(FileLoaderService.class);

    @Value("${fileloader.folder}")
    private String fileInputFolder;

    private final CallDetailRecordRepository callDetailRecordRepository;
    private final CsvParser csvParser;

    public FileLoaderService(CallDetailRecordRepository callDetailRecordRepository, CsvParser csvParser) {
        this.callDetailRecordRepository = callDetailRecordRepository;
        this.csvParser = csvParser;
    }

    @Scheduled(fixedRate = 60000)
    public void loadFilesFromFolder() {
        logger.info("Checking for new files in input folder: {}", fileInputFolder);
        File folder = new File(fileInputFolder);
        File[] listOfFiles = folder.listFiles((dir, name) -> name.endsWith(".txt"));

        if (listOfFiles != null && listOfFiles.length > 0) {
            Arrays.stream(listOfFiles).forEach(file -> {
                try {
                    logger.info("Processing file: {}", file.getName());
                    List<com.example.fileloader.entity.CallDetailRecord> records = csvParser.parse(file);
                    callDetailRecordRepository.saveAll(records);
                    logger.info("Successfully loaded {} records from file: {}", records.size(), file.getName());
                    moveFileToProcessedFolder(file);
                } catch (Exception e) {
                    logger.error("Error processing file: {}", file.getName(), e);
                }
            });
        } else {
            logger.info("No new log files found to process.");
        }
    }

    private void moveFileToProcessedFolder(File file) {
        Path processedPath = Paths.get(fileInputFolder, "processed");

        try {
            if (!Files.exists(processedPath)) {
                Files.createDirectories(processedPath);
                logger.info("Created directory: {}", processedPath);
            }
        } catch (IOException e) {
            logger.error("Failed to create processed directory: {}", processedPath, e);
            return;
        }

        Path destination = processedPath.resolve(file.getName());

        try {
            Files.move(file.toPath(), destination, StandardCopyOption.REPLACE_EXISTING);
            logger.info("Successfully moved file to processed folder: {}", destination);
        } catch (IOException e) {
            logger.error("Failed to move file to processed folder: {}", destination, e);
        }
    }
}
