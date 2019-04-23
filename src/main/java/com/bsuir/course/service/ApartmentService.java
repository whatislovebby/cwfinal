package com.bsuir.course.service;

import com.bsuir.course.domain.Apartment;
import com.bsuir.course.repository.ApartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApartmentService {
    @Autowired
    private ApartmentRepository apartmentRepository;

    public List<Apartment> getAllApartments() {
        return apartmentRepository.findAll();
    }
}
