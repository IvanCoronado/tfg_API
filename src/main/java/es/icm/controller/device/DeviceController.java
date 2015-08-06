package es.icm.controller.device;

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
import es.icm.dto.out.DeviceDTO;

@VersionedRestController
@Api(value = "Device", description = "Información sobre dispositvos.")
@RequestMapping(value = "locations/{idLocation:\\d+}/devices")
public class DeviceController {

	@RequestMapping(method = RequestMethod.GET)
	@ApiOperation(value = "Devuelve la lista de dispositivos de la localización seleccionada.", notes = "TODO:notes")
	@ApiResponses(value = {
			@ApiResponse(code = HttpServletResponse.SC_OK, message = "Found element."),
			@ApiResponse(code = HttpServletResponse.SC_BAD_REQUEST, message = "Invalid parameter."),
			@ApiResponse(code = HttpServletResponse.SC_INTERNAL_SERVER_ERROR, message = "Ups, server error."),
			@ApiResponse(code = HttpServletResponse.SC_UNAUTHORIZED, message = "No authorized.")
	})
	public Page<DeviceDTO> getDevices(@PathVariable(value = "idLocation") int idLocation) {
		return null;
	}
}
