package es.icm.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;
import org.hibernate.type.StandardBasicTypes;
import org.springframework.stereotype.Repository;

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

		return total;
	}

}
