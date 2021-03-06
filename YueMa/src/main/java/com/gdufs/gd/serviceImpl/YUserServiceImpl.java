package com.gdufs.gd.serviceImpl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.gdufs.gd.common.C;
import com.gdufs.gd.common.CResponse;
import com.gdufs.gd.dao.YContactDao;
import com.gdufs.gd.dao.YUserDao;
import com.gdufs.gd.entity.TransferMessage;
import com.gdufs.gd.entity.YBulletin;
import com.gdufs.gd.entity.YContact;
import com.gdufs.gd.entity.YUser;
import com.gdufs.gd.service.YUserService;

@Service(value = "userService")
public class YUserServiceImpl implements YUserService {

	@Resource(name = "userDao")
	private YUserDao userDao;
	
	@Resource(name = "contactDao")
	private YContactDao contactDao;

	@Override
	public TransferMessage register(YUser user) {
		TransferMessage message = new TransferMessage();
		//1.创建系统发给用户的公告，欢迎用户
		//2.创建提醒
		
		if (userDao.addYUser(user)) {
			//更新关系contact表
			if (contactDao.updateIsSysUserByFriendsNum(user.getPhoneNumber())) {
				message.setCode(C.ResponseCode.SUCCESS);
				message.setMessage(C.ResponseMessage.SUCCESS);
				message.setResultMap(null);
			}else {
				message.setCode(C.ResponseCode.ERROR);
				message.setMessage(CResponse.Message.REGIST_DB_ERROR);
				message.setResultMap(null);
			}
		} else {
			message.setCode(C.ResponseCode.ERROR);
			message.setMessage(CResponse.Message.REGIST_DB_ERROR);
			message.setResultMap(null);
		}		
		return message;
	}

	@Override
	public YUser CheckUser(YUser user) {	
		return userDao.getUserByNameAndPwd(user.getPhoneNumber(), user.getPassword());
	}

	@Override
	public YUser getUserById(int id) {
		return userDao.getUserById(id);
	}

	@Override
	public YUser getUserByPhone(String phoneNum) {
		return userDao.getUserByPhone(phoneNum);
	}

}
