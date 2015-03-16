package com.gdufs.gd.daoImpl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.gdufs.gd.dao.YUserDao;
import com.gdufs.gd.entity.YUser;

@Repository(value = "userDao")
public class YUserDaoImpl implements YUserDao {
	private static final Logger logger = LoggerFactory
			.getLogger(YUserDaoImpl.class);

	@Resource(name = "sessionFactory")
	protected SessionFactory sessionFactory;

	public Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public boolean addYUser(YUser user) throws Exception {
		logger.info("enter DAO layer---> addYUser");
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

	@Override
	public boolean updateYUser(YUser user) throws Exception {
		return false;
	}

	@Override
	public boolean delteYUser(String uId) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public YUser getYUserById(String uId) throws Exception {
		String hql = "from YUser u where u.uId=?";
		Query query = this.getSession().createQuery(hql);
		query.setString(0, uId);
		return (YUser) query.uniqueResult();
	}

	@Override
	public List<YUser> getYUserList() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}