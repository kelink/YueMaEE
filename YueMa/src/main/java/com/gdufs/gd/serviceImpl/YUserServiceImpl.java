package com.gdufs.gd.serviceImpl;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.validation.constraints.Pattern.Flag;

import org.hamcrest.core.Is;
import org.springframework.stereotype.Service;

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
	public TransferMessage register(YUser user, HttpSession session,
			String registerCode) {
		TransferMessage message = new TransferMessage();
		// 判断注册码是否过期
		if (validRegistCode(session, registerCode)) {
			message.setCode(CResponse.Code.ERROR);
			message.setMessage(CResponse.Message.REGIST_CODE_TIME_OUT);
			message.setResultMap(null);
		} else {
			if (userDao.addYUser(user)) {
				message.setCode(CResponse.Code.SUCCESS);
				message.setMessage(CResponse.Message.SUCCESS);
				message.setResultMap(null);
			} else {
				message.setCode(CResponse.Code.ERROR);
				message.setMessage(CResponse.Message.ERROR);
				message.setResultMap(null);
			}
		}
		return message;
	}

	// 验证注册码
	private boolean validRegistCode(HttpSession session, String registerCode) {
		String phoneNum = (String) session.getAttribute("phoneNum");
		if (phoneNum == null || phoneNum.equals("")) {
			return false;
		}
		String[] parms = phoneNum.split("-");
		if (!registerCode.equals(parms[1])) {
			return false;
		}
		return true;

	}

	@Override
	public boolean login(YUser user) {
		// TODO Auto-generated method stub
		return false;
	}

}
