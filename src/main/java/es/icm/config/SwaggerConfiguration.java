package es.icm.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mangofactory.swagger.configuration.SpringSwaggerConfig;
import com.mangofactory.swagger.models.dto.ApiInfo;
import com.mangofactory.swagger.models.dto.builder.ApiInfoBuilder;
import com.mangofactory.swagger.plugin.EnableSwagger;
import com.mangofactory.swagger.plugin.SwaggerSpringMvcPlugin;

@Configuration
@EnableSwagger
public class SwaggerConfiguration {

	@Value("${api.version}")
	private String apiVersion;

	@Autowired
	private SpringSwaggerConfig springSwaggerConfig;

	@Bean
	public SwaggerSpringMvcPlugin customImpImplementation() {
		SwaggerSpringMvcPlugin swPlugin = new SwaggerSpringMvcPlugin(this.springSwaggerConfig);
		swPlugin.apiInfo(this.getApiInfo())//
				.useDefaultResponseMessages(false)//
				.includePatterns("/" + apiVersion + "/.*");
		return swPlugin;
	}

	private ApiInfo getApiInfo() {
		return new ApiInfoBuilder().title("TFG API").description("API para el TFG.").contact("dividivan@gmail.com")
				.build();
	}
}
