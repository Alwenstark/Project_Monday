package com.Project_Monday.repository;

import com.Project_Monday.model.Kart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KartRepo extends JpaRepository<Kart,Long> {
}
