package com.sdet.auto.springbootjava.service;

import com.sdet.auto.springbootjava.config.Countries;
import com.sdet.auto.springbootjava.model.CountryObject;
import com.sdet.auto.springbootjava.model.ResultObject;
import com.sdet.auto.springbootjava.proxy.GroupktProxy;
import com.sdet.auto.springbootjava.repository.CountriesRepository;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CountriesService {

    private CountriesRepository countriesRepository;

    private static CountryObject countryObject = new CountryObject();
    private static List<CountryObject> countriesList = new ArrayList<>();

    public CountriesService(CountriesRepository countriesRepository) {
        this.countriesRepository = countriesRepository;
    }

    public List<CountryObject> getAll(){

        countriesList.clear();

        List<Countries> ListOfCountries = countriesRepository.findAll();

        for (Countries country : ListOfCountries){
            // make call to get country name and 3digit iso
            ResultObject resultObject = GroupktProxy.getGroupktInfo(country.getIso2());

            CountryObject countryObject = new CountryObject();

            countryObject.setName(resultObject.getName());
            countryObject.setIso_2(country.getIso2());
            countryObject.setIso_3(resultObject.getAlpha3_code());
            countryObject.setPopulation(country.getPopulation());
            countryObject.setCapital(country.getCapital());

            countriesList.add(countryObject);
        }

        return countriesList;
    }

    public CountryObject getByIso2(String iso2) {

        Optional<Countries> country = countriesRepository.findById(iso2.toUpperCase());

        // make call to get country name and 3digit iso
        ResultObject resultObject = GroupktProxy.getGroupktInfo(country.get().getIso2());

        CountryObject countryObject = new CountryObject();

        countryObject.setName(resultObject.getName());
        countryObject.setIso_2(country.get().getIso2());
        countryObject.setIso_3(resultObject.getAlpha3_code());
        countryObject.setPopulation(country.get().getPopulation());
        countryObject.setCapital(country.get().getCapital());

        return countryObject;
    }
}