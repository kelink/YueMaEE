package com.gdufs.gd.dao;

import com.gdufs.gd.entity.YUser;

public interface YUserDao {
	public boolean add(YUser user);

	public boolean update(YUser user);

	public YUser queryById(int id);

	public boolean delete(YUser user);

	public boolean addYUser(YUser user);
}