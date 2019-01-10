package com.example.demo.controller.queries;

public class modifyCountryQuery {

	String countryId;
	String countryName;
	public modifyCountryQuery(String countryId, String countryName) {
		super();
		this.countryId = countryId;
		this.countryName = countryName;
	}
	public modifyCountryQuery() {
		super();
	}
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
	
	
}
