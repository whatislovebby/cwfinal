package com.bsuir.course.util;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PriceAndRoomCount {
    private Float minPrice;
    private Float maxPrice;
    private Integer minRoomCount;
    private Integer maxRoomCount;
    private Integer third;
}
