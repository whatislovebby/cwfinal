package com.bsuir.course.rest.sale;

import com.bsuir.course.domain.sale.AddressForSale;
import com.bsuir.course.service.sale.AddressForSaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/addressSale")
public class AddressForSaleApi {
    @Autowired
    private AddressForSaleService addressService;

    @GetMapping("/getAllAddresses")
    private List<AddressForSale> getAllApartments(){
        return addressService.getAllAddresses();
    }
}
