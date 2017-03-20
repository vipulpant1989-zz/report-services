package com.bbt.service;

import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;

import com.bbt.bean.Particular;

@Service
public class ReportServiceImpl implements ReportService {

	@Override
	public List<Particular> getReportParticualar(BigDecimal amount)
			throws ArithmeticException {
		return calculate(amount);
	}

	private List<Particular> calculate(final BigDecimal price) {
		BillCalculator taxCalculator = null;
		Iterator<String> iterator = taxPercMap.keySet().iterator();
		BillCalculator next = null, current = null;
		while (iterator.hasNext()) {
			String taxString = iterator.next();
			Number taxValue = taxPercMap.get(taxString);
			if (current == null) {
				taxCalculator = new BillCalculator(taxString, new BigDecimal(
						taxValue.toString()), price);
				current = taxCalculator;
			} else {
				next = new BillCalculator(taxString, new BigDecimal(
						taxValue.toString()), price);
				current.nextTaxCalculator(next);
				current = next;
			}
		}
		taxCalculator.calculate();
		return taxCalculator.getListOfBill();
	}

}
