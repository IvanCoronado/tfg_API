package es.icm.dto.in;

import java.util.Calendar;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.wordnik.swagger.annotations.ApiParam;

public class TimeLineFilterDTO {

	@NotNull
	@DateTimeFormat(iso = ISO.NONE, pattern = "yyyy-MM-dd")
	@ApiParam(name = "date", value = "Start date,hour and minute for filtering comments (format ISO: yyyy-MM-dd).Second are ignored", required = true)
	private Calendar date;

	@NotNull
	@ApiParam(name = "n_days", value = "Hours since start date", required = true)
	private Integer n_days;

	@NotBlank
	@ApiParam(name = "type", value = "count or unique", required = true)
	private String type;

	@NotBlank
	@ApiParam(name = "group_time", value = "day or hour", required = true)
	private String group_time;

	/**
	 * @return the date
	 */
	public final Calendar getDate() {

		return date;
	}

	/**
	 * @param date the date to set
	 */
	public final void setDate(Calendar date) {

		this.date = date;
	}

	/**
	 * @return the type
	 */
	public final String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public final void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the group_time
	 */
	public final String getGroup_time() {
		return group_time;
	}

	/**
	 * @param group_time the group_time to set
	 */
	public final void setGroup_time(String group_time) {
		this.group_time = group_time;
	}

	/**
	 * @return the n_days
	 */
	public final Integer getN_days() {
		return n_days;
	}

	/**
	 * @param n_days the n_days to set
	 */
	public final void setN_days(Integer n_days) {
		this.n_days = n_days;
	}

}
