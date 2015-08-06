package es.icm.dao;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import es.icm.model.Count;

@Transactional(rollbackOn = Exception.class)
public interface CountDAO extends CrudRepository<Count, Long> {

}