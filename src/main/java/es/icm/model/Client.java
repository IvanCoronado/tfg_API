package es.icm.model;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@NamedEntityGraph(name = "Client.locations", attributeNodes = @NamedAttributeNode("locations") )
@Table(name = TableNames.TABLE_CLIENT)
public class Client extends IdEntity {

	@Column(name = "name", length = 15)
	private String name;

	@Column(name = "description", length = 300)
	private String description;

	@OneToMany(mappedBy = "client")
	private List<Location> locations = new LinkedList<>();

	public Client() {
		super();
	}

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

	/**
	 * @return the locations
	 */
	public final List<Location> getLocations() {
		return locations;
	}

	/**
	 * @param locations
	 *            the locations to set
	 */
	public final void setLocations(List<Location> locations) {
		this.locations = locations;
	}

}
