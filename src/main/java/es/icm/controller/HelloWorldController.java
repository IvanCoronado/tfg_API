package es.icm.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiResponse;
import com.wordnik.swagger.annotations.ApiResponses;

import es.icm.config.annotation.VersionedRestController;

@VersionedRestController
@Api(value = "hello", description = "Las llamadas de hello.")
public class HelloWorldController {

	@RequestMapping(value = "/hello", method = RequestMethod.POST)
	@ApiOperation(value = "Titulo de la url", notes = "Descripcción de lo que hace.")
	@ApiResponses(value = {
			@ApiResponse(code = HttpServletResponse.SC_OK, message = "Lo que sea devuelto."),
			@ApiResponse(code = HttpServletResponse.SC_INTERNAL_SERVER_ERROR, message = "Error interno del servidor.")
	})
	public String[] postHelloWorld() {
		return new String[] {
				"hello", "post"
		};
	}

	@RequestMapping(value = "/helloparam", method = RequestMethod.GET)
	public String[] getHelloWorld(
			@RequestParam(value = "param", defaultValue = "false", required = false) boolean param) {
		if (param)
			return new String[] {
					"hello", "post"
			};
		else
			return new String[] {
					"Sin param"
			};
	}

	@RequestMapping(value = "/hellopath/{n:\\d+}", method = RequestMethod.GET)
	public String[] getHelloWorldPath(@PathVariable(value = "n") int number) {

		return new String[number];
	}

}
