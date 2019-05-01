package com.bsuir.course.domain.rent;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="address_for_rent")
public class AddressForRent {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private String town;

    private String street;

    private String house;

    private String area;

    private Double lat;

    private Double lng;
}
