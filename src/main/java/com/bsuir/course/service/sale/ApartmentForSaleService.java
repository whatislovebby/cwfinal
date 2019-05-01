package com.bsuir.course.service.sale;

import com.bsuir.course.domain.sale.ApartmentForSale;
import com.bsuir.course.repository.sale.ApartmentRepositoryForSale;
import com.bsuir.course.util.Price;
import com.bsuir.course.util.PriceAndRoomCount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class ApartmentForSaleService {
    @Autowired
    private ApartmentRepositoryForSale apartmentRepository;

    public List<ApartmentForSale> getAllApartments() {
        return apartmentRepository.findAll();
    }

    public ApartmentForSale insertApartment(ApartmentForSale apartment) {
        return apartmentRepository.save(apartment);
    }

    public Optional<ApartmentForSale> getApartmentById(Long id) {
        return apartmentRepository.findById(id);
    }

    public List<ApartmentForSale> getApartmentsByUser(Long userId) {
        return apartmentRepository.findAllByUser_Id(userId);
    }

    public ApartmentForSale updateApartment(ApartmentForSale apartment) {
        return apartmentRepository.save(apartment);
    }

    public void deleteApartment(ApartmentForSale apartment) {
        apartmentRepository.delete(apartment);
    }

    public List<ApartmentForSale> getApartmentsSaleByPriceBetween(Price price) {
        return apartmentRepository.findAllByPriceBetween(price.getMinPrice(), price.getMaxPrice());
    }

    public List<ApartmentForSale> getApartmentsSaleByPriceBetweenAndRoomCountBetween(PriceAndRoomCount priceAndRoomCount) {
        return apartmentRepository.findAllByPriceBetweenAndRoomCountBetween(priceAndRoomCount.getMinPrice(), priceAndRoomCount.getMaxPrice(), priceAndRoomCount.getMinRoomCount(), priceAndRoomCount.getMaxRoomCount());
    }

    public List<ApartmentForSale> getApartmentsSaleByPriceBetweenAndRoomCountIn(PriceAndRoomCount priceAndRoomCount) {
        Set<Integer> set = new HashSet<>();
        set.add(priceAndRoomCount.getMinRoomCount());
        set.add(priceAndRoomCount.getMaxRoomCount());
        set.add(priceAndRoomCount.getThird());
        return apartmentRepository.findAllByPriceBetweenAndRoomCountIn(priceAndRoomCount.getMinPrice(), priceAndRoomCount.getMaxPrice(), set);
    }
}
