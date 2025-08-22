package com.example.fileloader.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "cdr_logs")
public class CdrLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "file_name")
    private String fileName;

    @Column(name = "upload_start_time")
    private LocalDateTime uploadStartTime;

    @Column(name = "upload_end_time")
    private LocalDateTime uploadEndTime;

    @Column(name = "success_count")
    private int successCount;

    @Column(name = "fail_count")
    private int failCount;

    // --- Constructors ---
    public CdrLog() {
    }

    public CdrLog(String fileName, LocalDateTime uploadStartTime, LocalDateTime uploadEndTime,
                  int successCount, int failCount) {
        this.fileName = fileName;
        this.uploadStartTime = uploadStartTime;
        this.uploadEndTime = uploadEndTime;
        this.successCount = successCount;
        this.failCount = failCount;
    }

    // --- Getters & Setters ---
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public LocalDateTime getUploadStartTime() {
        return uploadStartTime;
    }
    public void setUploadStartTime(LocalDateTime uploadStartTime) {
        this.uploadStartTime = uploadStartTime;
    }

    public LocalDateTime getUploadEndTime() {
        return uploadEndTime;
    }
    public void setUploadEndTime(LocalDateTime uploadEndTime) {
        this.uploadEndTime = uploadEndTime;
    }

    public int getSuccessCount() {
        return successCount;
    }
    public void setSuccessCount(int successCount) {
        this.successCount = successCount;
    }

    public int getFailCount() {
        return failCount;
    }
    public void setFailCount(int failCount) {
        this.failCount = failCount;
    }

    // --- Utility ---
    @Override
    public String toString() {
        return "CdrLog{" +
                "id=" + id +
                ", fileName='" + fileName + '\'' +
                ", uploadStartTime=" + uploadStartTime +
                ", uploadEndTime=" + uploadEndTime +
                ", successCount=" + successCount +
                ", failCount=" + failCount +
                '}';
    }
}
