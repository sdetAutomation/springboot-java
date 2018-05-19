package com.sdet.auto.springbootjava.repository;

import com.sdet.auto.springbootjava.config.Countries;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CountriesRepository extends MongoRepository<Countries, String> {

   Optional<Countries> findById(String id);
}
