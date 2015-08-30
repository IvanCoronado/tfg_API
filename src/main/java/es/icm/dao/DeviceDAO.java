package es.icm.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import es.icm.model.Device;

@Transactional(rollbackOn = Exception.class)
public interface DeviceDAO extends CrudRepository<Device, Long>, DeviceDAOCustom {

	@Query("SELECT DISTINCT d FROM Device as d LEFT JOIN d.location as loc LEFT JOIN loc.client as c where c.id = :idCliente")
	public List<Device> getDeviceForClientId(@Param("idCliente") Long idCliente);

}
