package springsecurity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "springsecurity.config")
public class DemoAppConfig {

	@Bean
	public ViewResolver viewResolver() {
		// define a bean for view resolver
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();

		viewResolver.setPrefix("/Web-Inf/view/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}
}
