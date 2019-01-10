package com.example.demo.controller.DTO;

import java.util.List;

import com.example.demo.model.Location;

public class CountryDTO {

	private String countryId;
	private String countryName;
	private String regionName;
	private List<Location> locations;
	
	public String getCountryId() {
		return countryId;
	}
	public void setCountryId(String countryId) {
		this.countryId = countryId;
	}
	public String getCountryName() {
		return countryName;
	}
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	public String getRegionName() {
		return regionName;
	}
	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}
	public CountryDTO(String countryId, String countryName, String regionName, List<Location> locations) {
		super();
		this.countryId = countryId;
		this.countryName = countryName;
		this.regionName = regionName;
		this.locations = locations;
	}
	public CountryDTO() {
		super();
	}
	public List<Location> getLocations() {
		return locations;
	}
	public void setLocations(List<Location> locations) {
		this.locations = locations;
	}
	
	
}
