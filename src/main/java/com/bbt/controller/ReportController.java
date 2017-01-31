package com.bbt.controller;

import java.util.ArrayList;
import java.util.List;

import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bbt.bean.Product;

@Controller
@RequestMapping("/reports")
public class ReportController {

	private static final String FORMAT = "format";

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView getAll() {
		return new ModelAndView("reports");
	}

	@RequestMapping(value = "/{reportName}", method = RequestMethod.GET)
	public ModelAndView getReportByName(
			@PathVariable("reportName") final String reportName,
			@RequestParam(FORMAT) String format) {
		ModelMap map = new ModelMap();
		List<Product> dataList = new ArrayList<>();
		dataList.add(new Product("xyz", "standard test product", "new address",
				"1", "5"));
		dataList.add(new Product("xyz", "standard test product", "new address",
				"1", "5"));
		dataList.add(new Product("xyz", "standard test product", "new address",
				"1", "5"));
		dataList.add(new Product("abc", "standard test product 2",
				"new address 2", "2", "4"));
		JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(
				dataList, false);
		map.put(FORMAT, format);
		map.put("product_id", 1);
		map.put("datasource", beanColDataSource);
		return new ModelAndView("report_" + reportName, map);
	}
}
