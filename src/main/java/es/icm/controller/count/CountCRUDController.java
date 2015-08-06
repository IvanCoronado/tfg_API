package es.icm.controller.count;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiResponse;
import com.wordnik.swagger.annotations.ApiResponses;

import es.icm.config.annotation.VersionedRestController;
import es.icm.dto.in.CreateCountDTO;
import es.icm.dto.out.CountDTO;

@VersionedRestController
@Api(value = "Count", description = "Permite crear conteos.")
public class CountCRUDController {

	@RequestMapping(value = "devices/{idDevice:\\d+}/counts", method = RequestMethod.POST, consumes = "aplication/json")
	@ApiOperation(value = "Crea una localización para el cliente seleccionado.", notes = "TODO:notes")
	@ApiResponses(value = {
			@ApiResponse(code = HttpServletResponse.SC_CREATED, message = "Element created."),
			@ApiResponse(code = HttpServletResponse.SC_BAD_REQUEST, message = "Invalid parameter."),
			@ApiResponse(code = HttpServletResponse.SC_INTERNAL_SERVER_ERROR, message = "Ups, server error."),
			@ApiResponse(code = HttpServletResponse.SC_UNAUTHORIZED, message = "No authorized.")
	})
	public CountDTO createLocation(
			@PathVariable(value = "idDevice") int idDevice,
			@Valid @RequestBody CreateCountDTO countInit) {

		CountDTO count = null;
		return count;
	}

}
