package es.icm.bussiness;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.icm.dao.DeviceDAO;
import es.icm.dto.in.TimeLineFilterDTO;
import es.icm.dto.out.DeviceWithCountDTO;
import es.icm.dto.out.TimeLineCountDTO;
import es.icm.model.Device;

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

}
