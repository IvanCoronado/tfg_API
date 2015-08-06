package es.icm.controller.location;

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
import es.icm.dto.in.CreateLocationDTO;
import es.icm.dto.out.LocationDTO;

@VersionedRestController
@Api(value = "Location", description = "Permite CRUD sobre localizaciones.")
public class LocationCRUDController {

	@RequestMapping(value = "locations/{idLocation:\\d+}", method = RequestMethod.GET)
	@ApiOperation(value = "Devuelve una localización para el cliente seleccionado.", notes = "TODO:notes")
	@ApiResponses(value = {
			@ApiResponse(code = HttpServletResponse.SC_OK, message = "Found element."),
			@ApiResponse(code = HttpServletResponse.SC_BAD_REQUEST, message = "Invalid parameter."),
			@ApiResponse(code = HttpServletResponse.SC_INTERNAL_SERVER_ERROR, message = "Ups, server error."),
			@ApiResponse(code = HttpServletResponse.SC_UNAUTHORIZED, message = "No authorized.")
	})
	public LocationDTO getLocation(@PathVariable(value = "idLocation") int idLocation) {
		LocationDTO location = null;
		return location;
	}

	@RequestMapping(value = "locations/{idLocation:\\d+}", method = RequestMethod.DELETE)
	@ApiOperation(value = "Elimina una localización dado un ID para el cliente seleccionado.", notes = "TODO:notes")
	@ApiResponses(value = {
			@ApiResponse(code = HttpServletResponse.SC_OK, message = "Found element."),
			@ApiResponse(code = HttpServletResponse.SC_BAD_REQUEST, message = "Invalid parameter."),
			@ApiResponse(code = HttpServletResponse.SC_INTERNAL_SERVER_ERROR, message = "Ups, server error."),
			@ApiResponse(code = HttpServletResponse.SC_UNAUTHORIZED, message = "No authorized.")
	})

	public void deleteLocation(@PathVariable(value = "idLocation") int idLocation) {

	}

	@RequestMapping(value = "clients/{idClient:\\d+}/locations",
					method = RequestMethod.POST,
					consumes = "aplication/json")
	@ApiOperation(value = "Crea una localización para el cliente seleccionado.", notes = "TODO:notes")
	@ApiResponses(value = {
			@ApiResponse(code = HttpServletResponse.SC_CREATED, message = "Element created."),
			@ApiResponse(code = HttpServletResponse.SC_BAD_REQUEST, message = "Invalid parameter."),
			@ApiResponse(code = HttpServletResponse.SC_INTERNAL_SERVER_ERROR, message = "Ups, server error."),
			@ApiResponse(code = HttpServletResponse.SC_UNAUTHORIZED, message = "No authorized.")
	})
	public LocationDTO createLocation(
			@PathVariable(value = "idClient") int idClient,
			@Valid @RequestBody CreateLocationDTO locationInit) {

		LocationDTO location = null;
		return location;
	}

	@RequestMapping(value = "clients/{idClient:\\d+}/locations/{idLocation:\\d+}",
					method = RequestMethod.PUT,
					consumes = "aplication/json")
	@ApiOperation(value = "Modifica una localización dado un ID para el cliente seleccionado.", notes = "TODO:notes")
	@ApiResponses(value = {
			@ApiResponse(code = HttpServletResponse.SC_OK, message = "Found element."),
			@ApiResponse(code = HttpServletResponse.SC_BAD_REQUEST, message = "Invalid parameter."),
			@ApiResponse(code = HttpServletResponse.SC_INTERNAL_SERVER_ERROR, message = "Ups, server error."),
			@ApiResponse(code = HttpServletResponse.SC_UNAUTHORIZED, message = "No authorized.")
	})
	public LocationDTO updateLocation(
			@PathVariable(value = "idClient") int idClient,
			@PathVariable(value = "idLocation") int idLocation,
			@Valid @RequestBody CreateLocationDTO locationInit) {
		LocationDTO location = null;
		return location;
	}

}
