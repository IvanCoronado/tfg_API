package es.icm.dto.out;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import es.icm.model.Count;
import es.icm.model.Device;

public class DeviceWithCountDTO extends DeviceDTO {
	@JsonProperty(value = "devices")
	private List<CountDTO> counts = new ArrayList<CountDTO>();

	public DeviceWithCountDTO(Device p) {
		super(p);
		for (Count count : p.getCounts()) {
			counts.add(new CountDTO(count));
		}
	}

	public DeviceWithCountDTO(Device device, Long total) {
		super(device);
		CountDTO count = new CountDTO(Calendar.getInstance(), total.doubleValue(), device.getId());
		counts.add(count);
	}

}
