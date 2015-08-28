package es.icm.controller.location;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityNotFoundException;
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

import es.icm.bussiness.LocationManager;
import es.icm.config.annotation.VersionedRestController;
import es.icm.dto.in.CreateLocationDTO;
import es.icm.dto.out.LocationDTO;
import es.icm.dto.out.LocationWithDeviceDTO;

@VersionedRestController
@Api(value = "Location", description = "Permite CRUD sobre localizaciones.")
public class LocationCRUDController {
	@Autowired
	private LocationManager locationManager;

	@RequestMapping(value = "locations", method = RequestMethod.GET)
	@ApiOperation(value = "Devuelve la lista de localizaciones con los dispositivos asociados.", notes = "TODO:notes")
	@ApiResponses(
					value = {
							@ApiResponse(code = HttpServletResponse.SC_OK, message = "Found element."),
							@ApiResponse(code = HttpServletResponse.SC_BAD_REQUEST, message = "Invalid parameter."),
							@ApiResponse(code = HttpServletResponse.SC_INTERNAL_SERVER_ERROR, message = "Ups, server error."),
							@ApiResponse(code = HttpServletResponse.SC_UNAUTHORIZED, message = "No authorized.")})
	public List<LocationWithDeviceDTO> getLocations() {
		return locationManager.getLocations();
	}

	@RequestMapping(value = "locations/{idLocation:\\d+}", method = RequestMethod.GET)
	@ApiOperation(value = "Devuelve la localización requerida con sus dispositivos asociados.", notes = "TODO:notes")
	@ApiResponses(
					value = {
							@ApiResponse(code = HttpServletResponse.SC_OK, message = "Found element."),
							@ApiResponse(code = HttpServletResponse.SC_BAD_REQUEST, message = "Invalid url."),
							@ApiResponse(code = HttpServletResponse.SC_NOT_FOUND, message = "Invalid parameter."),
							@ApiResponse(code = HttpServletResponse.SC_INTERNAL_SERVER_ERROR, message = "Ups, server error."),
							@ApiResponse(code = HttpServletResponse.SC_UNAUTHORIZED, message = "No authorized.")})
	public LocationDTO getLocation(@PathVariable(value = "idLocation") Long idLocation) {
		return locationManager.getLocation(idLocation);
	}

	@RequestMapping(value = "locations/{idLocation:\\d+}", method = RequestMethod.DELETE)
	@ApiOperation(value = "Elimina una localización dado un ID para el	 cliente seleccionado.", notes = "TODO:notes")
	@ApiResponses(
					value = {
							@ApiResponse(code = HttpServletResponse.SC_OK, message = "Foundelement."),
							@ApiResponse(code = HttpServletResponse.SC_BAD_REQUEST, message = "Invalid parameter."),
							@ApiResponse(code = HttpServletResponse.SC_INTERNAL_SERVER_ERROR, message = "Ups, server	error."),
							@ApiResponse(code = HttpServletResponse.SC_UNAUTHORIZED, message = "Noauthorized.")

	})
	public void deleteLocation(@PathVariable(value = "idLocation") Long idLocation, HttpServletResponse response) throws IOException {
		try {
			locationManager.deleteLocation(idLocation);
		} catch (EntityNotFoundException e) {
			response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Location not found.");
		}
	}

	@RequestMapping(value = "clients/{idClient:\\d+}/locations", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Crea una localización para el clienteseleccionado.", notes = "TODO:notes")
	@ApiResponses(
					value = {
							@ApiResponse(code = HttpServletResponse.SC_CREATED, message = "Elementcreated."),
							@ApiResponse(code = HttpServletResponse.SC_BAD_REQUEST, message = "Invalid parameter."),
							@ApiResponse(code = HttpServletResponse.SC_INTERNAL_SERVER_ERROR, message = "Ups, server error."),
							@ApiResponse(code = HttpServletResponse.SC_UNAUTHORIZED, message = "Noauthorized.")

	})
	public LocationDTO createLocation(@PathVariable(value = "idClient") Long idClient, @Valid @RequestBody CreateLocationDTO locationInit, HttpServletResponse response)
			throws IOException {

		LocationDTO location = locationManager.createLocation(idClient, locationInit);
		return location;
	}

	@RequestMapping(value = "clients/{idClient:\\d+}/locations/{idLocation:\\d+}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Modifica una localización dado un ID para elcliente seleccionado.", notes = "TODO:notes")
	@ApiResponses(
					value = {
							@ApiResponse(code = HttpServletResponse.SC_OK, message = "Foundelement."),
							@ApiResponse(code = HttpServletResponse.SC_BAD_REQUEST, message = "Invalid parameter."),
							@ApiResponse(code = HttpServletResponse.SC_INTERNAL_SERVER_ERROR, message = "Ups, server error."),
							@ApiResponse(code = HttpServletResponse.SC_UNAUTHORIZED, message = "Noauthorized.")

	})

	public LocationDTO updateLocation(@PathVariable(value = "idClient") Long idClient, @PathVariable(value = "idLocation") Long idLocation,
			@Valid @RequestBody CreateLocationDTO locationInit, HttpServletResponse response) throws IOException {
		try {
			LocationDTO location = locationManager.updateLocation(idClient, idLocation, locationInit);
			return location;
		} catch (EntityNotFoundException e) {
			response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Location not found.");
			return null;
		}
	}

}
