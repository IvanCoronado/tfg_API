package es.icm.bussiness;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.icm.dao.LocationDAO;
import es.icm.dto.in.CreateLocationDTO;
import es.icm.dto.out.LocationDTO;
import es.icm.dto.out.LocationWithDeviceDTO;
import es.icm.model.Client;
import es.icm.model.Location;

@Service
public class LocationManager {
	@Autowired
	private LocationDAO locationDAO;

	public List<LocationWithDeviceDTO> getLocations() {
		List<Location> lstLocations = locationDAO.getLocationsWithDevices();

		List<LocationWithDeviceDTO> myPattern = lstLocations.stream().map(p -> new LocationWithDeviceDTO(p)).collect(Collectors.toList());

		return myPattern;
	}

	public LocationDTO getLocation(Long idLocation) {
		Location location = locationDAO.findById(idLocation);

		if (location == null) {
			throw new EntityNotFoundException();
		}

		return new LocationWithDeviceDTO(location);
	}

	public void deleteLocation(Long idLocation) {
		Location location = locationDAO.findOne(idLocation);

		if (location == null) {
			throw new EntityNotFoundException();
		}

		locationDAO.delete(idLocation);
	}

	public LocationDTO createLocation(Long idClient, CreateLocationDTO locationInit) {
		Location location = new Location();
		location.setName(locationInit.getName());
		location.setAddress(locationInit.getAddress());
		location.setCity(locationInit.getCity());
		location.setDescription(locationInit.getDescription());
		location.setIsPublic(locationInit.getIsPublic());
		location.setLatitude(locationInit.getLatitude());
		location.setLongitude(locationInit.getLongitude());
		location.setMaxCapacity(locationInit.getMaxCapacity());

		Client mock = new Client();
		mock.setId(idClient);
		location.setClient(mock);

		Location locationBD = locationDAO.save(location);
		return new LocationDTO(locationBD);
	}

	public LocationDTO updateLocation(Long idClient, Long idLocation, CreateLocationDTO locationInit) {
		Location location = locationDAO.findOne(idLocation);

		if (location == null) {
			throw new EntityNotFoundException();
		}

		location.setName(locationInit.getName());
		location.setAddress(locationInit.getAddress());
		location.setCity(locationInit.getCity());
		location.setDescription(locationInit.getDescription());
		location.setIsPublic(locationInit.getIsPublic());
		location.setLatitude(locationInit.getLatitude());
		location.setLongitude(locationInit.getLongitude());
		location.setMaxCapacity(locationInit.getMaxCapacity());

		locationDAO.save(location);

		return new LocationDTO(location);
	}
}
