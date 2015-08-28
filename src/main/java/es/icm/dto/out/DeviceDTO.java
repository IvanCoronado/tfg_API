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
	 * @return the typeId
	 */
	public final int getTypeId() {
		return typeId;
	}

	/**
	 * @param typeId the typeId to set
	 */
	public final void setTypeId(int typeId) {
		this.typeId = typeId;
	}

	/**
	 * @return the typeName
	 */
	public final String getTypeName() {
		return typeName;
	}

	/**
	 * @param typeName the typeName to set
	 */
	public final void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	/**
	 * @return the group
	 */
	public final String getGroup() {
		return group;
	}

	/**
	 * @param group the group to set
	 */
	public final void setGroup(String group) {
		this.group = group;
	}

}
