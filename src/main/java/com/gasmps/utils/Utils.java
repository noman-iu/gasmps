/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gasmps.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;
import java.util.Locale;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Scope;
import org.springframework.security.authentication.AuthenticationTrustResolver;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import com.gasmps.hbm.model.TblSetting;
import com.gasmps.hbm.service.TblSettingService;

/**
 *
 * @author akhtar
 */
@Component
@Scope("singleton")
public class Utils {
	
	@Autowired
	MessageSource messageSource;
	
	@Autowired
	TblSettingService tblSettingServiceImpl;
	
	//@Autowired
	//AuthenticationTrustResolver authenticationTrustResolver;
	
	
	public Utils() {
	}

	public String getMessage(Constant.GenricResponseCode genricResponseCode) {
		return messageSource.getMessage(genricResponseCode.toString(), null, Locale.getDefault());
	}
	
	public String readGalleryDataFromFile(String fileName) throws IOException {
		String path = getFolderPath(Constant.Attributes.GALARY_FOLDER);
		File file = new File(path + fileName);
		InputStream is = new FileInputStream(file);
		byte src[] = IOUtils.toByteArray(is);
		return new String(Base64.getEncoder().encode(src),"UTF-8");
	}
	
	public String getFolderPath(String folder) {
		
		TblSetting tblSetting = tblSettingServiceImpl.getSettingByKey("HOME_PATH");
		if(tblSetting == null || tblSetting.getSettingValue() == null){
			throw new NullPointerException("Home path not set!");
		}
		String path = tblSetting.getSettingValue();
		if(!path.endsWith(File.separator)) 
			path = path + File.separator;
		path = path + folder;
		if(!path.endsWith(File.separator)) 
			path = path + File.separator;
		return path;
	}
	
	/**
	 * This method returns true if users is already authenticated [logged-in], else false.
	 */
	/*public boolean isCurrentAuthenticationAnonymous() {
	    final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	    return authenticationTrustResolver.isAnonymous(authentication);
	}*/
	
}
