package es.icm.dto.out;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({
		"id", "type_id", "type_name", "description_short", "latitude", "longitude", "last_update"
})
public class DeviceDTO {

	@JsonProperty("id")
	private int id;

	@JsonProperty("type_id")
	private String typeId;

	@JsonProperty("type_name")
	private String typeName;

	@JsonProperty("description_short")
	private String descriptionShort;

	@JsonProperty("latitude")
	private double latitude;

	@JsonProperty("longitude")
	private double longitude;

	@JsonProperty("last_update")
	private long lastUpdate;

	public DeviceDTO(int id, String typeId, String typeName, String descriptionShort, double latitude, double longitude,
			long lastUpdate) {
		super();
		this.id = id;
		this.typeId = typeId;
		this.typeName = typeName;
		this.descriptionShort = descriptionShort;
		this.latitude = latitude;
		this.longitude = longitude;
		this.lastUpdate = lastUpdate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTypeId() {
		return typeId;
	}

	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public String getDescriptionShort() {
		return descriptionShort;
	}

	public void setDescriptionShort(String descriptionShort) {
		this.descriptionShort = descriptionShort;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public long getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(long lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

}
