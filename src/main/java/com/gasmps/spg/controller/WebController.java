package com.gasmps.spg.controller;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.imgscalr.Scalr;
import org.json.JSONArray;
import org.json.JSONObject;
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
import com.gasmps.utils.Constant.Folder;
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

	@RequestMapping(value = "message", method = RequestMethod.GET)
	public String getMessage() {
		return "JSP/message";
	}

	@RequestMapping(value = "faq", method = RequestMethod.GET)
	public String getFaq() {
		return "JSP/faq";
	}

	@RequestMapping(value = "/upload", method = {RequestMethod.GET })
	public HttpServletResponse uploadGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		PrintWriter writer =null;
    	System.out.println("********************GET****************************");
        if (request.getParameter("getfile") != null 
                && !request.getParameter("getfile").isEmpty()) {
        	System.out.println("********************GET1****************************");
            File file = new File("",
                    request.getParameter("getfile"));
            System.out.println(file);
            if (file.exists()) {
                int bytes = 0;
                ServletOutputStream op = response.getOutputStream();

                response.setContentType(getMimeType(file));
                response.setContentLength((int) file.length());
                response.setHeader( "Content-Disposition", "inline; filename=\"" + file.getName() + "\"" );

                byte[] bbuf = new byte[1024];
                DataInputStream in = new DataInputStream(new FileInputStream(file));

                while ((in != null) && ((bytes = in.read(bbuf)) != -1)) {
                    op.write(bbuf, 0, bytes);
                }

                in.close();
                op.flush();
                op.close();
            }
        } else if (request.getParameter("delfile") != null && !request.getParameter("delfile").isEmpty()) {
        	System.out.println("********************GET2****************************");
            File file = new File(utils.getPath(Folder.GALARY_FOLDER), request.getParameter("delfile"));
            if (file.exists()) {
                file.delete(); // TODO:check and report success
            } 
        } else if (request.getParameter("getthumb") != null && !request.getParameter("getthumb").isEmpty()) {
        	System.out.println("********************GET3****************************");
            File file = new File(utils.getPath(Folder.GALARY_FOLDER), request.getParameter("getthumb"));
                if (file.exists()) {
                    String mimetype = getMimeType(file);
                    if (mimetype.endsWith("png") || mimetype.endsWith("jpeg") || mimetype.endsWith("gif")) {
                        BufferedImage im = ImageIO.read(file);
                        if (im != null) {
                            BufferedImage thumb = Scalr.resize(im, 75); 
                            ByteArrayOutputStream os = new ByteArrayOutputStream();
                            if (mimetype.endsWith("png")) {
                                ImageIO.write(thumb, "PNG" , os);
                                response.setContentType("image/png");
                            } else if (mimetype.endsWith("jpeg")) {
                                ImageIO.write(thumb, "jpg" , os);
                                response.setContentType("image/jpeg");
                            } else {
                                ImageIO.write(thumb, "GIF" , os);
                                response.setContentType("image/gif");
                            }
                            ServletOutputStream srvos = response.getOutputStream();
                            response.setContentLength(os.size());
                            response.setHeader( "Content-Disposition", "inline; filename=\"" + file.getName() + "\"" );
                            os.writeTo(srvos);
                            srvos.flush();
                            srvos.close();
                        }
                    }
            } // TODO: check and report success
        } else {
        	System.out.println("********************GET4****************************");
            writer = response.getWriter();
            writer.write("call POST with multipart form data");
        }
        return response;
    }
	
	@RequestMapping(value = "/upload", method = { RequestMethod.POST})
	public void uploadPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

    	System.out.println("********************POST****************************");
        if (!ServletFileUpload.isMultipartContent(request)) {
            throw new IllegalArgumentException("Request is not multipart, please 'multipart/form-data' enctype for your form.");
        }

        ServletFileUpload uploadHandler = new ServletFileUpload(new DiskFileItemFactory());
        PrintWriter writer = response.getWriter();
        response.setContentType("application/json");
        JSONArray json = new JSONArray();
        try {
            List<FileItem> items = uploadHandler.parseRequest(request);
            for (FileItem item : items) {
                if (!item.isFormField()) {
                        File file = new File(utils.getPath(Folder.GALARY_FOLDER), item.getName());
                        item.write(file);
                        JSONObject jsono = new JSONObject();
                        jsono.put("name", item.getName());
                        jsono.put("size", item.getSize());
                        jsono.put("url", "upload?getfile=" + item.getName());
                        jsono.put("thumbnail_url", "upload?getthumb=" + item.getName());
                        jsono.put("delete_url", "upload?delfile=" + item.getName());
                        jsono.put("delete_type", "GET");
                        json.put(jsono);
                }
            }
        } catch (FileUploadException e) {
                throw new RuntimeException(e);
        } catch (Exception e) {
                throw new RuntimeException(e);
        } finally {
            writer.write(json.toString());
            writer.close();
        }

    }
	
	
	 private String getMimeType(File file) {
	        String mimetype = "";
	        if (file.exists()) {
//	            URLConnection uc = new URL("file://" + file.getAbsolutePath()).openConnection();
//	            String mimetype = uc.getContentType();
//	            MimetypesFIleTypeMap gives PNG as application/octet-stream, but it seems so does URLConnection
//	            have to make dirty workaround
	            if (getSuffix(file.getName()).equalsIgnoreCase("png")) {
	                mimetype = "image/png";
	            } else {
	                javax.activation.MimetypesFileTypeMap mtMap = new javax.activation.MimetypesFileTypeMap();
	                mimetype  = mtMap.getContentType(file);
	            }
	        }
	        System.out.println("mimetype: " + mimetype);
	        return mimetype;
	    }



	    private String getSuffix(String filename) {
	        String suffix = "";
	        int pos = filename.lastIndexOf('.');
	        if (pos > 0 && pos < filename.length() - 1) {
	            suffix = filename.substring(pos + 1);
	        }
	        System.out.println("suffix: " + suffix);
	        return suffix;
	    }

}
