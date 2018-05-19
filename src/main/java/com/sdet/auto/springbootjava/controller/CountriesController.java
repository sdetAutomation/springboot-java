package com.sdet.auto.springbootjava.controller;

import com.sdet.auto.springbootjava.model.CountryObject;
import com.sdet.auto.springbootjava.repository.CountriesRepository;
import com.sdet.auto.springbootjava.service.CountriesService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/countries/v1/")
public class CountriesController {

    private CountriesRepository countriesRepository;

    public CountriesController(CountriesRepository countriesRepository){
        this.countriesRepository = countriesRepository;
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.GET, produces= MediaType.APPLICATION_JSON_VALUE)
    public List<CountryObject> getCountries()  {
        CountriesService countriesService = new CountriesService(countriesRepository);
        return countriesService.getAll();
    }
}
