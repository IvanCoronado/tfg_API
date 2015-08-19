package es.icm.bussiness;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.icm.dao.DeviceDAO;
import es.icm.dto.out.DeviceWithCountDTO;
import es.icm.model.Device;

@Service
public class DeviceManager {
	@Autowired
	private DeviceDAO deviceDAO;

	public DeviceWithCountDTO getStatus(Long idDevice) {
		Device device = deviceDAO.getDeviceWithStatus(idDevice);
		return new DeviceWithCountDTO(device);
	}

}
