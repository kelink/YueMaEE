package com.gdufs.gd.daoImpl;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.gdufs.gd.dao.YActivityDao;
import com.gdufs.gd.entity.YActivity;

@Repository(value = "activityDao")
public class YActivityDaoImpl extends BaseDao implements YActivityDao {
	private static final Logger logger = LoggerFactory
			.getLogger(YActivityDaoImpl.class);

	public YActivityDaoImpl() {
	}

	@Override
	public boolean add(YActivity activity) {
		Session session = this.getSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.save(activity);
			session.flush();
			tx.commit();
			return true;
		} catch (Exception ex) {
			if (tx != null) {
				tx.rollback();
			}
			System.out.println(ex);
			logger.error("Add activity error" + ex.getMessage());
			return false;
		}
	}

	@Override
	public boolean update(YActivity activity) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public YActivity queryById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(YActivity activity) {
		// TODO Auto-generated method stub
		return false;
	}

}
