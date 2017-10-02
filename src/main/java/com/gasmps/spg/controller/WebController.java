package com.gasmps.spg.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gasmps.hbm.model.TblSubscribe;
import com.gasmps.hbm.model.TblUserLog;
import com.gasmps.hbm.service.TblSequenceService;
import com.gasmps.hbm.service.TblSubscribeService;
import com.gasmps.hbm.service.TblUserLogService;
import com.gasmps.utils.Constant;
import com.gasmps.utils.GenricRespone;
import com.gasmps.utils.WebUtils;

@Controller
@RequestMapping("/")
public class WebController {

	@Autowired
	TblSequenceService tblSequenceService;
	
	@Autowired
	TblUserLogService tblUserLogService;
	
	@Autowired
	TblSubscribeService tblSubscribeService;
	
	static final Logger logger = LoggerFactory.getLogger(WebController.class);
	
	public WebController() {
		logger.info("WebController constructor");
	}

	@RequestMapping(value = {"/","/index"}, method = RequestMethod.GET)
	public String index(HttpServletRequest request, HttpServletResponse response) throws Exception {
		TblUserLog tblUserLog = new TblUserLog();
		tblUserLog.setLogIp(WebUtils.getIp(request));
		tblUserLog.setLogHost(WebUtils.getHost(request));
		tblUserLog.setLogClient(WebUtils.getDevice(request));
		tblUserLog.setLogLocation(WebUtils.getCountry(request));
		tblUserLogService.saveLog(tblUserLog);
		return "index";
	}

	@PostMapping(value = "saveSubscribe", produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public GenricRespone saveEmployee(@ModelAttribute @Valid TblSubscribe subscribe, BindingResult result) throws Exception {
		GenricRespone respone = new GenricRespone();
		Map<String, String> message = new HashMap<>();
		if (result.hasErrors()) {
			message = result.getFieldErrors().stream()
					.collect(Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage));
			respone.setStatus(false);
			respone.setMessage(message);
		} else {
			TblSubscribe tblSubscribe = tblSubscribeService.getSubscribeByEmail(subscribe.getSubscribeEmail());
			if(tblSubscribe == null) {
			tblSubscribeService.saveSubscribe(subscribe);
			message.put(Constant.GenricResponseCode.SUCCESSFUL_CODE, Constant.GenricResponseCode.SUCCESSFUL_MESSAGE);
			respone.setStatus(true);
			respone.setMessage(message);
			}
			else {
				message.put(Constant.GenricResponseCode.DUPLICATE_MESSAGE, Constant.GenricResponseCode.DUPLICATE_MESSAGE);
				respone.setStatus(true);
				respone.setMessage(message);
			}
		}
		return respone;
	}

}
