package pl.kukla.krzys.consol.configuration;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * Main initializer class for web application
 *  
 * @author Krzysztof
 *
 */
public class ApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer{

	/**
	 * This class defines classes of root context of application
	 */
	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class<?>[]{HibernateConfiguration.class};
	}

	/**
	 * This class defines classes of context of application
	 */
	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class<?>[]{WebConfiguration.class};
	}

	/**
	 * This class defines mapping of servlets 
	 */
	@Override
	protected String[] getServletMappings() {
		return new String[]{"/"};
	}

}
