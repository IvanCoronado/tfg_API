package es.icm.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import es.icm.model.Client;

@Transactional(rollbackOn = Exception.class)
public interface ClientDAO extends CrudRepository<Client, Long> {

	public List<Client> findAll();

	public Client findById(Long id);
}
