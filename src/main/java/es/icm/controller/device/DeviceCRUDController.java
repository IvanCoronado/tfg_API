package es.icm.controller.device;

import java.io.IOException;

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

import es.icm.bussiness.DeviceManager;
import es.icm.config.annotation.VersionedRestController;
import es.icm.dto.in.CreateDeviceDTO;
import es.icm.dto.out.DeviceDTO;

@VersionedRestController
@Api(value = "Device", description = "Permite CRUD sobre dispositivos.")
public class DeviceCRUDController {
	@Autowired
	private DeviceManager deviceManager;

	@RequestMapping(value = "devices/{idDevice:\\d+}", method = RequestMethod.GET)
	@ApiOperation(value = "Devuelve un dispositivo dado su ID.", notes = "TODO:notes")
	@ApiResponses(
					value = {
							@ApiResponse(code = HttpServletResponse.SC_OK, message = "Foundelement."),
							@ApiResponse(code = HttpServletResponse.SC_BAD_REQUEST, message = "Invalid parameter."),
							@ApiResponse(code = HttpServletResponse.SC_INTERNAL_SERVER_ERROR, message = "Ups, server error."),
							@ApiResponse(code = HttpServletResponse.SC_UNAUTHORIZED, message = "Noauthorized.")})
	public DeviceDTO getDevice(@PathVariable(value = "idDevice") Long idDevice, HttpServletResponse response) throws IOException {
		try {
			DeviceDTO device = deviceManager.findDeviceById(idDevice);
			return device;
		} catch (EntityNotFoundException e) {
			response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Device not found.");
			return null;
		}
	}

	@RequestMapping(value = "devices/{idDevice:\\d+}", method = RequestMethod.DELETE)
	@ApiOperation(value = "Elimina un dispositivo dado su ID.", notes = "TODO:notes")
	@ApiResponses(
					value = {
							@ApiResponse(code = HttpServletResponse.SC_OK, message = "Foundelement."),
							@ApiResponse(code = HttpServletResponse.SC_BAD_REQUEST, message = "Invalid parameter."),
							@ApiResponse(code = HttpServletResponse.SC_INTERNAL_SERVER_ERROR, message = "Ups, server error."),
							@ApiResponse(code = HttpServletResponse.SC_UNAUTHORIZED, message = "Noauthorized.")

	})
	public void deleteDevice(@PathVariable(value = "idDevice") Long idDevice, HttpServletResponse response) throws IOException {
		try {
			deviceManager.deleteDevice(idDevice);
		} catch (EntityNotFoundException e) {
			response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Device not found.");
		}
	}

	@RequestMapping(value = "locations/{idLocation:\\d+}/devices", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Crea un dispositivo para la localizaciónseleccionada.", notes = "TODO:notes")
	@ApiResponses(
					value = {
							@ApiResponse(code = HttpServletResponse.SC_CREATED, message = "Elementcreated."),
							@ApiResponse(code = HttpServletResponse.SC_BAD_REQUEST, message = "Invalid parameter."),
							@ApiResponse(code = HttpServletResponse.SC_INTERNAL_SERVER_ERROR, message = "Ups, server error."),
							@ApiResponse(code = HttpServletResponse.SC_UNAUTHORIZED, message = "Noauthorized.")})
	public DeviceDTO createDevice(@PathVariable(value = "idLocation") Long idLocation, @Valid @RequestBody CreateDeviceDTO deviceInit, HttpServletResponse response)
			throws IOException {

		DeviceDTO device = deviceManager.createDevice(idLocation, deviceInit);
		return device;
	}

	@RequestMapping(value = "devices/{idDevice:\\d+}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Modifica un dispositivo dado un ID para lalocalización seleccionada.", notes = "TODO:notes")
	@ApiResponses(
					value = {
							@ApiResponse(code = HttpServletResponse.SC_OK, message = "Foundelement."),
							@ApiResponse(code = HttpServletResponse.SC_BAD_REQUEST, message = "Invalid parameter."),
							@ApiResponse(code = HttpServletResponse.SC_INTERNAL_SERVER_ERROR, message = "Ups, server error."),
							@ApiResponse(code = HttpServletResponse.SC_UNAUTHORIZED, message = "Noauthorized.")

	})
	public DeviceDTO updateLocation(@PathVariable(value = "idLocation") Long idLocation, @PathVariable(value = "idDevice") Long idDevice,
			@Valid @RequestBody CreateDeviceDTO deviceInit, HttpServletResponse response) throws IOException {

		try {
			DeviceDTO device = deviceManager.updateDevice(idDevice, idLocation, deviceInit);
			return device;
		} catch (EntityNotFoundException e) {
			response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Device not found.");
			return null;
		}
	}

}
