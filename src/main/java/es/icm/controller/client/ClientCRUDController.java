package es.icm.controller.client;

import java.io.IOException;

import javax.persistence.EntityNotFoundException;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiResponse;
import com.wordnik.swagger.annotations.ApiResponses;

import es.icm.bussiness.ClientManager;
import es.icm.config.annotation.VersionedRestController;
import es.icm.dto.in.CreateClientDTO;
import es.icm.dto.out.ClientDTO;

@VersionedRestController
@Api(value = "Client", description = "Permite CRUD sobre el cliente.")
@RequestMapping(value = "clients")
public class ClientCRUDController {

	@Autowired
	private ClientManager clientManager;

	@RequestMapping(method = RequestMethod.POST)
	@ApiOperation(value = "Crea un cliente.", notes = "TODO:notes")
	@ApiResponses(value = {
			@ApiResponse(code = HttpServletResponse.SC_CREATED, message = "Element created."),
			@ApiResponse(code = HttpServletResponse.SC_BAD_REQUEST, message = "Invalid parameter."),
			@ApiResponse(code = HttpServletResponse.SC_INTERNAL_SERVER_ERROR, message = "Ups, server error."),
			@ApiResponse(code = HttpServletResponse.SC_UNAUTHORIZED, message = "No authorized.")
	})
	public ClientDTO createClient(@Valid @RequestBody CreateClientDTO clientInit, HttpServletResponse response) {
		ClientDTO client = clientManager.createClient(clientInit);
		return client;
	}

	@RequestMapping(value = "{idClient:\\d+}", method = RequestMethod.PUT, consumes = "aplication/json")
	@ApiOperation(value = "Modifica un cliente dado un ID.", notes = "TODO:notes")
	@ApiResponses(value = {
			@ApiResponse(code = HttpServletResponse.SC_OK, message = "Found element."),
			@ApiResponse(code = HttpServletResponse.SC_BAD_REQUEST, message = "Invalid parameter."),
			@ApiResponse(code = HttpServletResponse.SC_INTERNAL_SERVER_ERROR, message = "Ups, server error."),
			@ApiResponse(code = HttpServletResponse.SC_UNAUTHORIZED, message = "No authorized.")
	})
	public ClientDTO updateClient(
			@PathVariable(value = "idClient") Long idClient,
			@Valid @RequestBody CreateClientDTO clientInit,
			HttpServletResponse response) throws IOException {
		try {
			ClientDTO client = clientManager.updateClient(idClient, clientInit);
			return client;
		} catch (EntityNotFoundException e) {
			response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Client not found.");
			return null;
		}
	}

	@RequestMapping(value = "{idClient:\\d+}", method = RequestMethod.DELETE)
	@ApiOperation(value = "Elimina un cliente dado un ID.", notes = "TODO:notes")
	@ApiResponses(value = {
			@ApiResponse(code = HttpServletResponse.SC_OK, message = "Found element."),
			@ApiResponse(code = HttpServletResponse.SC_BAD_REQUEST, message = "Invalid parameter."),
			@ApiResponse(code = HttpServletResponse.SC_INTERNAL_SERVER_ERROR, message = "Ups, server error."),
			@ApiResponse(code = HttpServletResponse.SC_UNAUTHORIZED, message = "No authorized.")
	})
	public void deleteClient(@PathVariable(value = "idClient") int idClient) {

	}
}
