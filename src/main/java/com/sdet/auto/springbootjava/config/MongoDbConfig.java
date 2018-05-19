package com.sdet.auto.springbootjava.config;

import com.sdet.auto.springbootjava.repository.CountriesRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoRepositories(basePackageClasses = CountriesRepository.class)
@Configuration
public class MongoDbConfig {

    @Bean
    CommandLineRunner commandLineRunner(CountriesRepository countryRepository){
            return args -> {
                countryRepository.save(new Countries(1324171354, "IN", "New Delhi"));
                countryRepository.save(new Countries(34656032,"AF", "Kabul"));
                countryRepository.save(new Countries(7409800, "HK", "Hong Kong"));
                countryRepository.save(new Countries(9269612, "AE", "Abu Dhabi"));
                countryRepository.save(new Countries(25789024, "AO", "Luanda"));
            };
    }
}