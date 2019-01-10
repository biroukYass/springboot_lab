package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Country;
import com.example.demo.repository.CountryRepository;

@Service("countryservice")
public class CountryServiceImpl implements CountryService {

	@Autowired
	CountryRepository countryRepository;
	
	@Override
	public List<Country> findAll() {
		return (List<Country>) countryRepository.findAll();
	}

	@Override
	public void updateCountry(String countryId, String countryName) {
		Country c= new Country();
		c.setCountryId(countryId);
		c.setCountryName(countryName);
		countryRepository.save(c);
	}
	
}
