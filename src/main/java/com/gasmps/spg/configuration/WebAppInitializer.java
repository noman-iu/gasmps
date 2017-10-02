package com.gasmps.spg.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;


public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	static final Logger logger = LoggerFactory.getLogger(WebAppInitializer.class);
	
	public WebAppInitializer() {
		logger.info("WebAppInitializer constructor");
	}
	
	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] { WebAppConfig.class };
	}
 
	@Override
	protected Class<?>[] getServletConfigClasses() {
		return null;
	}
 
	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}
	

}
