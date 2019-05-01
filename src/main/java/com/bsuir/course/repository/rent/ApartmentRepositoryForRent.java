package com.bsuir.course.repository.rent;

import com.bsuir.course.domain.rent.ApartmentForRent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public interface ApartmentRepositoryForRent extends JpaRepository<ApartmentForRent, Long> {
    List<ApartmentForRent> findAll();

    Optional<ApartmentForRent> findById(Long id);

    List<ApartmentForRent> findAllByUser_Id(Long userID);

    List<ApartmentForRent> findAllByPriceBetween(Float minPrice, Float maxPrice);

    List<ApartmentForRent> findAllByPriceBetweenAndRoomCountBetween(Float price, Float price2, Integer roomCount, Integer roomCount2);

    List<ApartmentForRent> findAllByPriceBetweenAndRoomCountIn(Float price, Float price2, Set<Integer> roomCount);
}

