package es.icm.dao;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import es.icm.model.Device;

@Transactional(rollbackOn = Exception.class)
public interface DeviceDAO extends CrudRepository<Device, Long> {

}
