package com.bsuir.course.domain.sale;

import com.bsuir.course.domain.User;
import com.bsuir.course.domain.rent.AddressForRent;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="apartment_for_sale")
public class ApartmentForSale {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String title;

    @Column(name="description", columnDefinition="TEXT")
    private String description;

    private Integer roomCount;

    private Integer floor;

    private Integer maxFloor;

    private Float price;

    private Integer visitorsCount;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "address")
    private AddressForSale address;

    @ManyToOne()
    @JoinColumn(name = "user")
    private User user;
}

