package com.gdufs.gd.dao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import com.gdufs.gd.entity.YUser;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:WEB-INF/spring/root-context.xml","classpath:WEB-INF/spring/appServlet/servlet-context.xml"})
@WebAppConfiguration
@TransactionConfiguration(transactionManager="transactionManager",defaultRollback=true)
public class YUserDaoTest {

	@Autowired
	private YUserDao userDao;
	
	@Test
	public void testAddYUser(){
		YUser user=new YUser();
		user.setNickName("test");
		try {
			userDao.addYUser(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
