package com.gasmps.spg.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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
import org.springframework.web.bind.annotation.SessionAttributes;

import com.gasmps.hbm.model.TblApply;
import com.gasmps.hbm.model.TblContact;
import com.gasmps.hbm.model.TblGallery;
import com.gasmps.hbm.model.TblLogin;
import com.gasmps.hbm.model.TblSubscribe;
import com.gasmps.hbm.model.TblUserLog;
import com.gasmps.hbm.service.TblAppLogService;
import com.gasmps.hbm.service.TblContactService;
import com.gasmps.hbm.service.TblGalleryService;
import com.gasmps.hbm.service.TblSequenceService;
import com.gasmps.hbm.service.TblSubscribeService;
import com.gasmps.hbm.service.TblUserLogService;
import com.gasmps.utils.Constant.GenricResponseCode;
import com.gasmps.utils.GenricRespone;
import com.gasmps.utils.Utils;
import com.gasmps.utils.WebUtils;

@Controller
@RequestMapping("/")
@SessionAttributes("galleryId")
public class WebController {

	String galleryId;

	@Autowired
	Utils utils;

	@Autowired
	TblSequenceService tblSequenceServiceImpl;

	@Autowired
	TblUserLogService tblUserLogServiceImpl;

	@Autowired
	TblAppLogService tblAppLogServiceImpl;

	@Autowired
	TblSubscribeService tblSubscribeServiceImpl;

	@Autowired
	TblContactService tblContactServiceImpl;

	@Autowired
	TblGalleryService tblGalleryServiceImpl;

	static final Logger logger = LoggerFactory.getLogger(WebController.class);

	public WebController() {
		logger.info("WebController constructor");
	}

	@ModelAttribute("galleryId")
	public String initializeSession() {
		return galleryId = "0";
	}

	@RequestMapping(value = { "/", "/index" }, method = { RequestMethod.GET, RequestMethod.POST })
	public String getIndexPage(HttpServletRequest request, HttpServletResponse response) throws Exception {
		TblUserLog tblUserLog = new TblUserLog();
		tblUserLog.setLogIp(WebUtils.getIp(request));
		tblUserLog.setLogHost(WebUtils.getHost(request));
		tblUserLog.setLogClient(WebUtils.getDevice(request));
		tblUserLog.setLogLocation(WebUtils.getCountry(request));
		tblUserLogServiceImpl.saveLog(tblUserLog);
		return "JSP/index";
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
			TblSubscribe tblSubscribe = tblSubscribeServiceImpl.getSubscribeByEmail(subscribe.getSubscribeEmail());
			if (tblSubscribe == null) {
				tblSubscribeServiceImpl.saveSubscribe(subscribe);
				respone.setMessage(utils.getMessage(GenricResponseCode.GENRIC_SUCCESSFUL_MESSAGE));
				respone.setStatus(true);
			} else {
				respone.setMessage(utils.getMessage(GenricResponseCode.GENRIC_DUPLICATE_MESSAGE));
				respone.setStatus(true);
			}
		}
		return respone;
	}

	@RequestMapping(value = "applyOnline", method = RequestMethod.GET)
	public String getApplyOnlineForm(ModelMap model) {
		model.addAttribute("tblApply", new TblApply());
		return "JSP/apply-online";
	}

	@RequestMapping(value = "applyOnline", method = RequestMethod.POST)
	public String saveApplyOnlineForm(@Valid TblApply tblApply, BindingResult bindingResult, ModelMap model) {
		GenricRespone respone = new GenricRespone();
		respone.setStatus(true);
		respone.setMessage("ok");
		model.addAttribute("res", respone);
		return "JSP/apply-online";
	}

	@RequestMapping(value = "contact", method = RequestMethod.GET)
	public String getContact(ModelMap model) {
		model.addAttribute("tblContact", new TblContact());
		return "JSP/contact";
	}

	@RequestMapping(value = "contact", method = RequestMethod.POST)
	public String saveContact(@Valid TblContact tblContact, BindingResult bindingResult, ModelMap model)
			throws Exception {
		GenricRespone respone = new GenricRespone();
		if (bindingResult.hasErrors()) {
			respone.setMessage(bindingResult.getFieldError().getDefaultMessage());
			respone.setStatus(false);
		} else {
			tblContactServiceImpl.saveContact(tblContact);
			respone.setStatus(true);
			respone.setMessage(utils.getMessage(GenricResponseCode.GENRIC_SUCCESSFUL_MESSAGE));
			model.addAttribute("res", respone);
		}
		return "JSP/contact";
	}

	@RequestMapping(value = "gallery", method = RequestMethod.GET)
	public String getGallery(ModelMap model) throws IOException {
		List<TblGallery> tblGalleryList = tblGalleryServiceImpl.getNextRecordFromGalleryId(galleryId);
		ArrayList<Object> container = new ArrayList<>();
		ArrayList<Object> data = null;
		TblGallery tblGallery = null;
		Iterator<TblGallery> it = tblGalleryList.iterator();
		if (!(tblGalleryList.size() > 2))
			return "JSP/gallery";

		while (it.hasNext()) {
			tblGallery = it.next();

			data = new ArrayList<>();
			data.add(utils.readGalleryDataFromFile(tblGallery.getGalleryName()));
			data.add(tblGallery.getGalleryHeading());
			data.add(tblGallery.getGalleryDescription());
			data.add(tblGallery.getGalleryTime());

			tblGallery = it.next();
			data.add(utils.readGalleryDataFromFile(tblGallery.getGalleryName()));
			data.add(tblGallery.getGalleryHeading());
			data.add(tblGallery.getGalleryDescription());
			data.add(tblGallery.getGalleryTime());

			container.add(data);
			// galleryId = tblGallery.getGalleryId();
		}
		model.addAttribute("res", container);
		return "JSP/gallery";
	}

	@RequestMapping(value = "login", method = RequestMethod.GET)
	public String getLogin(ModelMap model) {
		model.addAttribute("tblLogin", new TblLogin());
		return "JSP/login";
	}

	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String validateUserLogin(@Valid TblLogin tblLogin, BindingResult bindingResult, ModelMap model) {
		if (tblLogin.getLoginEmail().equalsIgnoreCase("admin@gmail.com")
				&& tblLogin.getLoginPassword().equals("admin@123")) {
			return "JSP/admin";
		}
		return "JSP/404";
	}

	@RequestMapping(value = "server/php", method = { RequestMethod.POST, RequestMethod.GET })
	// public String upload(@RequestParam CommonsMultipartFile file,HttpSession
	// session){
	public String upload() {
		/*
		 * String path = session.getServletContext().getRealPath("/"); String filename =
		 * file.getOriginalFilename();
		 * 
		 * System.out.println(path+"*************************************** "+filename);
		 * try{ byte barr[] = file.getBytes();
		 * 
		 * BufferedOutputStream bout = new BufferedOutputStream( new
		 * FileOutputStream(path+"/"+filename)); bout.write(barr); bout.flush();
		 * bout.close();
		 * 
		 * }catch(Exception e){System.out.println(e);}
		 */
		return "{\"files\": [\r\n" + "  {\r\n" + "    \"name\": \"picture1.jpg\",\r\n" + "    \"size\": 902604,\r\n"
				+ "    \"url\": \"http:\\/\\/example.org\\/files\\/picture1.jpg\",\r\n"
				+ "    \"thumbnailUrl\": \"http:\\/\\/example.org\\/files\\/thumbnail\\/picture1.jpg\",\r\n"
				+ "    \"deleteUrl\": \"http:\\/\\/example.org\\/files\\/picture1.jpg\",\r\n"
				+ "    \"deleteType\": \"DELETE\"\r\n" + "  },\r\n" + "  {\r\n" + "    \"name\": \"picture2.jpg\",\r\n"
				+ "    \"size\": 841946,\r\n" + "    \"url\": \"http:\\/\\/example.org\\/files\\/picture2.jpg\",\r\n"
				+ "    \"thumbnailUrl\": \"http:\\/\\/example.org\\/files\\/thumbnail\\/picture2.jpg\",\r\n"
				+ "    \"deleteUrl\": \"http:\\/\\/example.org\\/files\\/picture2.jpg\",\r\n"
				+ "    \"deleteType\": \"DELETE\"\r\n" + "  }\r\n" + "]}";
	}

	@RequestMapping(value = "message", method = RequestMethod.GET)
	public String getMessage() {
		return "JSP/message";
	}
	
	
	@RequestMapping(value = "faq", method = RequestMethod.GET)
	public String getFaq() {
		return "JSP/faq";
	}

}
