package es.icm.dto.out;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LocationDTO {

	@JsonProperty("id")
	private int id;
	@JsonProperty("name")
	private String name;
	@JsonProperty("capacity")
	private int capacity;
	@JsonProperty("seating_capacity")
	private int seatingCapacity;
	@JsonProperty("street")
	private String street;
	@JsonProperty("city")
	private String city;
	@JsonProperty("province")
	private String province;
	@JsonProperty("zip_code")
	private int zipCode;
	@JsonProperty("latitude")
	private double latitude;
	@JsonProperty("longitude")
	private double longitude;
	@JsonProperty("current_count")
	private int currentCount;
	@JsonProperty("public_visibility")
	private int publicVisibility;
	@JsonProperty("owner")
	private int owner;

}
