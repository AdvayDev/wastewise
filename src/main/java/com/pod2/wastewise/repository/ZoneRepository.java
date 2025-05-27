package com.pod2.wastewise.repository;

import com.pod2.wastewise.model.Zone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ZoneRepository extends JpaRepository<Zone,String> {
    @Query("Select COUNT(z) from Zone z")
    long countAll();
}
