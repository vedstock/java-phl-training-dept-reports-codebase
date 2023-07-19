package com.phl.general.app.controller;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//try excel on Java
import java.io.File;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import org.apache.commons.io.IOUtils;
//
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.phl.common.config.PageWrapper;
import com.phl.common.contanst.ConstantCore;
import com.phl.common.contanst.UrlConst;
import com.phl.common.dto.ItemResult;
import com.phl.common.dto.RequestGWDto;
import com.phl.common.entity.Message;
import com.phl.common.entity.MessageList;
import com.phl.common.exception.BusException;
import com.phl.common.utils.DataPropertiesUtil;
import com.phl.common.utils.FileUtil;
import com.phl.common.utils.Util;
import com.phl.general.report.common.dto.ReportTrainingDto;
import com.phl.general.report.common.dto.ReportTrainingRequestDto;
import com.phl.general.report.common.dto.ReportPrintDto;
import com.phl.general.report.service.ReportTrainingService;

@Controller
@RequestMapping("/reports")
public class ElearningReportController {
	
	@Autowired
	private MessageSource messageSource;

	@Autowired
	ReportTrainingService reportTrainingService;

	@RequestMapping(value = "/trainingForm", method = { RequestMethod.GET })
	public ModelAndView getTrainingForm(Locale locale,@ModelAttribute(value="foo") ReportTrainingDto reportTrainingDto,
	@RequestParam(value = ConstantCore.PAGE, required = false, defaultValue = "1") int page
	){
    	ModelAndView mav = new ModelAndView("report.training.form");
    	System.out.println("0550\n");
        mav.addObject("foo", reportTrainingDto);
        return mav;
    }
	@RequestMapping(value = "/trainingForm/printExcelUrl",
			method = RequestMethod.POST)
			public String printExcelUrl(HttpServletRequest request,
			        HttpServletResponse response,
			       @ModelAttribute(value="foo") ReportTrainingDto reportTrainingDto
					) throws IOException{
				System.out.println("public String printExcelUrl\n");
				System.out.println(reportTrainingDto.getParamCohort());
				String resultCode = reportTrainingService.printRawExcelWorkbook(response,"Blanquette"); // Print Excel function
		        return null;
		    }
}
