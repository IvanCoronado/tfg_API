package es.icm.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import es.icm.model.Client;

@Transactional(rollbackOn = Exception.class)
public interface ClientDAO extends CrudRepository<Client, Long> {

	public List<Client> findAll();

	public Client findById(Long id);

	@Query("SELECT c FROM Client as c LEFT JOIN FETCH c.locations")
	public List<Client> getClientWithLocations();
}
