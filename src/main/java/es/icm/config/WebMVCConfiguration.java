package es.icm.config;

import javax.servlet.Filter;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.HttpPutFormContentFilter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import es.icm.config.component.CustomRequestMappingHandlerMapping;

@Configuration
public class WebMVCConfiguration extends WebMvcConfigurationSupport {

	@Value("${api.version}")
	private String	apiVersion;

	@Bean
	public RequestMappingHandlerMapping requestMappingHandlerMapping() {
		return new CustomRequestMappingHandlerMapping(apiVersion);
	}

	/**
	 * Crea un nuevo filtro que permite recibir parametros para las peticiones PUT
	 * @return El Handler personalizado.
	 */
	//	@Bean
	public Filter shallowEtagHeaderFilter() {

		return new HttpPutFormContentFilter();
	}

}
