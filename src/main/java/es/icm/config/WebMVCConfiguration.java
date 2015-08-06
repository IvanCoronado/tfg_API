package es.icm.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import es.icm.config.component.CustomRequestMappingHandlerMapping;

@Configuration
public class WebMVCConfiguration extends WebMvcConfigurationSupport {

	@Value("${api.version}")
	private String apiVersion;

	@Bean
	public RequestMappingHandlerMapping requestMappingHandlerMapping() {
		return new CustomRequestMappingHandlerMapping(apiVersion);
	}

}
