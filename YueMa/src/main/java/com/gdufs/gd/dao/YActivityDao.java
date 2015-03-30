package com.gdufs.gd.dao;

import com.gdufs.gd.entity.YActivity;

public interface YActivityDao {
	public boolean add(YActivity activity);

	public boolean update(YActivity activity);

	public YActivity queryById(int id);

	public boolean delete(YActivity activity);
}
