package com.bbt.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
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

	private List<Particular> calculate(final BigDecimal total) {
		List<Particular> particulars = new ArrayList<>();
		taxPercMap.forEach((taxString, taxValue) -> {
			Particular particular = new Particular();
			BigDecimal amount = total.divide(
					new BigDecimal(taxValue.toString()), 2,
					RoundingMode.HALF_UP).multiply(new BigDecimal(100));
			particular.setAmount(amount);
			particular.setName(taxString);
			particulars.add(particular);
		});
		return particulars;
	}

}
