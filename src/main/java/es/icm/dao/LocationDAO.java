package es.icm.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import es.icm.model.Location;

@Transactional(rollbackOn = Exception.class)
public interface LocationDAO extends CrudRepository<Location, Long> {

	@Query("SELECT l FROM Location as l LEFT JOIN FETCH l.devices WHERE l.id = :idLocation")
	public Location findById(@Param("idLocation") Long id);

	@Query("SELECT l FROM Location as l LEFT JOIN FETCH l.devices")
	public List<Location> getLocationsWithDevices();

}
