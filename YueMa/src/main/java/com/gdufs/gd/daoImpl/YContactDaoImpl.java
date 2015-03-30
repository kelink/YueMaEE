package com.gdufs.gd.daoImpl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.gdufs.gd.dao.YContactDao;
import com.gdufs.gd.entity.YContact;

@Repository(value = "contactDao")
public class YContactDaoImpl extends BaseDao implements YContactDao {

	protected static final Logger logger = LoggerFactory
			.getLogger(YContactDaoImpl.class);

	public YContactDaoImpl() {
		super();
	}

	@Override
	public boolean addContacts(List<YContact> contactObj) {
		Session session = this.getSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			for (YContact contact : contactObj) {
				session.save(contact);
			}
			session.flush();
			tx.commit();
			return true;
		} catch (Exception ex) {
			if (tx != null) {
				tx.rollback();
			}
			logger.error("Add contact object error" + ex.getMessage());
			return false;
		}

	}

	@Override
	public boolean deleteContactById(String id) {
		return false;
		// TODO Auto-generated method stub

	}

	@Override
	public boolean updateContactById(YContact contactObj) {
		return false;
		// TODO Auto-generated method stub

	}

	@Override
	public List<YContact> getContactObjById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<YContact> getAllContact() {
		// TODO Auto-generated method stub
		return null;
	}

}
