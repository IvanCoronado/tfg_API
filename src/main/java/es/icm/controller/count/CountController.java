package es.icm.controller.count;

import javax.servlet.http.HttpServletResponse;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiResponse;
import com.wordnik.swagger.annotations.ApiResponses;

import es.icm.config.annotation.VersionedRestController;
import es.icm.dto.out.CountDTO;

@VersionedRestController
@Api(value = "Count", description = "Información sobre conteos.")
@RequestMapping(value = "devices/{idDevice:\\d+}/counts")
public class CountController {

	@RequestMapping(method = RequestMethod.GET)
	@ApiOperation(value = "Devuelve la lista de conteos del dispositivo seleccionado.", notes = "TODO:notes")
	@ApiResponses(value = {
			@ApiResponse(code = HttpServletResponse.SC_OK, message = "Found element."),
			@ApiResponse(code = HttpServletResponse.SC_BAD_REQUEST, message = "Invalid parameter."),
			@ApiResponse(code = HttpServletResponse.SC_INTERNAL_SERVER_ERROR, message = "Ups, server error."),
			@ApiResponse(code = HttpServletResponse.SC_UNAUTHORIZED, message = "No authorized.")
	})
	public Page<CountDTO> getLocations(@PathVariable(value = "idDevice") int idDevice) {
		return null;
	}
}
