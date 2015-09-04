package es.icm.dto.in;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class CreateLocationDTO {
	@NotEmpty
	private String name;
	@NotEmpty
	private String description;
	@NotNull
	private Integer maxCapacity;
	@NotEmpty
	private String address;
	@NotEmpty
	private String city;
	@NotNull
	private Double latitude;
	@NotNull
	private Double longitude;

	private Boolean isPublic;

	/**
	 * @return the name
	 */
	public final String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public final void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the description
	 */
	public final String getDescription() {
		return description;
	}

	/**
	 * @param description
	 *            the description to set
	 */
	public final void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the maxCapacity
	 */
	public final Integer getMaxCapacity() {
		return maxCapacity;
	}

	/**
	 * @param maxCapacity
	 *            the maxCapacity to set
	 */
	public final void setMaxCapacity(Integer maxCapacity) {
		this.maxCapacity = maxCapacity;
	}

	/**
	 * @return the address
	 */
	public final String getAddress() {
		return address;
	}

	/**
	 * @param address
	 *            the address to set
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
	 * @param city
	 *            the city to set
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
	 * @param latitude
	 *            the latitude to set
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
	 * @param longitude
	 *            the longitude to set
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
	 * @param isPublic
	 *            the isPublic to set
	 */
	public final void setIsPublic(Boolean isPublic) {
		this.isPublic = isPublic;
	}
}
