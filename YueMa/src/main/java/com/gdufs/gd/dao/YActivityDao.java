package com.gdufs.gd.dao;

import java.util.List;

import com.gdufs.gd.entity.YActivity;

public interface YActivityDao {
	public boolean add(YActivity activity);

	public boolean update(YActivity activity);

	public YActivity getActivityByActivityId(int aId);

	public List<YActivity> getActivityByCreatorId(int uId);

	public boolean delete(int activityId);
}
