package com.bsuir.course.rest.rent;

import com.bsuir.course.domain.rent.ApartmentForRent;
import com.bsuir.course.service.rent.ApartmentForRentService;
import com.bsuir.course.util.Price;
import com.bsuir.course.util.PriceAndRoomCount;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/apartments")
public class ApartmentForRentApi {

    @Autowired
    private ApartmentForRentService apartmentService;

    @GetMapping("/getAllApartments")
    private List<ApartmentForRent> getAllApartments(){
        return apartmentService.getAllApartments();
    }

    @PostMapping("/getApartmentById")
    private Optional<ApartmentForRent> getApartmentById(@RequestBody Long id){
        return apartmentService.getApartmentById(id);
    }

    @PostMapping("/getApartmentsByUser")
    private List<ApartmentForRent> getApartmentsByUser(@RequestBody Long userId){
        return apartmentService.getApartmentsByUser(userId);
    }

    @PostMapping("/insertApartment")
    private ApartmentForRent insertApartment(@RequestBody ApartmentForRent apartment) {
        return apartmentService.insertApartment(apartment);
    }

    @PostMapping("/updateApartment")
    private ApartmentForRent updateApartment(@RequestBody ApartmentForRent apartment) {
        return apartmentService.updateApartment(apartment);
    }

    @PostMapping("/deleteApartment")
    private void deleteApartment(@RequestBody ApartmentForRent apartment) {
         apartmentService.deleteApartment(apartment);
    }

    @PostMapping("/getApartmentsByPriceBetween")
    private List<ApartmentForRent> getApartmentsByPriceBetween(@RequestBody Price price) {
        return apartmentService.getApartmentsByPriceBetween(price);
    }

    @PostMapping("/getApartmentsByPriceBetweenAndRoomCountBetween")
    private List<ApartmentForRent> getApartmentsByPriceBetweenAndRoomCountBetween(@RequestBody PriceAndRoomCount priceAndRoomCount) {
        return apartmentService.getApartmentsByPriceBetweenAndRoomCountBetween(priceAndRoomCount);
    }

    @PostMapping("/getApartmentsByPriceBetweenAndRoomCountIn")
    private List<ApartmentForRent> getApartmentsByPriceBetweenAndRoomCountIn(@RequestBody PriceAndRoomCount priceAndRoomCount) {
        return apartmentService.getApartmentsByPriceBetweenAndRoomCountIn(priceAndRoomCount);
    }

    @PostMapping("/uploadImg")
    public String handleFileUpload(@RequestBody MultipartFile file){
        String name = "test";
        if (!file.isEmpty()) {
            try {
                byte[] bytes = file.getBytes();
                BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File("src/main/resources/static/img/" + name + ".jpeg")));
                stream.write(bytes);
                stream.close();
                return "You successfully uploaded " + name;
            } catch (Exception e) {
                return "You failed to upload " + name + " => " + e.getMessage();
            }
        } else {
            return "You failed to upload " + name + " because the file was empty.";
        }
    }

}
