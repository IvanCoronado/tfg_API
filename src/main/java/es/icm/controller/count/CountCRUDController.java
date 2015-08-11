package es.icm.controller.count;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiResponse;
import com.wordnik.swagger.annotations.ApiResponses;

import es.icm.bussiness.CountManager;
import es.icm.config.annotation.VersionedRestController;
import es.icm.dto.in.CreateCountDTO;

@VersionedRestController
@Api(value = "Count", description = "Permite crear conteos.")
public class CountCRUDController {
	@Autowired
	private CountManager countManager;

	@RequestMapping(value = "devices/{idDevice:\\d+}/counts",
					method = RequestMethod.POST,
					consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Añade un contador para el dispositivo seleccionado.", notes = "TODO:notes")
	@ApiResponses(value = {
			@ApiResponse(code = HttpServletResponse.SC_CREATED, message = "Element created."),
			@ApiResponse(code = HttpServletResponse.SC_BAD_REQUEST, message = "Invalid parameter."),
			@ApiResponse(code = HttpServletResponse.SC_INTERNAL_SERVER_ERROR, message = "Ups, server error."),
			@ApiResponse(code = HttpServletResponse.SC_UNAUTHORIZED, message = "No authorized.")
	})
	public void createCount(
			@PathVariable(value = "idDevice") Long idDevice,
			@Valid @RequestBody CreateCountDTO countInit) {
		countManager.createCount(idDevice, countInit);
	}

}
