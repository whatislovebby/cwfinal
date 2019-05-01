package com.bsuir.course.rest.rent;

import com.bsuir.course.domain.rent.AddressForRent;
import com.bsuir.course.service.rent.AddressForRentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/address")
public class AddressForRentApi {
    @Autowired
    private AddressForRentService addressService;

    @GetMapping("/getAllAddresses")
    private List<AddressForRent> getAllApartments(){
        return addressService.getAllAddresses();
    }
}
