package es.icm.dto.in;

import es.icm.model.EnumDeviceType;

public class CreateDeviceDTO {

	private String			name;
	private EnumDeviceType	type;
	private String			group;

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
	 * @return the type
	 */
	public final EnumDeviceType getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public final void setType(EnumDeviceType type) {
		this.type = type;
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
