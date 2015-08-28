package es.icm.dao;

import java.util.Calendar;
import java.util.List;

import javax.transaction.Transactional;

import es.icm.dto.out.TimeLineCountDTO;
import es.icm.model.Device;

@Transactional(rollbackOn = Exception.class)
public interface DeviceDAOCustom {
	public Device getDeviceWithStatus(Long idDevice);

	public Long getActualStatusCount(Long idDevice);

	public List<TimeLineCountDTO> getTimeLine(Long idDevice, Calendar initDay, Calendar endDay, String groupTime);

	public List<TimeLineCountDTO> getTimeLineCount(Long idDevice, Calendar initDay, Calendar endDay, String groupTime);
}
