package com.bsuir.course.service.rent;

import com.bsuir.course.domain.rent.ApartmentForRent;
import com.bsuir.course.repository.rent.ApartmentRepositoryForRent;
import com.bsuir.course.util.Price;
import com.bsuir.course.util.PriceAndRoomCount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ApartmentForRentService {
    @Autowired
    private ApartmentRepositoryForRent apartmentRepository;

    public List<ApartmentForRent> getAllApartments() {
        return apartmentRepository.findAll();
    }

    public ApartmentForRent insertApartment(ApartmentForRent apartment) {
        return apartmentRepository.save(apartment);
    }

    public Optional<ApartmentForRent> getApartmentById(Long id) {
        return apartmentRepository.findById(id);
    }

    public List<ApartmentForRent> getApartmentsByUser(Long userId) {
        return apartmentRepository.findAllByUser_Id(userId);
    }

    public ApartmentForRent updateApartment(ApartmentForRent apartment) {
        return apartmentRepository.save(apartment);
    }

    public void deleteApartment(ApartmentForRent apartment) {
        apartmentRepository.delete(apartment);
    }


    public List<ApartmentForRent> getApartmentsByPriceBetween(Price price) {
        return apartmentRepository.findAllByPriceBetween(price.getMinPrice(), price.getMaxPrice());
    }

    public List<ApartmentForRent> getApartmentsByPriceBetweenAndRoomCountBetween(PriceAndRoomCount priceAndRoomCount) {
        return apartmentRepository.findAllByPriceBetweenAndRoomCountBetween(priceAndRoomCount.getMinPrice(), priceAndRoomCount.getMaxPrice(), priceAndRoomCount.getMinRoomCount(), priceAndRoomCount.getMaxRoomCount());
    }

    public List<ApartmentForRent> getApartmentsByPriceBetweenAndRoomCountIn(PriceAndRoomCount priceAndRoomCount) {
        Set<Integer> set = new HashSet<>();
        set.add(priceAndRoomCount.getMinRoomCount());
        set.add(priceAndRoomCount.getMaxRoomCount());
        set.add(priceAndRoomCount.getThird());
        return apartmentRepository.findAllByPriceBetweenAndRoomCountIn(priceAndRoomCount.getMinPrice(), priceAndRoomCount.getMaxPrice(), set);
    }
}
