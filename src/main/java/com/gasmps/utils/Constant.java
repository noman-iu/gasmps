package com.gasmps.utils;

import java.util.regex.Pattern;

import org.springframework.stereotype.Component;

@Component
public class Constant {

	public static class RegexPattern {
		public static final Pattern EMAIL_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$",
				Pattern.CASE_INSENSITIVE);
		public static final Pattern MOBILE_REGEX = Pattern.compile("\\d{10}");
		public static final Pattern NUMBER_REGEX = Pattern.compile("\\d+");
	}
	public static final class ClientInfo {
		public static final String DEFAULT_IP = "0.0.0.0";
		public static final String DEFAULT_HOST = "localhost";
		public static final String DEFAULT_COUNTRY = "india";
		public static final String MOBILE_DEVICE = "mobile";
		public static final String DESKTOP_DEVICE = "desktop";
	}
	public static final class GenricResponseCode {
		public static final String SUCCESSFUL_MESSAGE = "Successfully sent.";
		public static final String SUCCESSFUL_CODE = "200";
		public static final String DUPLICATE_MESSAGE = "This mail is already ragistered.";
		
	}
	
	public enum Sequence {
		APPLY("APPLY_ID"),  
		APP_LOG("APP_LOG_ID"),  
		CONTACT("CONTACT_ID"),  
		SETTING("SETTING_ID"),
		SUBSCRIBE("SUBSCRIBE_ID"),
		USER_LOG("USER_LOG_ID");
		
	    public final String id;
	    private Sequence(String id) {
	        this.id = id;
	    }
	}
}
