package com.bsuir.course.repository;

import com.bsuir.course.domain.Apartment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApartmentRepository extends JpaRepository<Apartment, Long> {
    List<Apartment> findAll();
}
