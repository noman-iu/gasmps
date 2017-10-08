package com.gasmps.spg.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gasmps.hbm.model.TblApply;
import com.gasmps.hbm.model.TblContact;
import com.gasmps.hbm.model.TblSubscribe;
import com.gasmps.hbm.model.TblUserLog;
import com.gasmps.hbm.service.TblContactService;
import com.gasmps.hbm.service.TblSequenceService;
import com.gasmps.hbm.service.TblSubscribeService;
import com.gasmps.hbm.service.TblUserLogService;
import com.gasmps.utils.Constant.GenricResponseCode;
import com.gasmps.utils.GenricRespone;
import com.gasmps.utils.Global;
import com.gasmps.utils.WebUtils;

@Controller
@RequestMapping("/")
public class WebController {

	@Autowired
	Global global;
	
	@Autowired
	TblSequenceService tblSequenceService;

	@Autowired
	TblUserLogService tblUserLogService;

	@Autowired
	TblSubscribeService tblSubscribeService;

	@Autowired
	TblContactService tblContactService;

	static final Logger logger = LoggerFactory.getLogger(WebController.class);

	public WebController() {
		logger.info("WebController constructor");
	}

	@RequestMapping(value = { "/", "/index" }, method = { RequestMethod.GET, RequestMethod.POST })
	public String getIndexPage(HttpServletRequest request, HttpServletResponse response) throws Exception {
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
	public GenricRespone saveSubscribe(@ModelAttribute @Valid TblSubscribe subscribe, BindingResult bindingResult)
			throws Exception {
		GenricRespone respone = new GenricRespone();
		if (bindingResult.hasErrors()) {
			// message =
			// result.getFieldErrors().stream().collect(Collectors.toMap(FieldError::getField,
			// FieldError::getDefaultMessage));
			respone.setMessage(bindingResult.getFieldError().getDefaultMessage());
			respone.setStatus(false);
		} else {
			TblSubscribe tblSubscribe = tblSubscribeService.getSubscribeByEmail(subscribe.getSubscribeEmail());
			if (tblSubscribe == null) {
				tblSubscribeService.saveSubscribe(subscribe);
				respone.setMessage(global.getMessage(GenricResponseCode.GENRIC_SUCCESSFUL_MESSAGE));
				respone.setStatus(true);
			} else {
				respone.setMessage(global.getMessage(GenricResponseCode.GENRIC_DUPLICATE_MESSAGE));
				respone.setStatus(true);
			}
		}
		return respone;
	}

	@RequestMapping(value = "applyOnline", method = RequestMethod.GET)
	public String getApplyOnlineForm(ModelMap model) {
		model.addAttribute("tblApply", new TblApply());
		return "apply-online";
	}

	@RequestMapping(value = "applyOnline", method = RequestMethod.POST)
	public String saveApplyOnlineForm(@Valid TblApply tblApply, BindingResult bindingResult, ModelMap model) {
		GenricRespone respone = new GenricRespone();
		respone.setStatus(true);
		respone.setMessage("ok");
		model.addAttribute("res", respone);
		return "apply-online";
	}

	@RequestMapping(value = "contact", method = RequestMethod.GET)
	public String getContact(ModelMap model) {
		model.addAttribute("tblContact", new TblContact());
		return "contact";
	}

	@RequestMapping(value = "contact", method = RequestMethod.POST)
	public String saveContact(@Valid TblContact tblContact, BindingResult bindingResult, ModelMap model) throws Exception {
		GenricRespone respone = new GenricRespone();
		if (bindingResult.hasErrors()) {
			respone.setMessage(bindingResult.getFieldError().getDefaultMessage());
			respone.setStatus(false);
		} else {
			tblContactService.saveContact(tblContact);
			respone.setStatus(true);
			respone.setMessage(global.getMessage(GenricResponseCode.GENRIC_SUCCESSFUL_MESSAGE));
			model.addAttribute("res", respone);
		}
		return "contact";
	}

}
