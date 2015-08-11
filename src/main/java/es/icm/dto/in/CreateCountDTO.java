package es.icm.dto.in;

import javax.validation.constraints.NotNull;

public class CreateCountDTO {

	@NotNull
	private Double value;

	public final Double getValue() {
		return value;
	}

	public final void setValue(Double value) {
		this.value = value;
	}

}
