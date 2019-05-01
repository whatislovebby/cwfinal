package com.bsuir.course.rest.sale;

import com.bsuir.course.domain.sale.ApartmentForSale;
import com.bsuir.course.service.sale.ApartmentForSaleService;
import com.bsuir.course.util.Price;
import com.bsuir.course.util.PriceAndRoomCount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/apartmentsSale")
public class ApartmentForSaleApi {

    @Autowired
    private ApartmentForSaleService apartmentService;

    @GetMapping("/getAllApartmentsSale")
    private List<ApartmentForSale> getAllApartments(){
        return apartmentService.getAllApartments();
    }

    @PostMapping("/getApartmentSaleById")
    private Optional<ApartmentForSale> getApartmentById(@RequestBody Long id){
        return apartmentService.getApartmentById(id);
    }

    @PostMapping("/getApartmentsSaleByUser")
    private List<ApartmentForSale> getApartmentsByUser(@RequestBody Long userId){
        return apartmentService.getApartmentsByUser(userId);
    }

    @PostMapping("/insertApartmentSale")
    private ApartmentForSale insertApartment(@RequestBody ApartmentForSale apartment) {
        return apartmentService.insertApartment(apartment);
    }

    @PostMapping("/updateApartmentSale")
    private ApartmentForSale updateApartment(@RequestBody ApartmentForSale apartment) {
        return apartmentService.updateApartment(apartment);
    }

    @PostMapping("/deleteApartmentSale")
    private void deleteApartment(@RequestBody ApartmentForSale apartment) {
        apartmentService.deleteApartment(apartment);
    }

    @PostMapping("/getApartmentsSaleByPriceBetween")
    private List<ApartmentForSale> getApartmentsSaleByPriceBetween(@RequestBody Price price) {
        return apartmentService.getApartmentsSaleByPriceBetween(price);
    }

    @PostMapping("/getApartmentsSaleByPriceBetweenAndRoomCountBetween")
    private List<ApartmentForSale> getApartmentsSaleByPriceBetweenAndRoomCountBetween(@RequestBody PriceAndRoomCount priceAndRoomCount) {
        return apartmentService.getApartmentsSaleByPriceBetweenAndRoomCountBetween(priceAndRoomCount);
    }

    @PostMapping("/getApartmentsSaleByPriceBetweenAndRoomCountIn")
    private List<ApartmentForSale> getApartmentsSaleByPriceBetweenAndRoomCountIn(@RequestBody PriceAndRoomCount priceAndRoomCount) {
        return apartmentService.getApartmentsSaleByPriceBetweenAndRoomCountIn(priceAndRoomCount);
    }
}
