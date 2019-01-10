package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.controller.queries.modifyCountryQuery;
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
	public void updateCountry(modifyCountryQuery q ) {
		Country c= countryRepository.findByCountryId(q.getCountryIdOld());
		c.setCountryId(q.getCountryId());
		c.setCountryName(q.getCountryName());
		countryRepository.save(c);
	}
	
}
