package com.bsuir.course.repository.rent;

import com.bsuir.course.domain.rent.AddressForRent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepositoryForRent extends JpaRepository<AddressForRent, Long> {
    List<AddressForRent> findAll();
}
