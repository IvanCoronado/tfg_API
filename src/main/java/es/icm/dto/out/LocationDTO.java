package es.icm.dto.out;

import com.fasterxml.jackson.annotation.JsonProperty;

import es.icm.model.Location;

public class LocationDTO {

	@JsonProperty("id")
	private Long id;
	@JsonProperty("name")
	private String name;
	@JsonProperty("max_capacity")
	private int maxCapacity;
	@JsonProperty("address")
	private String address;
	@JsonProperty("city")
	private String city;
	@JsonProperty("latitude")
	private Double latitude;
	@JsonProperty("longitude")
	private Double longitude;
	@JsonProperty("is_public")
	private Boolean isPublic;
	@JsonProperty("description")
	private String description;

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

}
