package com.bsuir.course.domain;

import lombok.*;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="apartment")
public class Apartment {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String title;

    @Column(name="description", columnDefinition="TEXT")
    private String description;

    private String area;

    private Float price;

    private Integer roomCount;

    private Integer floor;

    private Integer maxFloor;

    private Integer visitorsCount;
}
