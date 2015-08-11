package es.icm.controller.client;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityNotFoundException;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiResponse;
import com.wordnik.swagger.annotations.ApiResponses;

import es.icm.bussiness.ClientManager;
import es.icm.config.annotation.VersionedRestController;
import es.icm.dto.out.ClientDTO;
import es.icm.dto.out.ClientWithLocationsDTO;

@VersionedRestController
@Api(value = "Client", description = "Información sobre el cliente.")
@RequestMapping(value = "clients")
public class ClientController {

	@Autowired
	private ClientManager	clientManager;

	@RequestMapping(value = "{idClient:\\d+}", method = RequestMethod.GET)
	@ApiOperation(value = "Devuelve un cliente dado un ID.", notes = "TODO:notes")
	@ApiResponses(value = {@ApiResponse(code = HttpServletResponse.SC_OK, message = "Found element."), @ApiResponse(code = HttpServletResponse.SC_BAD_REQUEST, message = "Invalid parameter."),
			@ApiResponse(code = HttpServletResponse.SC_INTERNAL_SERVER_ERROR, message = "Ups, server error."), @ApiResponse(code = HttpServletResponse.SC_UNAUTHORIZED, message = "No authorized.")})
	public ClientDTO getClient(@PathVariable(value = "idClient") Long idClient, HttpServletResponse response) throws IOException {
		try {
			ClientDTO client = clientManager.findClientById(idClient);
			return client;
		} catch (EntityNotFoundException e) {
			response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Client not found.");
			return null;
		}

	}

	@RequestMapping(method = RequestMethod.GET)
	@ApiOperation(value = "Devuelve una lista de clientes.", notes = "TODO:notes")
	@ApiResponses(value = {@ApiResponse(code = HttpServletResponse.SC_OK, message = "Found element."), @ApiResponse(code = HttpServletResponse.SC_BAD_REQUEST, message = "Invalid parameter."),
			@ApiResponse(code = HttpServletResponse.SC_INTERNAL_SERVER_ERROR, message = "Ups, server error."), @ApiResponse(code = HttpServletResponse.SC_UNAUTHORIZED, message = "No authorized.")})
	public List<ClientWithLocationsDTO> getClients() {
		return clientManager.getClients();
	}

}
