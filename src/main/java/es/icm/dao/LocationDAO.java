package es.icm.dao;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import es.icm.model.Location;

@Transactional(rollbackOn = Exception.class)
public interface LocationDAO extends CrudRepository<Location, Long> {

}
