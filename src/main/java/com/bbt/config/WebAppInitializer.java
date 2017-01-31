package com.bbt.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class WebAppInitializer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletContext)
			throws ServletException {
		AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
		ctx.register(WebConfigurer.class);
		DispatcherServlet dispatcherServlet = new DispatcherServlet(ctx);
		ServletRegistration.Dynamic servlet = servletContext.addServlet(
				"mvc-dispatcher", dispatcherServlet);
		servlet.addMapping("/");
		servlet.setLoadOnStartup(1);
	}

}
