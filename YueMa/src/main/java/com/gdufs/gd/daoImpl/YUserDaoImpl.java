package com.gdufs.gd.daoImpl;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.gdufs.gd.dao.YUserDao;
import com.gdufs.gd.entity.YUser;

@Repository(value = "userDao")
public class YUserDaoImpl extends BaseDao implements YUserDao {
	private static final Logger logger = LoggerFactory
			.getLogger(YUserDaoImpl.class);

	@Override
	public boolean addYUser(YUser user) {
		Session session = this.getSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.save(user);
			session.flush();
			tx.commit();
			return true;
		} catch (Exception ex) {
			if (tx != null) {
				tx.rollback();
			}
			logger.error("Add YUser error" + ex.getMessage());
			return false;
		}
	}

}