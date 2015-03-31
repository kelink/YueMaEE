package com.gdufs.gd.service;

import javax.servlet.http.HttpSession;

import com.gdufs.gd.entity.TransferMessage;
import com.gdufs.gd.entity.YUser;

public interface YUserService {
	public TransferMessage register(YUser user, HttpSession session,
			String registerCode, String phoneNum);

	public boolean login(YUser user);

	public YUser getUserById(int id);
}
