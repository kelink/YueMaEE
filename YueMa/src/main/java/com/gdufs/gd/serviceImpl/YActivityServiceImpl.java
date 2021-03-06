package com.gdufs.gd.serviceImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.gdufs.gd.ActivityController;
import com.gdufs.gd.dao.YActivityDao;
import com.gdufs.gd.dao.YActivityUserDao;
import com.gdufs.gd.dao.YUserDao;
import com.gdufs.gd.entity.YActivity;
import com.gdufs.gd.entity.YActivityUser;
import com.gdufs.gd.service.YActivityService;

@Service(value = "activityService")
public class YActivityServiceImpl implements YActivityService {
	private static final Logger logger = LoggerFactory
			.getLogger(YActivityServiceImpl.class);

	public YActivityServiceImpl() {
	}

	@Resource(name = "activityDao")
	private YActivityDao activityDao;

	@Resource(name = "userDao")
	private YUserDao userDao;

	@Override
	public boolean add(YActivity activity) {
		// 新活动
		return activityDao.add(activity);
	}

	@Override
	public YActivity getActivityByActivityId(int aId) {
		// 通过排活动id寻找活动
		return activityDao.getActivityByActivityId(aId);
	}

	@Override
	public List<YActivity> getActivityByCreatorId(int uId) {
		// 用户的所有活动
		return activityDao.getActivityByCreatorId(uId);
	}

	@Override
	public boolean deleteActivity(int activityId) {
		// 删除活动
		return activityDao.delete(activityId);
	}

	/**
	 * 通过电话号码获取朋友圈子的动态
	 */
	@Override
	public HashMap<String, List> getYActivitiesbyPhonNnum(String phoneNum) {
		return activityDao.getYActivitiesbyPhonNnum(phoneNum);
	}

}
