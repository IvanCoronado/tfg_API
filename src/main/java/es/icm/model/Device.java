package es.icm.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = TableNames.TABLE_DEVICE)
public class Device extends IdEntity {
	@Column(name = "name", length = 15)
	private String name;
	@Column(name = "type_device")
	@Enumerated(value = EnumType.ORDINAL)
	private EnumDeviceType type;
	@Column(name = "group_devices", length = 20)
	private String group;

	@ManyToOne
	@JoinColumn(name = "location_id")
	private Location location;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public EnumDeviceType getType() {
		return type;
	}

	public void setType(EnumDeviceType type) {
		this.type = type;
	}

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	public final Location getLocation() {
		return location;
	}

	public final void setLocation(Location location) {
		this.location = location;
	}

}
