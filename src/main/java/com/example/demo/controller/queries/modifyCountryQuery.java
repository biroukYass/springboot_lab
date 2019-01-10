package com.example.demo.controller.queries;

public class modifyCountryQuery {

	String countryId;
	String countryName;
	String countryIdOld;
	String regionName;
	public modifyCountryQuery(String countryId, String countryName) {
		super();
		this.countryId = countryId;
		this.countryName = countryName;
	}
	public modifyCountryQuery() {
		super();
	}
	
	public String getCountryIdOld() {
		return countryIdOld;
	}
	public void setCountryIdOld(String countryIdOld) {
		this.countryIdOld = countryIdOld;
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
	public String getRegionName() {
		return regionName;
	}
	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}
	public modifyCountryQuery(String countryId, String countryName, String countryIdOld, String regionName) {
		super();
		this.countryId = countryId;
		this.countryName = countryName;
		this.countryIdOld = countryIdOld;
		this.regionName = regionName;
	}
	
	
	
}
