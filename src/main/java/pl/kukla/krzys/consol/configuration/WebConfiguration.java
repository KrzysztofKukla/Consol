package pl.kukla.krzys.consol.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * This class is main web application class
 * 
 * @author Krzysztof
 *
 */
@Configuration
@EnableWebMvc
@ComponentScan("pl.kukla.krzys.consol.web")
public class WebConfiguration extends WebMvcConfigurerAdapter{
	@Bean
	public ViewResolver view(){
		InternalResourceViewResolver view =  new InternalResourceViewResolver();
		view.setPrefix("/WEB-INF/views/");
		view.setSuffix(".jsp");
		return view;
	}
}
