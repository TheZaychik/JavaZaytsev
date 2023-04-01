package com.example.controlworkrestapi.services;

import com.example.controlworkrestapi.models.City;
import com.example.controlworkrestapi.repositories.CityRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class CityService {
    @Autowired
    CityRepo cityRepo;

    public List<City> getAllCities() {
        return cityRepo.findAll();
    }

    public City getCityById(Integer id) {
        return cityRepo.findById(id).get();
    }

    public void create(City city) {
        cityRepo.save(city);
    }

    public void update(City city, Integer id) {
        City cityToUpdate = cityRepo.findById(id).get();
        if (city.getName() != null) {
            cityToUpdate.setName(city.getName());
        }
        cityRepo.save(cityToUpdate);

    }

    public void delete(Integer id) {
        cityRepo.deleteById(id);
    }

}
