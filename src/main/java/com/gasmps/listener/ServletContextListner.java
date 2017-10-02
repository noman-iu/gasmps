package com.gasmps.listener;


import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ServletContextListner  implements ServletContextListener {

	public static ServletContext servletContext ; 

	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		servletContext = null;
		System.out.println("context destroyed");
		
	}

	public void contextInitialized(ServletContextEvent contextEvent) {
		// TODO Auto-generated method stub
		servletContext = contextEvent.getServletContext();
		System.out.println("context Initialized");
	}

        public static boolean setAttributeToServletContext(String key,Object value) {
         boolean ret = false;
         try
         {
         if(servletContext != null)
         {
            servletContext.setAttribute(key, value);
            ret = true;
         }
         
         }catch(Exception ex){ret = false; ex.printStackTrace(); }
         return ret;
         }
        
        public static Object getAttributeFromServletContext(String key) {
            
         if(servletContext != null)
         {
            return servletContext.getAttribute(key);
         }
         else
         {
            return null;
         }
        }
        
        
        
        	
	

        
	

}
