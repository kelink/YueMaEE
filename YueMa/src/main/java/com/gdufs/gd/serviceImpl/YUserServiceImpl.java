package com.gdufs.gd.serviceImpl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.gdufs.gd.dao.YUserDao;
import com.gdufs.gd.entity.YUser;
import com.gdufs.gd.service.YUserService;

@Service(value = "userService")
public class YUserServiceImpl implements YUserService {

	@Resource(name = "userDao")
	private YUserDao userDao;

	@Override
	public void addYUser(YUser user) {
		try {
			userDao.addYUser(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public YUser getYUserById(String uId) {
		YUser user = null;
		try {
			user = userDao.getYUserById(uId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}

}
