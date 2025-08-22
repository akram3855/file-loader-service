package com.example.fileloader.repository;

import com.example.fileloader.entity.CdrLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CdrLogRepository extends JpaRepository<CdrLog, Long> {
}
