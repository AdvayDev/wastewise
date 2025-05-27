package com.pod2.wastewise.repository;

import com.pod2.wastewise.model.Route;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RouteRepository extends JpaRepository<Route,String> {
    @Query("Select COUNT(r) from Route r")
    long countAll();
}
