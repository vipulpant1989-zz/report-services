package com.bbt.service;

import java.math.BigDecimal;

import com.bbt.bean.Particular;

public class BillCalculator extends AbstractTaxCalculator<Particular> {

	public BillCalculator(String taxName, BigDecimal taxRate, BigDecimal total) {
		this.taxName = taxName;
		this.taxRate = taxRate;
		this.total = total;
	}

	@Override
	public Particular process(BigDecimal value, String name) {
		return new Particular(name, value);
	}

}
