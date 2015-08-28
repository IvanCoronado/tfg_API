package es.icm.dao;

import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;
import org.hibernate.transform.Transformers;
import org.hibernate.type.StandardBasicTypes;
import org.springframework.stereotype.Repository;

import es.icm.dto.out.TimeLineCountDTO;
import es.icm.model.Device;

@Repository
@Transactional(rollbackOn = Exception.class)
public class DeviceDAOImpl implements DeviceDAOCustom {

	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * @return current Session
	 */
	private Session getSessionFactory() {

		return entityManager.unwrap(Session.class);
	}

	@Override
	public Device getDeviceWithStatus(Long idDevice) {
		Criteria criteria = getSessionFactory().createCriteria(Device.class);
		criteria.add(Restrictions.eq("id", idDevice));
		criteria.createAlias("counts", "counts", JoinType.LEFT_OUTER_JOIN);
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);

		criteria.addOrder(Order.desc("counts.date"));
		criteria.setMaxResults(1);

		return (Device) criteria.uniqueResult();
	}

	@Override
	public Long getActualStatusCount(Long idDevice) {
		String sql = "select sum(value) as total from tfg.count where device_id=:idDevice and DATE_FORMAT(date,'%Y%m%d') = DATE_FORMAT(now(),'%Y%m%d') group by DATE_FORMAT(date,'%Y%m%d')";
		SQLQuery sqlQuery = getSessionFactory().createSQLQuery(sql);

		sqlQuery.setParameter("idDevice", idDevice);
		sqlQuery.addScalar("total", StandardBasicTypes.LONG);
		Long total = (Long) sqlQuery.uniqueResult();
		if (total == null) {
			return 0L;
		} else {
			return total;
		}
	}

	@Override
	public List<TimeLineCountDTO> getTimeLine(Long idDevice, Calendar initDay, Calendar endDay, String groupTime) {
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT MAX(value) as valueMax,MIN(value) as valueMin, date, :idDevice as deviceId ");
		sql.append("FROM tfg.count ");
		sql.append("WHERE device_id=:idDevice AND date <=  :initDay AND date >= :endDay ");
		if (groupTime.equals("day")) {
			sql.append("GROUP BY DATE_FORMAT(DATE,'%Y%m%d')");
		} else {
			sql.append("GROUP BY DATE_FORMAT(DATE,'%Y%m%d%H')");
		}

		SQLQuery sqlQuery = getSessionFactory().createSQLQuery(sql.toString());
		sqlQuery.setParameter("idDevice", idDevice);
		sqlQuery.setParameter("idDevice", idDevice);
		sqlQuery.setCalendarDate("initDay", initDay);
		sqlQuery.setCalendarDate("endDay", endDay);

		sqlQuery.addScalar("date", StandardBasicTypes.CALENDAR);
		sqlQuery.addScalar("valueMax", StandardBasicTypes.DOUBLE);
		sqlQuery.addScalar("valueMin", StandardBasicTypes.DOUBLE);
		sqlQuery.addScalar("deviceId", StandardBasicTypes.LONG);
		sqlQuery.setResultTransformer(Transformers.aliasToBean(TimeLineCountDTO.class));

		@SuppressWarnings("unchecked")
		List<TimeLineCountDTO> result = sqlQuery.list();
		return result;
	}

	@Override
	public List<TimeLineCountDTO> getTimeLineCount(Long idDevice, Calendar initDay, Calendar endDay, String groupTime) {

		StringBuffer sql = new StringBuffer();
		sql.append("SELECT SUM(value) as valueMax,0 as valueMin, date , :idDevice as deviceId ");
		sql.append("FROM tfg.count ");
		sql.append("WHERE device_id=:idDevice AND date <=  :initDay AND date >= :endDay ");
		if (groupTime.equals("day")) {
			sql.append("GROUP BY DATE_FORMAT(DATE,'%Y%m%d')");
		} else {
			sql.append("GROUP BY DATE_FORMAT(DATE,'%Y%m%d%H')");
		}

		SQLQuery sqlQuery = getSessionFactory().createSQLQuery(sql.toString());
		sqlQuery.setParameter("idDevice", idDevice);
		sqlQuery.setParameter("idDevice", idDevice);
		sqlQuery.setCalendarDate("initDay", initDay);
		sqlQuery.setCalendarDate("endDay", endDay);

		sqlQuery.addScalar("date", StandardBasicTypes.CALENDAR);
		sqlQuery.addScalar("valueMax", StandardBasicTypes.DOUBLE);
		sqlQuery.addScalar("valueMin", StandardBasicTypes.DOUBLE);
		sqlQuery.addScalar("deviceId", StandardBasicTypes.LONG);
		sqlQuery.setResultTransformer(Transformers.aliasToBean(TimeLineCountDTO.class));

		@SuppressWarnings("unchecked")
		List<TimeLineCountDTO> result = sqlQuery.list();
		return result;
	}

	//		# Resultado de los contadores agrupado por dia
	//		SELECT SUM(value) AS total, DATE_FORMAT(DATE,'%Y %M %d')
	//		FROM tfg.count
	//		WHERE device_id=1 
	//		GROUP BY DATE_FORMAT(DATE,'%Y%m%d');
	//
	//		# temperatura maxima y minima por dia 
	//		SELECT MAX(value),MIN(value) , DATE_FORMAT(DATE,'%Y %M %d')
	//		FROM tfg.count
	//		WHERE device_id=2 
	//		GROUP BY DATE_FORMAT(DATE,'%Y%m%d');
	//
	//		# Resultado de los contadores pro hora
	//		SELECT SUM(value) AS total, DATE_FORMAT(DATE,'%Y %M %d %H:00:00')
	//		FROM tfg.count
	//		WHERE device_id=1 
	//		GROUP BY DATE_FORMAT(DATE,'%Y%m%d%H');
	//
	//		# temperatura media por hora 
	//		SELECT MAX(value),MIN(value) , DATE_FORMAT(DATE,'%Y %M %d %H:00:00')
	//		FROM tfg.count
	//		WHERE device_id=2 
	//		GROUP BY DATE_FORMAT(DATE,'%Y%m%d%H');

}
