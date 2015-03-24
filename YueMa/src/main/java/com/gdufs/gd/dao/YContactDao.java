package com.gdufs.gd.dao;

import java.util.List;

import com.gdufs.gd.entity2.YContact;

public interface YContactDao {

	public boolean addContacts(List<YContact> contactObj);

	public boolean deleteContactById(String id);

	public boolean updateContactById(YContact contactObj);

	public List<YContact> getContactObjById(String id);

	public List<YContact> getAllContact();
}
