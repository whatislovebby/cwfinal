package com.bsuir.course.service.sale;

import com.bsuir.course.domain.sale.AddressForSale;
import com.bsuir.course.repository.sale.AddressRepositoryForSale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressForSaleService {
    @Autowired
    private AddressRepositoryForSale addressRepository;

    public List<AddressForSale> getAllAddresses() {
        return addressRepository.findAll();
    }
}
