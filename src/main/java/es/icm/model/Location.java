package es.icm.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = TableNames.TABLE_LOCATION)
public class Location extends IdEntity {
	@Column(name = "name", length = 15)
	private String	name;

	@Column(name = "description", length = 300)
	private String	description;

	@Column(name = "max_capacity")
	private int		maxCapacity;

	@Column(name = "address", length = 300)
	private String	address;

	@Column(name = "city", length = 15)
	private String	city;

	@Column(name = "latitude")
	private Double	latitude;

	@Column(name = "longitude")
	private Double	longitude;

	@Column(name = "isPublic", columnDefinition = "BIT")
	private Boolean	isPublic;

	@ManyToOne
	@JoinColumn(name = "client_id")
	private Client	client;

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

	public int getMaxCapacity() {
		return maxCapacity;
	}

	public void setMaxCapacity(int maxCapacity) {
		this.maxCapacity = maxCapacity;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public Boolean getIsPublic() {
		return isPublic;
	}

	public void setIsPublic(Boolean isPublic) {
		this.isPublic = isPublic;
	}

	/**
	 * @return the client
	 */
	public final Client getClient() {
		return client;
	}

	/**
	 * @param client the client to set
	 */
	public final void setClient(Client client) {
		this.client = client;
	}

}
