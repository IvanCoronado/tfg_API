package es.icm.config.component;

import java.lang.reflect.Method;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.servlet.mvc.condition.PatternsRequestCondition;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import es.icm.config.annotation.VersionedRestController;

public class CustomRequestMappingHandlerMapping extends RequestMappingHandlerMapping {
	private final String apiVersion;

	public CustomRequestMappingHandlerMapping(final String apiVersion) {
		super();
		this.apiVersion = apiVersion;
	}

	protected RequestMappingInfo getMappingForMethod(Method method, Class<?> handlerType) {
		RequestMappingInfo info = super.getMappingForMethod(method, handlerType);

		if (info != null && handlerType.isAnnotationPresent(VersionedRestController.class)) {
			List<String> myPattern = info.getPatternsCondition().getPatterns().stream()
					.map(p -> "/" + apiVersion.concat(p)).collect(Collectors.toList());

			RequestMappingInfo myinfo = new RequestMappingInfo(info.getName(), //
					new PatternsRequestCondition(myPattern.toArray(new String[] {}), //
							getUrlPathHelper(), //
							getPathMatcher(), //
							this.useRegisteredSuffixPatternMatch(), //
							this.useTrailingSlashMatch(), this.getFileExtensions()), //
					info.getMethodsCondition(), info.getParamsCondition(), info.getHeadersCondition(),
					info.getConsumesCondition(), info.getProducesCondition(), info.getCustomCondition());

			return myinfo;
		} else {
			return info;
		}
	}

}
