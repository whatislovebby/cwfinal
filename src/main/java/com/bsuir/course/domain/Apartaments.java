package com.bsuir.course.domain;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "apartaments")
public class Apartaments {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String city;
    private String street;
    private String home;
    private int flat;
    private String description;
    private int price;
    private String type;
    private String photos;

    @ManyToOne()
    @JoinColumn(name = "_user")
    private User user;

    @Transient
    public String getPhotosImagePath( ) {
        if(id == null || photos == null)
            return "/img/default.png";
        return "/apart-photos/" + this.id + "/" + this.photos;
    }
}
