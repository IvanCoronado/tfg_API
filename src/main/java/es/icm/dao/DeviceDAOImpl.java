package es.icm.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;
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

		// TODO hace filtro para solo el último

		criteria.createAlias("counts", "counts", JoinType.LEFT_OUTER_JOIN);
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);

		return (Device) criteria.uniqueResult();
	}

}
