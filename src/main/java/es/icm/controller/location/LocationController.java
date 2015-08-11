package es.icm.controller.location;

import org.springframework.web.bind.annotation.RequestMapping;

import com.wordnik.swagger.annotations.Api;

import es.icm.config.annotation.VersionedRestController;

@VersionedRestController
@Api(value = "Location", description = "Información sobre localizaciones.")
@RequestMapping(value = "clients/{idClient:\\d+}/locations")
public class LocationController {

	// @RequestMapping(method = RequestMethod.GET)
	// @ApiOperation(value = "Devuelve la lista de localizaciones del cliente
	// seleccionado.", notes = "TODO:notes")
	// @ApiResponses(value = {
	// @ApiResponse(code = HttpServletResponse.SC_OK, message = "Found
	// element."),
	// @ApiResponse(code = HttpServletResponse.SC_BAD_REQUEST, message =
	// "Invalid parameter."),
	// @ApiResponse(code = HttpServletResponse.SC_INTERNAL_SERVER_ERROR, message
	// = "Ups, server error."),
	// @ApiResponse(code = HttpServletResponse.SC_UNAUTHORIZED, message = "No
	// authorized.")
	// })
	// public Page<LocationDTO> getLocations(@PathVariable(value = "idClient")
	// int idClient) {
	// return null;
	// }
}
