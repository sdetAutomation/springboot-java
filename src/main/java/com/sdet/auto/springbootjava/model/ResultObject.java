package com.sdet.auto.springbootjava.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResultObject {

    private String name;
    private String alpha2_code;
    private String alpha3_code;
}
