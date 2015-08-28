package es.icm.dto.out;

import java.util.Calendar;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TimeLineCountDTO {
	@JsonProperty("date")
	private Calendar	date;
	@JsonProperty("value_max")
	private Double		valueMax;
	@JsonProperty("value_min")
	private Double		valueMin;
	@JsonProperty("device_id")
	private long		deviceId;

	public TimeLineCountDTO() {
		super();
	}

	public TimeLineCountDTO(Calendar date, Double valueMax, Double valueMin, long deviceId) {
		super();
		this.date = date;
		this.valueMax = valueMax;
		this.valueMin = valueMin;
		this.deviceId = deviceId;
	}

	public final Calendar getDate() {
		return date;
	}

	public final void setDate(Calendar date) {
		this.date = date;
	}

	public final long getDeviceId() {
		return deviceId;
	}

	public final void setDeviceId(long deviceId) {
		this.deviceId = deviceId;
	}

	/**
	 * @return the valueMax
	 */
	public final Double getValueMax() {
		return valueMax;
	}

	/**
	 * @param valueMax the valueMax to set
	 */
	public final void setValueMax(Double valueMax) {
		this.valueMax = valueMax;
	}

	/**
	 * @return the valueMin
	 */
	public final Double getValueMin() {
		return valueMin;
	}

	/**
	 * @param valueMin the valueMin to set
	 */
	public final void setValueMin(Double valueMin) {
		this.valueMin = valueMin;
	}

}
