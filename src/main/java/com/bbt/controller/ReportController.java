package com.bbt.controller;

import java.util.Collections;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bbt.bean.Report;
import com.bbt.service.ReportService;
import com.bbt.vendor.google.GoogleDriveService;
import com.google.api.services.drive.Drive;

@Controller
@RequestMapping("/reports")
public class ReportController {

	private static final String FORMAT = "format";

	@Autowired
	GoogleDriveService driveService;

	@Autowired
	HttpSession session;

	@Autowired
	HttpServletResponse response;

	public Drive drive = null;

	@Autowired
	ReportService reportService;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView getAll() throws Exception {
		// driveService.connect();
		return new ModelAndView("index");
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView getInvoiceReport(@RequestParam(FORMAT) String format,
			@ModelAttribute Report report) {
		ModelMap map = new ModelMap();
		report.setParticulars(reportService.getReportParticualar(report
				.getAmount()));
		JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(
				Collections.singletonList(report), false);
		map.put(FORMAT, format);
		map.put("datasource", beanColDataSource);
		map.put("particulars", report.getParticulars());
		return new ModelAndView("report_bbt_invoice", map);
	}

}
