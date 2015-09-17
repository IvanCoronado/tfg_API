package es.icm;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;

/**
 * ServletInitializer is necessary for run SpringBoot Application in tomcat.
 */
public class ServletInitializer extends SpringBootServletInitializer {

	@Override
	protected final SpringApplicationBuilder configure(SpringApplicationBuilder application) {

		return application.sources(TfgApiApplication.class);
	}

}
