package com.sdet.auto.springbootjava.controller;

import com.sdet.auto.springbootjava.model.CountryObject;
import com.sdet.auto.springbootjava.repository.CountriesRepository;
import com.sdet.auto.springbootjava.service.CountriesService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

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

    @ResponseBody
    @RequestMapping(value="{iso2}", method = RequestMethod.GET, produces= MediaType.APPLICATION_JSON_VALUE)
    public CountryObject getByCountry(@PathVariable String iso2)  {
        CountriesService countriesService = new CountriesService(countriesRepository);
        return countriesService.getByIso2(iso2);
    }

    @ResponseBody
    @RequestMapping(value="{iso2}", method = RequestMethod.PUT, produces= MediaType.APPLICATION_JSON_VALUE)
    public CountryObject update(@PathVariable String iso2, @RequestBody CountryObject countryObject)  {
        CountriesService countriesService = new CountriesService(countriesRepository);
        return countriesService.updatePopulation(iso2, countryObject);
    }
}
