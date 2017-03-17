package com.bbt.service;

import java.math.BigDecimal;
import java.util.List;

import com.bbt.bean.Particular;
import com.google.common.collect.ImmutableMap;

public interface ReportService {

	public static final ImmutableMap<String, ? extends Number> taxPercMap = ImmutableMap
			.of("Service Tax @ 14% ", 14, "Swachh Bharat Cess @ 0.5%", 0.5,
					"Krishi kalyan Cess @ 0.5%", 0.5);

	public List<Particular> getReportParticualar(BigDecimal amount)
			throws ArithmeticException;

}
