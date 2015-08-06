package es.icm.controller;

import java.util.Calendar;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiResponse;
import com.wordnik.swagger.annotations.ApiResponses;

import es.icm.config.annotation.VersionedRestController;
import es.icm.dto.out.PersonaDTO;

@VersionedRestController
@Api(value = "Persona", description = "Llamadas sobre personas.")
public class PersonaController {

	@RequestMapping(value = "/persona/{name:\\w+}", method = RequestMethod.GET)
	@ApiOperation(value = "Obtiene persona", notes = "Devuelve una persona con el nombre pasado por parametro.")
	@ApiResponses(value = {
			@ApiResponse(code = HttpServletResponse.SC_OK, message = "Persona devuelta."),
			@ApiResponse(code = HttpServletResponse.SC_BAD_REQUEST, message = "Parametro incorrecto."),
			@ApiResponse(code = HttpServletResponse.SC_INTERNAL_SERVER_ERROR, message = "Error interno del servidor.")
	})
	public PersonaDTO getHelloWorld(@PathVariable(value = "name") String name) {
		PersonaDTO persona = new PersonaDTO(Calendar.getInstance(), name, name.length());
		return persona;
	}

}
