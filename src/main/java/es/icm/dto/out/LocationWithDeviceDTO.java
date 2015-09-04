package es.icm.dto.out;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import es.icm.model.Device;
import es.icm.model.Location;

public class LocationWithDeviceDTO extends LocationDTO {
	@JsonProperty(value = "devices")
	private List<DeviceDTO> devices = new ArrayList<DeviceDTO>();

	public LocationWithDeviceDTO(Location p) {
		super(p);
		for (Device device : p.getDevices()) {
			devices.add(new DeviceDTO(device));
		}
	}

	/**
	 * @return the devices
	 */
	public final List<DeviceDTO> getDevices() {
		return devices;
	}

	/**
	 * @param devices
	 *            the devices to set
	 */
	public final void setDevices(List<DeviceDTO> devices) {
		this.devices = devices;
	}

}
