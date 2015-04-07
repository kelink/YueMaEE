package com.gdufs.gd.serviceImpl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import com.gdufs.gd.common.C;
import com.gdufs.gd.common.CResponse;
import com.gdufs.gd.dao.YUserDao;
import com.gdufs.gd.entity.TransferMessage;
import com.gdufs.gd.entity.YUser;
import com.gdufs.gd.service.YUserService;

@Service(value = "userService")
public class YUserServiceImpl implements YUserService {

	@Resource(name = "userDao")
	private YUserDao userDao;

	@Override
	public TransferMessage register(YUser user) {
		TransferMessage message = new TransferMessage();
		if (userDao.addYUser(user)) {
			message.setCode(C.ResponseCode.SUCCESS);
			message.setMessage(C.ResponseMessage.SUCCESS);
			message.setResultMap(null);
		} else {
			message.setCode(C.ResponseCode.ERROR);
			message.setMessage(CResponse.Message.REGIST_DB_ERROR);
			message.setResultMap(null);
		}		
		return message;
	}

	@Override
	public boolean login(YUser user) {	
		YUser temp= userDao.getUserByNameAndPwd(user.getPhoneNumber(), user.getPassword());
		if (temp!=null) {
			return true;
		}else {
			return false;
		}
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
