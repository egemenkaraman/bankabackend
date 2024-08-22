package com.example.stajbank;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface bankaRepository extends JpaRepository<bankaEntity,Long> {
    @Query("SELECT b FROM bankaEntity b WHERE b.musteriName = :musteriName")
    bankaEntity findByMusteriName(@Param("musteriName") String musteriName);
}
