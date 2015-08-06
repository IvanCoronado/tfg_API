package es.icm.dto.in;

import org.hibernate.validator.constraints.NotEmpty;

public class CreateClientDTO {
	@NotEmpty
	private String name;
	@NotEmpty
	private String description;

	public final String getName() {
		return name;
	}

	public final void setName(String name) {
		this.name = name;
	}

	public final String getDescription() {
		return description;
	}

	public final void setDescription(String description) {
		this.description = description;
	}

}
