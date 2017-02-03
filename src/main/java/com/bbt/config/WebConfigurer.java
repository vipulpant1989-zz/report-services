package com.bbt.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.jasperreports.JasperReportsMultiFormatView;
import org.springframework.web.servlet.view.jasperreports.JasperReportsViewResolver;

@Configuration
@EnableWebMvc
public class WebConfigurer extends WebMvcConfigurerAdapter {

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/*.html").addResourceLocations(
				"/WEB-INF/views/");
		registry.addResourceHandler("/WEB-INF/views/**").addResourceLocations(
				"/WEB-INF/views/");
		registry.addResourceHandler("/json/**").addResourceLocations(
				"/app/json/");
		registry.addResourceHandler("/css/**")
				.addResourceLocations("/app/css/");
		registry.addResourceHandler("/audio/**").addResourceLocations(
				"/app/audio/");
		registry.addResourceHandler("/scripts/**").addResourceLocations(
				"/app/scripts/");
		registry.addResourceHandler("/placeholders/**").addResourceLocations(
				"/app/placeholders/");
		registry.addResourceHandler("/js/**").addResourceLocations("/app/js/");
		registry.addResourceHandler("/img/**")
				.addResourceLocations("/app/img/");
		registry.addResourceHandler("/favicon/**").addResourceLocations(
				"/favicon/");
		registry.addResourceHandler("/dist/**").addResourceLocations(
				"/app/dist/");
	}

	// @Override
	// public void configureDefaultServletHandling(
	// final DefaultServletHandlerConfigurer configurer) {
	//
	// configurer.enable();
	// }

	@Bean
	public InternalResourceViewResolver getInternalResourceViewResolver() {
		System.out.println("adding view resolver");
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".html");
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

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName(
				"forward:/WEB-INF/views/index.html");
	}

}
