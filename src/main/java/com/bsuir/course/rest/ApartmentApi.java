package com.bsuir.course.rest;

import com.bsuir.course.domain.Apartment;
import com.bsuir.course.service.ApartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/apartments")
public class ApartmentApi {

    @Autowired
    private ApartmentService apartmentService;

    @GetMapping("/getAllApartments")
    private List<Apartment> getAllApartments(){
        return apartmentService.getAllApartments();
    }
}
