package com.gdufs.gd.daoImpl;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.CreateKeySecondPass;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.gdufs.gd.dao.YActivityDao;
import com.gdufs.gd.entity.YActivity;
import com.gdufs.gd.entity.YActivityUser;
import com.gdufs.gd.entity.YUser;
import com.mchange.v2.uid.UidUtils;

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
			// 同时插入参与表信息
			YActivityUser activityUser = new YActivityUser();
			activityUser.setActivity(activity);
			activityUser.setUser(activity.getCreator());
			activityUser.setIsAuth(1);
			activityUser.setIsTickOff(0);
			activityUser.setJoin_time(new Date());
			session.save(activity);
			session.save(activityUser);
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
	public YActivity getActivityByActivityId(int aid) {
		Session session = this.getSession();
		String hql = "from YActivity where id=?";
		Query query = session.createQuery(hql);
		query.setParameter(0, aid);
		YActivity activity = (YActivity) query.uniqueResult();
		return activity;
	}

	@Override
	public List<YActivity> getActivityByCreatorId(int uId) {
		Session session = this.getSession();
		String hql = "from YActivity where creator.id=?";
		Query query = session.createQuery(hql);
		query.setParameter(0, uId);
		List<YActivity> user = query.list();
		return user;
	}

	@Override
	public boolean delete(int activityId) {
		Session session = this.getSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			// 删除所有参加关系
			String sql = "delete from YActivityUser where activityId=?";
			Query query2 = session.createSQLQuery(sql);
			query2.setInteger(0, activityId);
			query2.executeUpdate();
			// 删除活动
			String hql = "delete YActivity as activity where activity.id=?";
			Query query = session.createQuery(hql);
			query.setInteger(0, activityId);
			query.executeUpdate();

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
}
