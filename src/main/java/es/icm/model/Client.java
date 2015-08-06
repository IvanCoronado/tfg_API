package es.icm.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = TableNames.TABLE_CLIENT)
public class Client extends IdEntity {

	@Column(name = "name", length = 15)
	private String name;
	@Column(name = "description", length = 300)
	private String description;

	public Client(String name, String description) {
		super();
		this.name = name;
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
