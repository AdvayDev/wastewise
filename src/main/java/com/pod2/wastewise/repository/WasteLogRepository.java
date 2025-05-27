package com.pod2.wastewise.repository;

import com.pod2.wastewise.model.WasteLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface WasteLogRepository extends JpaRepository<WasteLog, String> {
    @Query("Select COUNT(w) from WasteLog w")
    long countAll();
}
