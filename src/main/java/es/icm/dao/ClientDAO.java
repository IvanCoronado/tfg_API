package es.icm.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import es.icm.model.Client;

@Transactional(rollbackOn = Exception.class)
public interface ClientDAO extends CrudRepository<Client, Long> {

	public List<Client> findAll();

	@Query("SELECT DISTINCT c FROM Client as c LEFT JOIN FETCH c.locations as loc WHERE loc.client.id = :idClient")
	public Client findById(@Param("idClient") Long idClient);

	@Query("SELECT c FROM Client as c LEFT JOIN FETCH c.locations")
	public List<Client> getClientWithLocations();
}
