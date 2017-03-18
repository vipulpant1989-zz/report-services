package com.bbt.config;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.jasperreports.JasperReportsMultiFormatView;
import org.springframework.web.servlet.view.jasperreports.JasperReportsViewResolver;

import com.bbt.bean.ApplicationInfo;
import com.bbt.vendor.google.GoogleServiceImpl;

@Configuration
@EnableWebMvc
public class WebConfigurer extends WebMvcConfigurerAdapter {

	@Autowired
	ApplicationInfo applicationInfo;

	private static final String[] CLASSPATH_RESOURCE_LOCATIONS = {
			"classpath:/META-INF/resources/", "classpath:/resources/",
			"classpath:/static/", "classpath:/public/" };

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {

		registry.addResourceHandler("/WEB-INF/**").addResourceLocations(
				"/WEB-INF/");//
		registry.addResourceHandler("/WEB-INF/views/**").addResourceLocations(
				"/WEB-INF/views/");//
		registry.addResourceHandler("/json/**").addResourceLocations(
				"/WEB-INF/app/json/");//
		registry.addResourceHandler("/app/**").addResourceLocations(
				"/WEB-INF/app/");//
		registry.addResourceHandler("/app/css/**").addResourceLocations(
				"/WEB-INF/app/css/");//
		registry.addResourceHandler("/app/css/vendor/**").addResourceLocations(
				"/WEB-INF/app/css/vendor/");//
		registry.addResourceHandler("/build/**").addResourceLocations(
				"/WEB-INF/build/");//
		registry.addResourceHandler("/placeholders/**").addResourceLocations(
				"/WEB-INF/app/placeholders/");//
		registry.addResourceHandler("/js/**").addResourceLocations("/app/js/");//
		registry.addResourceHandler("/img/**").addResourceLocations(
				"/WEB-INF/app/img/");//
		registry.addResourceHandler("/favicon/**").addResourceLocations(
				"/favicon/");//
		// registry.addResourceHandler("/static_reports/")
		// .addResourceLocations(
		// "/WEB-INF/static_reports/");
		
	}

	// @Override
	// public void configureDefaultServletHandling(
	// final DefaultServletHandlerConfigurer configurer) {
	//
	// configurer.enable();
	// }

	@Bean
	public InternalResourceViewResolver getInternalResourceViewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/");
		resolver.setSuffix(".html");
		resolver.setOrder(1);
		return resolver;
	}

	@Bean
	public JasperReportsViewResolver getJasperReportsViewResolver() {
		Properties subReportUrls = new Properties();
		subReportUrls.put("SubReport",
				"/WEB-INF/static_reports/table_report.jrxml");
		JasperReportsViewResolver resolver = new JasperReportsViewResolver();
		resolver.setPrefix("classpath:report/");
		resolver.setSuffix(".jrxml");
		resolver.setViewNames("*report_*");
		resolver.setViewClass(JasperReportsMultiFormatView.class);
		resolver.setSubReportUrls(subReportUrls);
		resolver.setOrder(0);
		return resolver;
	}

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName(
				"forward:/WEB-INF/index.html");
	}

	@Bean
	public GoogleServiceImpl getGoogleDriveService() {
		return new GoogleServiceImpl("bbt-web", "user");
	}

	// @Bean
	// public LocalSessionFactoryBean sessionFactory() {
	// LocalSessionFactoryBean sessionFactoryBean = new
	// LocalSessionFactoryBean();
	// sessionFactoryBean.setDataSource(dataSource);
	// sessionFactoryBean.setPackagesToScan("com.bbt");
	// Properties hibernateProperties = new Properties();
	// hibernateProperties.put("hibernate.dialect",
	// "org.hibernate.dialect.MySQLDialect");
	// hibernateProperties.put("hibernate.show_sql", true);
	// hibernateProperties.put("hibernate.hbm2ddl.auto", "update");
	//
	// sessionFactoryBean.setHibernateProperties(hibernateProperties);
	//
	// return sessionFactoryBean;
	// }

}
