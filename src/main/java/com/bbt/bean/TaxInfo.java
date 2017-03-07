package com.bbt.bean;

import java.math.BigDecimal;

public class TaxInfo {

	private String code;

	private BigDecimal value;

	public TaxInfo(String code, BigDecimal value) {
		this.code = code;
		this.value = value;
	}

	public String getCode() {
		return code;
	}

	public BigDecimal getValue() {
		return value;
	}

}
