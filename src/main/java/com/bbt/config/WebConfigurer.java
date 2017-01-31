package com.bbt.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.jasperreports.JasperReportsMultiFormatView;
import org.springframework.web.servlet.view.jasperreports.JasperReportsViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan("com.bbt")
public class WebConfigurer extends WebMvcConfigurerAdapter {

	@Autowired
	JasperConfigBean jasperConfigBean;

	@Bean
	public InternalResourceViewResolver getInternalResourceViewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setViewClass(JstlView.class);
		resolver.setPrefix("/views/");
		resolver.setSuffix(".jsp");
		resolver.setOrder(1);
		return resolver;
	}

	@Bean
	public JasperReportsViewResolver getJasperReportsViewResolver() {
		JasperReportsViewResolver resolver = new JasperReportsViewResolver();
		resolver.setPrefix("classpath:report/");
		resolver.setSuffix(".jrxml");

		// resolver.setReportDataKey("datasource");
		resolver.setViewNames("*report_*");
		resolver.setViewClass(JasperReportsMultiFormatView.class);
		resolver.setOrder(0);
		return resolver;
	}

	// @Override
	// public void configureDefaultServletHandling(
	// final DefaultServletHandlerConfigurer configurer) {
	// configurer.enable();
	// }
}
