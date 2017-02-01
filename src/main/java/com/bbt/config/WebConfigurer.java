package com.bbt.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.jasperreports.JasperReportsMultiFormatView;
import org.springframework.web.servlet.view.jasperreports.JasperReportsViewResolver;

@Configuration
@EnableWebMvc
public class WebConfigurer extends WebMvcConfigurerAdapter {
	
	@Override
	public void configureDefaultServletHandling(
			final DefaultServletHandlerConfigurer configurer) {

		configurer.enable();
	}

	@Bean
	public InternalResourceViewResolver getInternalResourceViewResolver() {
		System.out.println("adding view resolver");
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setViewClass(JstlView.class);
		resolver.setPrefix("classpath:views/");
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

	/*
	 * @Bean public DispatcherServlet dispatcherServlet() { return new
	 * DispatcherServlet(); }
	 * 
	 * @Bean public ServletRegistrationBean dispatchServletRegistration() {
	 * 
	 * ServletRegistrationBean registration = new ServletRegistrationBean(
	 * dispatcherServlet(), "/"); registration
	 * .setName(DispatcherServletAutoConfiguration
	 * .DEFAULT_DISPATCHER_SERVLET_REGISTRATION_BEAN_NAME);
	 * 
	 * return registration;
	 * 
	 * }
	 * 
	 * @Bean public EmbeddedServletContainerFactory servletContainer() {
	 * TomcatEmbeddedServletContainerFactory factory = new
	 * TomcatEmbeddedServletContainerFactory(); return factory; }
	 */

}
