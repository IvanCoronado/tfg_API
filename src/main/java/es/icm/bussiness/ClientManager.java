package es.icm.bussiness;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.icm.dao.ClientDAO;
import es.icm.dto.in.CreateClientDTO;
import es.icm.dto.out.ClientDTO;
import es.icm.dto.out.ClientWithLocationsDTO;
import es.icm.model.Client;

@Service
public class ClientManager {
	@Autowired
	private ClientDAO clientDAO;

	public List<ClientWithLocationsDTO> getClients() {
		List<Client> lstClients = clientDAO.getClientWithLocations();

		List<ClientWithLocationsDTO> myPattern = lstClients.stream().map(p -> new ClientWithLocationsDTO(p))
				.collect(Collectors.toList());

		return myPattern;
	}

	public ClientWithLocationsDTO findClientById(Long id) {
		Client client = clientDAO.findById(id);

		if (client == null) {
			throw new EntityNotFoundException();
		}

		return new ClientWithLocationsDTO(client);
	}

	public ClientDTO createClient(CreateClientDTO clientInit) {
		Client client = new Client(clientInit.getName(), clientInit.getDescription());

		Client clientBD = clientDAO.save(client);
		return new ClientDTO(clientBD);
	}

	public ClientDTO updateClient(Long idClient, CreateClientDTO clientInit) {
		Client client = clientDAO.findById(idClient);

		if (client == null) {
			throw new EntityNotFoundException();
		}

		client.setName(clientInit.getName());
		client.setDescription(clientInit.getDescription());

		clientDAO.save(client);

		return new ClientDTO(client);
	}

	public void deleteClient(Long idClient) {
		Client client = clientDAO.findById(idClient);

		if (client == null) {
			throw new EntityNotFoundException();
		}

		clientDAO.delete(idClient);

	}

}
