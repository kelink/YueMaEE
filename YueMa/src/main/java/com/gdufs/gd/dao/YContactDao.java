package com.gdufs.gd.dao;

import java.util.List;

import com.gdufs.gd.entity.YContactObj;

public interface YContactDao {
	public void addContact(YContactObj contactObj);

	public void deleteContactById(String id);

	public void updateContactById(YContactObj contactObj);

	public List<YContactObj> getContactObjById(String id);

	public List<YContactObj> getAll();
}
