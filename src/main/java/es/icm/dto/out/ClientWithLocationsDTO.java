package es.icm.dto.out;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import es.icm.model.Client;
import es.icm.model.Location;

public class ClientWithLocationsDTO extends ClientDTO {
	@JsonProperty(value = "locations")
	private List<LocationDTO> locations = new ArrayList<LocationDTO>();

	public ClientWithLocationsDTO(Client p) {
		super(p);
		for (Location location : p.getLocations()) {
			locations.add(new LocationDTO(location));
		}
	}

	public final List<LocationDTO> getLocations() {
		return locations;
	}

	public final void setLocations(List<LocationDTO> locations) {
		this.locations = locations;
	}

}
