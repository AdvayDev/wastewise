package com.pod2.wastewise.repository;

import com.pod2.wastewise.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RoleRepository extends JpaRepository<Role, String> {
    @Query("Select COUNT(r) from Role r")
    long countAll();
}
