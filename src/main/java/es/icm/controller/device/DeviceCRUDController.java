package es.icm.controller.device;

import com.wordnik.swagger.annotations.Api;

import es.icm.config.annotation.VersionedRestController;

@VersionedRestController
@Api(value = "Device", description = "Permite CRUD sobre dispositivos.")
public class DeviceCRUDController {

	// @RequestMapping(value = "devices/{idDevice:\\d+}", method =
	// RequestMethod.GET)
	// @ApiOperation(value = "Devuelve un dispositivo dado su ID.", notes =
	// "TODO:notes")
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
	// public DeviceDTO getDevice(@PathVariable(value = "idDevice") int
	// idDevice) {
	// DeviceDTO device = null;
	// return device;
	// }

	// @RequestMapping(value = "devices/{idDevice:\\d+}", method =
	// RequestMethod.DELETE)
	// @ApiOperation(value = "Elimina un dispositivo dado su ID.", notes =
	// "TODO:notes")
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
	//
	// public void deleteDevice(@PathVariable(value = "idDevice") int idDevice)
	// {
	//
	// }

	// @RequestMapping(value = "locations/{idLocation:\\d+}/devices",
	// method = RequestMethod.POST,
	// consumes = "aplication/json")
	// @ApiOperation(value = "Crea un dispositivo para la localización
	// seleccionada.", notes = "TODO:notes")
	// @ApiResponses(value = {
	// @ApiResponse(code = HttpServletResponse.SC_CREATED, message = "Element
	// created."),
	// @ApiResponse(code = HttpServletResponse.SC_BAD_REQUEST, message =
	// "Invalid parameter."),
	// @ApiResponse(code = HttpServletResponse.SC_INTERNAL_SERVER_ERROR, message
	// = "Ups, server error."),
	// @ApiResponse(code = HttpServletResponse.SC_UNAUTHORIZED, message = "No
	// authorized.")
	// })
	// public DeviceDTO createDevice(
	// @PathVariable(value = "idLocation") int idLocation,
	// @Valid @RequestBody CreateDeviceDTO deviceInit) {
	//
	// DeviceDTO device = null;
	// return device;
	// }

	// @RequestMapping(value =
	// "locations/{idLocation:\\d+}/devices/{idDevice:\\d+}",
	// method = RequestMethod.PUT,
	// consumes = "aplication/json")
	// @ApiOperation(value = "Modifica un dispositivo dado un ID para la
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
	// public DeviceDTO updateLocation(
	// @PathVariable(value = "idLocation") int idLocation,
	// @PathVariable(value = "idDevice") int idDevice,
	// @Valid @RequestBody CreateDeviceDTO deviceInit) {
	// DeviceDTO device = null;
	// return device;
	// }

}
