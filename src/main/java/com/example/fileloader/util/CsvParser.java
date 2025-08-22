package com.example.fileloader.util;

import com.example.fileloader.entity.CallDetailRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@Component
public class CsvParser {

    private static final Logger logger = LoggerFactory.getLogger(CsvParser.class);

    private static final DateTimeFormatter RECORD_DATE_FORMATTER =
            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss,SSS");
    private static final DateTimeFormatter TSTAMP_FORMATTER =
            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S");

    public List<CallDetailRecord> parse(File file) {
        List<CallDetailRecord> records = new ArrayList<>();

        try (Stream<String> lines = Files.lines(file.toPath())) {
            lines.forEach(line -> {
                try {
                    String[] fields = line.split("\\|", -1);

                    if (fields.length < 33) {
                        logger.error("Skipping malformed line (expected 33 fields, found {}). Line: {}", fields.length, line);
                        return;
                    }

                    CallDetailRecord record = new CallDetailRecord();

                    try {
                        record.setRecordDate(LocalDateTime.parse(fields[0], RECORD_DATE_FORMATTER));
                        record.setTstamp(LocalDateTime.parse(fields[27], TSTAMP_FORMATTER));
                    } catch (DateTimeParseException e) {
                        logger.error("Date parse failed. Line: {}, Error: {}", line, e.getMessage());
                        return;
                    }

                    record.setLSpc(fields[1].isEmpty() ? null : Integer.parseInt(fields[1]));
                    record.setLSsn(fields[2].isEmpty() ? null : Integer.parseInt(fields[2]));
                    record.setLRi(fields[3].isEmpty() ? null : Integer.parseInt(fields[3]));
                    record.setLGtI(fields[4].isEmpty() ? null : Integer.parseInt(fields[4]));
                    record.setRSpc(fields[6].isEmpty() ? null : Integer.parseInt(fields[6]));
                    record.setRSsn(fields[7].isEmpty() ? null : Integer.parseInt(fields[7]));
                    record.setRRi(fields[8].isEmpty() ? null : Integer.parseInt(fields[8]));
                    record.setRGtI(fields[9].isEmpty() ? null : Integer.parseInt(fields[9]));

                    record.setServiceCode(fields[11]);
                    record.setOrNature(fields[12].isEmpty() ? null : Integer.parseInt(fields[12]));
                    record.setOrPlan(fields[13].isEmpty() ? null : Integer.parseInt(fields[13]));
                    record.setDeNature(fields[15].isEmpty() ? null : Integer.parseInt(fields[15]));
                    record.setDePlan(fields[16].isEmpty() ? null : Integer.parseInt(fields[16]));
                    record.setIsdnNature(fields[18].isEmpty() ? null : Integer.parseInt(fields[18]));
                    record.setIsdnPlan(fields[19].isEmpty() ? null : Integer.parseInt(fields[19]));
                    record.setVlrNature(fields[21].isEmpty() ? null : Integer.parseInt(fields[21]));
                    record.setVlrPlan(fields[22].isEmpty() ? null : Integer.parseInt(fields[22]));

                    record.setLocalDialogId(fields[28].isEmpty() ? null : Long.parseLong(fields[28]));
                    record.setRemoteDialogId(fields[29].isEmpty() ? null : Long.parseLong(fields[29]));
                    record.setDialogDuration(fields[30].isEmpty() ? null : Long.parseLong(fields[30]));

                    record.setLGtDigits(fields[5]);
                    record.setRGtDigits(fields[10]);
                    record.setOrDigits(fields[14]);
                    record.setDeDigits(fields[17]);
                    record.setMsisdn(fields[20]);
                    record.setVlrDigits(fields[23]);
                    record.setImsi(fields[24]);
                    record.setStatus(fields[25]);
                    record.setType(fields[26]);
                    record.setUssdString(fields[31]);
                    record.setId(fields[32]);

                    records.add(record);
                } catch (Exception e) {
                    logger.error("Error parsing line: {}", line, e);
                }
            });
        } catch (IOException e) {
            logger.error("Could not read file: {}", file.getAbsolutePath(), e);
        }

        return records;
    }
}
