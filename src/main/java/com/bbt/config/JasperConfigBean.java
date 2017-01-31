package com.bbt.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author s751233
 *
 */
@Component
@ConfigurationProperties(prefix = "jasperSource")
public class JasperConfigBean {

	private String prefix;

	private String suffix;

	private String reportDataKey;

	private String viewName;

	public String getPrefix() {
		return prefix;
	}

	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

	public String getReportDataKey() {
		return reportDataKey;
	}

	public void setReportDataKey(String reportDataKey) {
		this.reportDataKey = reportDataKey;
	}

	public String getViewName() {
		return viewName;
	}

	public void setViewName(String viewName) {
		this.viewName = viewName;
	}

	public String getSuffix() {
		return suffix;
	}

	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}

}
