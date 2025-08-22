package com.example.fileloader.repository;

import com.example.fileloader.entity.CallDetailRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CallDetailRecordRepository extends JpaRepository<CallDetailRecord, String> {
}
