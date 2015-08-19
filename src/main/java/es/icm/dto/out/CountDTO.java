package es.icm.dto.out;

import java.util.Calendar;

import com.fasterxml.jackson.annotation.JsonProperty;

import es.icm.model.Count;

public class CountDTO {
	@JsonProperty("date")
	private Calendar date;
	@JsonProperty("value")
	private Double value;
	@JsonProperty("device_id")
	private long deviceId;

	public CountDTO(Calendar date, Double value, long deviceId) {
		super();
		this.date = date;
		this.value = value;
		this.deviceId = deviceId;
	}

	public CountDTO(Count count) {
		this.date = count.getDate();
		this.value = count.getValue();
		this.deviceId = count.getIdDevice();
	}

	public final Calendar getDate() {
		return date;
	}

	public final void setDate(Calendar date) {
		this.date = date;
	}

	public final Double getValue() {
		return value;
	}

	public final void setValue(Double value) {
		this.value = value;
	}

	public final long getDeviceId() {
		return deviceId;
	}

	public final void setDeviceId(long deviceId) {
		this.deviceId = deviceId;
	}

}
