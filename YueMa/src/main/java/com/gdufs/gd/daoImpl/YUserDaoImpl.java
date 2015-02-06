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
public class YUserDaoImpl implements YUserDao{
	private static final Logger logger = LoggerFactory.getLogger(YUserDaoImpl.class);
	
	@Resource(name = "sessionFactory")
	protected SessionFactory sessionFactory;
	
	public Session getSession(){
		return this.sessionFactory.getCurrentSession();
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public boolean addYUser(YUser user) throws Exception {
		logger.info("enter DAO layer---> addYUser");
		Session session=this.getSession();
        Transaction tx = null;  
        try {  
            tx = session.beginTransaction();  
            System.out.println(user.toString());
            //因为user的主键生成侧路采用的是uuid，所以调用完成save后，只是将user纳入到了session的管理  
            //不会发出insert语句，但是id已经生成，session中existsInDatebase状态为fals
            session.save(user); 
            //调用flush，hibernate会清理缓存，执行sql  
            //如果数据库的隔离级别设置为为提交读，那么我们可以看到flush过的数据  
            //并且session中existsInDatebase状态为true  
            session.flush();   
            //提交事务  
            //默认情况下commit操作会先执行flush清理缓存，所以不用显示的调用flush  
            //commit后数据是无法回滚的  
            tx.commit();
            return true;
        } catch (Exception ex) {  
            if (tx != null) {  
                tx.rollback();  
            } 
            logger.error("Add YUser error"+ex.getMessage());
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
		return (YUser)query.uniqueResult();
	}

	@Override
	public List<YUser> getYUserList() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
}