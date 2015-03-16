package com.gdufs.gd.service;

import java.util.List;

import com.gdufs.gd.entity.YContact;

public interface YContactService {
	public void addContact();

	public List<YContact> listContact();

	public List<YContact> listContactById();

	public void deleteContact();

	public void updateContact();
}
