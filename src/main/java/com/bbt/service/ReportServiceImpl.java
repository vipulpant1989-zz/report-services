package com.bbt.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.bbt.bean.Particular;
import com.google.common.util.concurrent.AtomicDouble;

@Service
public class ReportServiceImpl implements ReportService {

	@Override
	public List<Particular> getReportParticualar(BigDecimal amount)
			throws ArithmeticException {

		return calculate(amount);
	}

	private List<Particular> calculate(final BigDecimal price) {
		List<Particular> particulars = new ArrayList<>();
		AtomicDouble total = new AtomicDouble();
		taxPercMap.forEach((taxString, taxValue) -> {
			Particular particular = new Particular();
			BigDecimal amount = price.multiply(
					new BigDecimal(taxValue.toString())).divide(
					new BigDecimal(100), 2, RoundingMode.HALF_UP);
			total.addAndGet(amount.doubleValue());
			particular.setAmount(amount);
			particular.setName(taxString);
			particulars.add(particular);
		});
		Particular particular = new Particular();
		particular.setAmount(new BigDecimal(total.doubleValue()));
		particular.setName("Total");
		particulars.add(particular);
		return particulars;
	}

}
