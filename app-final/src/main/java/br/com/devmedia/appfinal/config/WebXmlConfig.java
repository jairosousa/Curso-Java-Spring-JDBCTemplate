package br.com.devmedia.appfinal.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

<<<<<<< HEAD
public class WebXmlConfig implements WebApplicationInitializer{
=======
public class WebXmlConfig implements WebApplicationInitializer {
>>>>>>> branch 'master' of https://github.com/jairosousa/Curso-Java-Spring-JDBCTemplate.git

	public void onStartup(ServletContext servletContext) throws ServletException {
		
		AnnotationConfigWebApplicationContext webContext = new AnnotationConfigWebApplicationContext();
		webContext.register(MvcConfig.class);
		webContext.setServletContext(servletContext);
		
		ServletRegistration.Dynamic reDinamic = 
				servletContext.addServlet("disparcher", new DispatcherServlet(webContext));
		
		reDinamic.setLoadOnStartup(1);
		reDinamic.addMapping("/");
	}

}
