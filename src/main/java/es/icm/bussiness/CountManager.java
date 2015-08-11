package es.icm.bussiness;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.icm.dao.CountDAO;
import es.icm.dto.in.CreateCountDTO;
import es.icm.model.Count;

@Service
public class CountManager {
	@Autowired
	private CountDAO countDAO;

	public void createCount(Long idDevice, CreateCountDTO countInit) {

		Count count = new Count(countInit.getValue(), Calendar.getInstance(), idDevice);
		countDAO.save(count);

	}

}
