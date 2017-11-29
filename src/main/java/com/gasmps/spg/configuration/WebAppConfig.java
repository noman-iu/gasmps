package com.gasmps.spg.configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@EnableWebMvc
@Configuration
@ComponentScan(basePackages = "com.gasmps")
public class WebAppConfig extends WebMvcConfigurerAdapter {

	static final Logger logger = LoggerFactory.getLogger(WebAppConfig.class);
	
	public WebAppConfig()  {
		String userName = "user7JP";
		String password = "qPPT4wvn3BVAi0Dx";
		String port = System.getenv("MYSQL_SERVICE_PORT");
		String datbaseName = "gas";
		String host = System.getenv("HOSTNAME");
		String driverName = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://"+host+":"+port+"/"+datbaseName;
		try {
		logger.info("****************WebAppConfig constructor*****************");
		
		

		logger.info("userName:"+userName);
		logger.info("password:"+password);
		logger.info("port:"+port);
		logger.info("datbaseName:"+datbaseName);
		logger.info("host:"+host);
		logger.info("urlll:"+url);
		logger.info("driverName:"+driverName);
		Class.forName(driverName);
		Connection connection = DriverManager.getConnection(url , userName , password);
		logger.info("m_connection:"+connection);
		
		logger.info("****************WebAppConfig constructor End*****************");
		}catch (Exception e) {
			logger.info("****************Errrrorrrrr*****************");
			e.printStackTrace();
			try {
				host = System.getenv("MYSQL_SERVICE_HOST");
				url = "jdbc:mysql://"+host+":"+port+"/"+datbaseName;
				Class.forName(driverName);
				Connection connection = DriverManager.getConnection(url , userName , password);
				logger.info("m_connection:"+connection);
			} catch (Exception e1) {
				logger.info("****************Errrrorrrrr2222222*****************");
				e1.printStackTrace();
			}
		}
	}
	
	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {

		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix("/WEB-INF/");
		viewResolver.setSuffix(".jsp");
		registry.viewResolver(viewResolver);
	}
	
	/**
     * Configure ResourceHandlers to serve static resources like CSS/ Javascript etc...
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**").addResourceLocations("/");
    }
    
    /**
     * Configure Converter to be used.
     * In our example, we need a converter to convert string values[Roles] to UserProfiles in newUser.jsp
     */
    /*@Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(roleToUserProfileConverter);
    }*/
	

    /**
     * Configure MessageSource to lookup any validation/error message in internationalized property files
     */
    @Bean
	public MessageSource messageSource() {
	    ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
	    messageSource.setBasename("messages");
	    return messageSource;
	}
    
    /**Optional. It's only required when handling '.' in @PathVariables which otherwise ignore everything after last '.' in @PathVaidables argument.
     * It's a known bug in Spring [https://jira.spring.io/browse/SPR-6164], still present in Spring 4.1.7.
     * This is a workaround for this issue.
     */
    @Override
    public void configurePathMatch(PathMatchConfigurer matcher) {
        matcher.setUseRegisteredSuffixPatternMatch(true);
    }
}

