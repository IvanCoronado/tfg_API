package es.icm.dao;

import javax.transaction.Transactional;

import es.icm.model.Device;

@Transactional(rollbackOn = Exception.class)
public interface DeviceDAOCustom {
	Device getDeviceWithStatus(Long idDevice);

	Long getActualStatusCount(Long idDevice);
}
