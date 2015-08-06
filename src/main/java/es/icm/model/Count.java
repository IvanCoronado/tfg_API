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

}
