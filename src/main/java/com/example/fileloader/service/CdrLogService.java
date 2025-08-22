package com.example.fileloader.service;

import com.example.fileloader.entity.CdrLog;
import com.example.fileloader.repository.CdrLogRepository;
import org.springframework.stereotype.Service;

@Service
public class CdrLogService {

    private final CdrLogRepository cdrLogRepository;

    public CdrLogService(CdrLogRepository cdrLogRepository) {
        this.cdrLogRepository = cdrLogRepository;
    }

    public void saveLog(CdrLog log) {
        cdrLogRepository.save(log);
    }
}
