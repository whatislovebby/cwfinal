package com.bsuir.course.repository.sale;

import com.bsuir.course.domain.sale.AddressForSale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepositoryForSale extends JpaRepository<AddressForSale, Long> {
    List<AddressForSale> findAll();
}
