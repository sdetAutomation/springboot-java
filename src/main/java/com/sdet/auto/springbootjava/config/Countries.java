package com.sdet.auto.springbootjava.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "countries")
public class Countries {

    private Integer population;
    private String iso_2;
    private String capital;
}
