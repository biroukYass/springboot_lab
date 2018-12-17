package com.example.demo.controller.DTO;

import java.math.BigDecimal;




public class JobDTO {
	
	public JobDTO() {
		super();
	}
	private String jobId;
	private String jobTitle;
	private BigDecimal maxSalary;
	private BigDecimal minSalary;
	
	public JobDTO(String jobId, String jobTitle, BigDecimal maxSalary, BigDecimal minSalary) {
		super();
		this.jobId = jobId;
		this.jobTitle = jobTitle;
		this.maxSalary = maxSalary;
		this.minSalary = minSalary;
	}
	public String getJobId() {
		return jobId;
	}
	public void setJobId(String jobId) {
		this.jobId = jobId;
	}
	public String getJobTitle() {
		return jobTitle;
	}
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
	public BigDecimal getMaxSalary() {
		return maxSalary;
	}
	public void setMaxSalary(BigDecimal maxSalary) {
		this.maxSalary = maxSalary;
	}
	public BigDecimal getMinSalary() {
		return minSalary;
	}
	public void setMinSalary(BigDecimal minSalary) {
		this.minSalary = minSalary;
	}

	
}
