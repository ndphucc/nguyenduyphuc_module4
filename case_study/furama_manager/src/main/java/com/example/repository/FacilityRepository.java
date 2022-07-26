package com.example.repository;

import com.example.model.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

@Transactional
public interface FacilityRepository extends JpaRepository<Facility, Integer> {

    @Query(value = "select * from facility where delete_status = false ", nativeQuery = true)
    Page<Facility> findAll(Pageable pageable);

    @Modifying
    @Query(value = "update facility set delete_status = true where id = :id", nativeQuery = true)
    void remove(@Param("id") int id);
}
