package com.bsuir.course.service.rent;

import com.bsuir.course.domain.rent.AddressForRent;
import com.bsuir.course.repository.rent.AddressRepositoryForRent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressForRentService {
    @Autowired
    private AddressRepositoryForRent addressRepository;

    public List<AddressForRent> getAllAddresses() {
        return addressRepository.findAll();
    }
}
