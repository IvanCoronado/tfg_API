package es.icm.dto.out;

import com.fasterxml.jackson.annotation.JsonProperty;

import es.icm.model.Device;

public class DeviceDTO {

	@JsonProperty("id")
	private Long id;

	@JsonProperty("name")
	private String name;

	@JsonProperty("type_id")
	private int typeId;

	@JsonProperty("type_name")
	private String typeName;

	@JsonProperty("group")
	private String group;

	public DeviceDTO(Device device) {
		super();
		this.id = device.getId();
		this.name = device.getName();
		this.typeId = device.getType().ordinal();
		this.typeName = device.getType().name();
		this.group = device.getGroup();
	}

	public final Long getId() {
		return id;
	}

	public final void setId(Long id) {
		this.id = id;
	}

	public final int getTypeId() {
		return typeId;
	}

	public final void setTypeId(int typeId) {
		this.typeId = typeId;
	}

	public final String getTypeName() {
		return typeName;
	}

	public final void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public final String getGroup() {
		return group;
	}

	public final void setGroup(String group) {
		this.group = group;
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

}
