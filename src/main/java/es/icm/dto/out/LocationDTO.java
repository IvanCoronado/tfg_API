package es.icm.dto.out;

import com.fasterxml.jackson.annotation.JsonProperty;

import es.icm.model.Location;

public class LocationDTO {

	@JsonProperty("id")
	private Long	id;
	@JsonProperty("name")
	private String	name;
	@JsonProperty("max_capacity")
	private int		maxCapacity;
	@JsonProperty("address")
	private String	address;
	@JsonProperty("city")
	private String	city;
	@JsonProperty("latitude")
	private Double	latitude;
	@JsonProperty("longitude")
	private Double	longitude;
	@JsonProperty("is_public")
	private Boolean	isPublic;
	@JsonProperty("description")
	private String	description;

	public LocationDTO(Location location) {
		super();
		this.id = location.getId();
		this.name = location.getName();
		this.maxCapacity = location.getMaxCapacity();
		this.address = location.getAddress();
		this.city = location.getCity();
		this.latitude = location.getLatitude();
		this.longitude = location.getLongitude();
		this.isPublic = location.getIsPublic();
		this.description = location.getDescription();
	}

	/**
	 * @return the id
	 */
	public final Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public final void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public final String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public final void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the maxCapacity
	 */
	public final int getMaxCapacity() {
		return maxCapacity;
	}

	/**
	 * @param maxCapacity the maxCapacity to set
	 */
	public final void setMaxCapacity(int maxCapacity) {
		this.maxCapacity = maxCapacity;
	}

	/**
	 * @return the address
	 */
	public final String getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public final void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the city
	 */
	public final String getCity() {
		return city;
	}

	/**
	 * @param city the city to set
	 */
	public final void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the latitude
	 */
	public final Double getLatitude() {
		return latitude;
	}

	/**
	 * @param latitude the latitude to set
	 */
	public final void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	/**
	 * @return the longitude
	 */
	public final Double getLongitude() {
		return longitude;
	}

	/**
	 * @param longitude the longitude to set
	 */
	public final void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	/**
	 * @return the isPublic
	 */
	public final Boolean getIsPublic() {
		return isPublic;
	}

	/**
	 * @param isPublic the isPublic to set
	 */
	public final void setIsPublic(Boolean isPublic) {
		this.isPublic = isPublic;
	}

	/**
	 * @return the description
	 */
	public final String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public final void setDescription(String description) {
		this.description = description;
	}

}
