package es.icm.bussiness;

import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.icm.dao.DeviceDAO;
import es.icm.dto.in.CreateDeviceDTO;
import es.icm.dto.in.TimeLineFilterDTO;
import es.icm.dto.out.DeviceDTO;
import es.icm.dto.out.DeviceWithCountDTO;
import es.icm.dto.out.TimeLineCountDTO;
import es.icm.model.Device;
import es.icm.model.Location;

@Service
public class DeviceManager {
	@Autowired
	private DeviceDAO deviceDAO;

	public DeviceWithCountDTO getStatus(Long idDevice) {
		Device device = deviceDAO.getDeviceWithStatus(idDevice);
		return new DeviceWithCountDTO(device);
	}

	public DeviceWithCountDTO getStatusCount(Long idDevice) {
		Device device = deviceDAO.findOne(idDevice);

		Long total = deviceDAO.getActualStatusCount(idDevice);

		return new DeviceWithCountDTO(device, total);
	}

	public List<TimeLineCountDTO> getTimeLine(Long idDevice, TimeLineFilterDTO typeDevice) {

		Calendar initDay = (Calendar) typeDevice.getDate().clone();
		initDay.add(Calendar.DAY_OF_MONTH, +1);
		Calendar endDay = (Calendar) typeDevice.getDate().clone();
		endDay.add(Calendar.DAY_OF_MONTH, -typeDevice.getN_days() + 1);

		if (typeDevice.getType().equals("unique")) {
			return deviceDAO.getTimeLine(idDevice, initDay, endDay, typeDevice.getGroup_time());
		} else {
			return deviceDAO.getTimeLineCount(idDevice, initDay, endDay, typeDevice.getGroup_time());
		}

	}

	public DeviceDTO findDeviceById(Long idDevice) {
		Device device = deviceDAO.findOne(idDevice);

		if (device == null) {
			throw new EntityNotFoundException();
		}

		return new DeviceDTO(device);
	}

	public void deleteDevice(Long idDevice) {
		Device device = deviceDAO.findOne(idDevice);

		if (device == null) {
			throw new EntityNotFoundException();
		}

		deviceDAO.delete(idDevice);
	}

	public DeviceDTO createDevice(Long idLocation, CreateDeviceDTO deviceInit) {
		Device device = new Device();
		device.setName(deviceInit.getName());
		device.setGroup(deviceInit.getGroup());
		device.setType(deviceInit.getType());

		Location mock = new Location();
		mock.setId(idLocation);
		device.setLocation(mock);

		Device deviceBD = deviceDAO.save(device);
		return new DeviceDTO(deviceBD);
	}

	public DeviceDTO updateDevice(Long idDevice, Long idLocation, CreateDeviceDTO deviceInit) {
		Device device = deviceDAO.findOne(idDevice);

		if (device == null) {
			throw new EntityNotFoundException();
		}

		device.setName(deviceInit.getName());
		device.setGroup(deviceInit.getGroup());
		device.setType(deviceInit.getType());

		deviceDAO.save(device);

		return new DeviceDTO(device);
	}

}
