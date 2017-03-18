package com.bbt.advice;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class handleExceptions{

	
	Logger logger = Logger.getLogger(getClass());
	@ExceptionHandler(Exception.class)
	public ModelAndView handleException(HttpServletRequest request,
			Exception exception) {
		logger.error("Internal server error ", exception);
		ModelAndView mav = new ModelAndView();
		mav.addObject("exception", exception);
		mav.addObject("url", request.getRequestURL());
		mav.addObject("timestamp", new Date().toString());
		mav.addObject("status", 500);
		mav.setViewName("errors");
		return mav;
	}

	@ExceptionHandler(NoHandlerFoundException.class)
	public ModelAndView handleNotFoundException(HttpServletRequest request,
			Exception exception) {

		logger.error("Requested resource not found :" + request.getRequestURI());
		ModelAndView mav = new ModelAndView();
		mav.addObject("exception", exception);
		mav.addObject("url", request.getRequestURL());
		mav.addObject("timestamp", new Date().toString());
		mav.addObject("status", 404);
		mav.setViewName("errors");
		return mav;
	}
}
