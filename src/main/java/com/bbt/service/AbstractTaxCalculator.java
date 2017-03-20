package com.bbt.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractTaxCalculator<T> {

	protected BigDecimal taxRate = null;
	protected BigDecimal total = null;
	protected String taxName = null;
	protected List<T> billList = null;

	private static BigDecimal sum = null;

	private AbstractTaxCalculator<T> nextTaxCalculator;

	public final void billList() {
		billList = new ArrayList<>();
	}

	public void nextTaxCalculator(AbstractTaxCalculator<T> taxCalculator) {
		this.nextTaxCalculator = taxCalculator;
	}

	protected void calculate() {
		sum = new BigDecimal(0);
		billList = new ArrayList<>();
		calculateTax(billList);

	}

	private void calculateTax(List<T> list) {
		BigDecimal calculatedValue = total.multiply(taxRate).divide(
				new BigDecimal(100), 2, RoundingMode.HALF_UP);
		list.add(process(calculatedValue, taxName));
		sum = sum.add(calculatedValue);
		if (nextTaxCalculator != null) {
			nextTaxCalculator.calculateTax(list);
		} else {
			list.add(process(sum, "Total"));
		}
	}

	public abstract T process(BigDecimal value, String name);

	public List<T> getListOfBill() {
		return billList;
	}

	public BigDecimal getTotal() {
		return sum;
	}
}
