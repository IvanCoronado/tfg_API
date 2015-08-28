package es.icm.controller.device;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiResponse;
import com.wordnik.swagger.annotations.ApiResponses;

import es.icm.bussiness.DeviceManager;
import es.icm.config.annotation.VersionedRestController;
import es.icm.dto.in.TimeLineFilterDTO;
import es.icm.dto.out.DeviceWithCountDTO;
import es.icm.dto.out.TimeLineCountDTO;

@VersionedRestController
@Api(value = "Device", description = "Información sobre dispositvos.")
public class DeviceController {
	@Autowired
	private DeviceManager deviceManager;
	// @RequestMapping(method = RequestMethod.GET)
	// @ApiOperation(value = "Devuelve la lista de dispositivos de la
	// localización seleccionada.", notes = "TODO:notes")
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
	// public Page<DeviceDTO> getDevices(@PathVariable(value = "idLocation") int
	// idLocation) {
	// return null;
	// }

	@RequestMapping(value = "devices/{idDevice:\\d+}/status", method = RequestMethod.GET)
	@ApiOperation(value = "Devuelve la última actualización del dispositivo seleccionado.", notes = "TODO:notes")
	@ApiResponses(
					value = {
							@ApiResponse(code = HttpServletResponse.SC_OK, message = "Found element."),
							@ApiResponse(code = HttpServletResponse.SC_BAD_REQUEST, message = "Invalid parameter."),
							@ApiResponse(code = HttpServletResponse.SC_INTERNAL_SERVER_ERROR, message = "Ups, server error."),
							@ApiResponse(code = HttpServletResponse.SC_UNAUTHORIZED, message = "No authorized.")})
	public DeviceWithCountDTO getstatus(@PathVariable(value = "idDevice") Long idDevice, @RequestParam(value = "type") String typeDevice, HttpServletResponse response)
			throws IOException {
		if (typeDevice.equals("unique")) {
			return deviceManager.getStatus(idDevice);
		} else if (typeDevice.equals("count")) {
			return deviceManager.getStatusCount(idDevice);
		} else {
			response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Type must be: 'unique' and 'count'");
			return null;
		}

	}

	@RequestMapping(value = "devices/{idDevice:\\d+}/timeline", method = RequestMethod.GET)
	@ApiOperation(value = "Devuelve la última actualización del dispositivo seleccionado.", notes = "TODO:notes")
	@ApiResponses(
					value = {
							@ApiResponse(code = HttpServletResponse.SC_OK, message = "Found element."),
							@ApiResponse(code = HttpServletResponse.SC_BAD_REQUEST, message = "Invalid parameter."),
							@ApiResponse(code = HttpServletResponse.SC_INTERNAL_SERVER_ERROR, message = "Ups, server error."),
							@ApiResponse(code = HttpServletResponse.SC_UNAUTHORIZED, message = "No authorized.")})
	public List<TimeLineCountDTO> getTimeLine(@PathVariable(value = "idDevice") Long idDevice, @ModelAttribute TimeLineFilterDTO filter, HttpServletResponse response)
			throws IOException {
		try {
			Assert.isTrue(filter.getType().equals("unique") || filter.getType().equals("count"), "Type must be: 'unique' and 'count'");
			Assert.isTrue(filter.getGroup_time().equals("day") || filter.getGroup_time().equals("hour"), "Type must be: 'day' and 'hour'");

			return deviceManager.getTimeLine(idDevice, filter);

		} catch (IllegalArgumentException exp) {
			response.sendError(HttpServletResponse.SC_BAD_REQUEST, exp.getMessage());
			return null;
		}

	}
}
