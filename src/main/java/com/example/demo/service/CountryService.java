package com.example.demo.service;

import java.util.List;

import com.example.demo.controller.queries.modifyCountryQuery;
import com.example.demo.model.Country;

public interface CountryService {

	public List<Country> findAll();
	public void updateCountry(modifyCountryQuery q );
}
