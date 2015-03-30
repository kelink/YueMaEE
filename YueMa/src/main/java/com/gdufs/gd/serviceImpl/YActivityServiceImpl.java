package com.gdufs.gd.serviceImpl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.gdufs.gd.dao.YActivityDao;
import com.gdufs.gd.entity.YActivity;
import com.gdufs.gd.service.YActivityService;

@Service(value = "activityService")
public class YActivityServiceImpl implements YActivityService {

	public YActivityServiceImpl() {
	}

	@Resource(name = "activityDao")
	private YActivityDao activityDao;

	@Override
	public boolean add(YActivity activity) {
		return activityDao.add(activity);
	}

}
