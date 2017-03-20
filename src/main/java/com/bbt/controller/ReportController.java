package com.bbt.controller;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Collections;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
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

@Controller
@RequestMapping("/reports")
public class ReportController {

	private static final String FORMAT = "format";

	private static final String imagePath = "/static/images/bbt_logo_small.png";

	@Autowired
	GoogleDriveService driveService;

	@Autowired
	HttpSession session;

	@Autowired
	HttpServletRequest request;

	@Autowired
	ReportService reportService;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView getAll() throws Exception {
		// driveService.connect();
		return new ModelAndView("index");
	}

	@Autowired
	ApplicationContext ctx;

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView getInvoiceReport(@RequestParam(FORMAT) String format,
			@ModelAttribute Report report) throws IOException {
		ModelMap map = new ModelMap();
		BufferedImage image = ImageIO.read(getClass().getResourceAsStream(
				imagePath));
		report.setLogo(image);
		report.setParticulars(reportService.getReportParticualar(report
				.getAmount()));
		JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(
				Collections.singletonList(report), false);
		map.put(FORMAT, format);
		map.put("datasource", beanColDataSource);
		return new ModelAndView("report_bbt_invoice", map);
	}
}
