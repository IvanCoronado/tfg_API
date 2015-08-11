package es.icm.bussiness;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.icm.dao.LocationDAO;
import es.icm.dto.out.LocationDTO;
import es.icm.dto.out.LocationWithDeviceDTO;
import es.icm.model.Location;

@Service
public class LocationManager {
	@Autowired
	private LocationDAO locationDAO;

	public List<LocationWithDeviceDTO> getLocations() {
		List<Location> lstLocations = locationDAO.getLocationsWithDevices();

		List<LocationWithDeviceDTO> myPattern = lstLocations.stream().map(p -> new LocationWithDeviceDTO(p))
				.collect(Collectors.toList());

		return myPattern;
	}

	public LocationDTO getLocation(Long idLocation) {
		Location location = locationDAO.findById(idLocation);

		if (location == null) {
			throw new EntityNotFoundException();
		}

		return new LocationWithDeviceDTO(location);
	}
}
