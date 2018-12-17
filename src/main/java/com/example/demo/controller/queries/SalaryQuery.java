package com.example.demo.controller.queries;

import java.math.BigDecimal;

public class SalaryQuery {
	private BigDecimal minSalary;

	public SalaryQuery() {
		super();
	}

	public BigDecimal getMinSalary() {
		return minSalary;
	}

	public void setMinSalary(BigDecimal minSalary) {
		this.minSalary = minSalary;
	}

	public SalaryQuery(BigDecimal minSalary) {
		super();
		this.minSalary = minSalary;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((minSalary == null) ? 0 : minSalary.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SalaryQuery other = (SalaryQuery) obj;
		if (minSalary == null) {
			if (other.minSalary != null)
				return false;
		} else if (!minSalary.equals(other.minSalary))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "SalaryQuery [minSalary=" + minSalary + "]";
	}

}
