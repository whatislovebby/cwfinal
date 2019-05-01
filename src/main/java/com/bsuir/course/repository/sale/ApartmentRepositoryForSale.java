package com.bsuir.course.repository.sale;

import com.bsuir.course.domain.sale.ApartmentForSale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public interface ApartmentRepositoryForSale extends JpaRepository<ApartmentForSale, Long> {
    List<ApartmentForSale> findAll();

    Optional<ApartmentForSale> findById(Long id);

    List<ApartmentForSale> findAllByUser_Id(Long userID);

    List<ApartmentForSale> findAllByPriceBetween(Float minPrice, Float maxPrice);

    List<ApartmentForSale> findAllByPriceBetweenAndRoomCountBetween(Float price, Float price2, Integer roomCount, Integer roomCount2);

    List<ApartmentForSale> findAllByPriceBetweenAndRoomCountIn(Float price, Float price2, Set<Integer> roomCount);
}
