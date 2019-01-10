package com.example.demo.controller.responses;

import java.math.BigDecimal;

public class Decile {
	
	private float percentage;
	private BigDecimal minSalary;
	private BigDecimal maxSalary;
	public float getPercentage() {
		return percentage;
	}
	public void setPercentage(float percentage) {
		this.percentage = percentage;
	}
	public BigDecimal getMinSalary() {
		return minSalary;
	}
	public void setMinSalary(BigDecimal minSalary) {
		this.minSalary = minSalary;
	}
	public BigDecimal getMaxSalary() {
		return maxSalary;
	}
	public void setMaxSalary(BigDecimal maxSalary) {
		this.maxSalary = maxSalary;
	}
	public Decile(float percentage, BigDecimal minSalary, BigDecimal maxSalary) {
		super();
		this.percentage = percentage;
		this.minSalary = minSalary;
		this.maxSalary = maxSalary;
	}
	public Decile() {
		super();
	}
	
	

}
