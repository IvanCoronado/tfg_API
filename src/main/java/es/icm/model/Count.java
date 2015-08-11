package es.icm.model;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = TableNames.TABLE_COUNT)
public class Count extends IdEntity {
	@Column(name = "value")
	private Double value;

	@Column(name = "date")
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar date;

	@Column(name = "device_id")
	private Long idDevice;

	public Count() {

	}

	public Count(Double value, Calendar date, Long idDevice) {
		super();
		this.value = value;
		this.date = date;
		this.idDevice = idDevice;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

	public Calendar getDate() {
		return date;
	}

	public void setDate(Calendar date) {
		this.date = date;
	}

	public final Long getIdDevice() {
		return idDevice;
	}

	public final void setIdDevice(Long idDevice) {
		this.idDevice = idDevice;
	}

}
