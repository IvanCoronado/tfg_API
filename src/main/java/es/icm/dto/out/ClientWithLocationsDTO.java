package es.icm.dto.out;

import java.util.ArrayList;
import java.util.List;

import es.icm.model.Client;
import es.icm.model.Location;

public class ClientWithLocationsDTO extends ClientDTO {
	private List<LocationDTO>	locations	= new ArrayList<LocationDTO>();

	public ClientWithLocationsDTO(Client p) {
		super(p);
		for (Location location : p.getLocations()) {
			locations.add(new LocationDTO(location));
		}
	}

}
