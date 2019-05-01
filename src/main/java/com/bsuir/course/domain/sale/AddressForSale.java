package com.bsuir.course.domain.sale;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="address_for_sale")
public class AddressForSale {

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

