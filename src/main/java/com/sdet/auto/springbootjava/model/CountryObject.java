package com.sdet.auto.springbootjava.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CountryObject {

    private String name;
    private String iso_2;
    private String iso_3;
    private Integer population;
    private String capital;
}
