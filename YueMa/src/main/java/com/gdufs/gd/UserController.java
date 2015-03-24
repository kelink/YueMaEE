package com.gdufs.gd;

import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.gdufs.gd.common.CResponse;
import com.gdufs.gd.entity.TransferMessage;
import com.gdufs.gd.entity.YUser;
import com.gdufs.gd.service.YUserService;
import com.gdufs.gd.util.JacksonUtil;
import com.gdufs.gd.util.RandomUtils;

@Controller
@RequestMapping("/user")
public class UserController {

	private static final Logger logger = LoggerFactory
			.getLogger(UserController.class);

	@Resource(name = "userService")
	private YUserService userService;

	// 注册
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String register(@RequestParam("phoneNum") String phoneNum,
			@RequestParam("pwd") String pwd,
			@RequestParam("registerCode") String registerCode,
			final HttpSession session) {
		TransferMessage message = new TransferMessage();
		if (phoneNum == null || phoneNum.equals("") || pwd == null
				|| pwd.equals("") || registerCode == null
				|| registerCode.equals("")) {
			message.setCode(CResponse.Code.REQUEST_ERROR);
			message.setMessage(CResponse.Message.REQUEST_ERROR);
			message.setResultMap(null);

		} else {
			YUser user = new YUser();
			user.setPassword(pwd);
			user.setPhoneNumber(phoneNum);
			user.setCreateTime(new Date());
			user.setNickName(phoneNum);// 默认名字
			message = userService.register(user, session, registerCode);
		}
		return JacksonUtil.writeEntity2JSON(message);

	}

	// 验证注册码
	@RequestMapping(value = "/getRegisterCode", method = RequestMethod.POST)
	public String getRegisterCode(@RequestParam("phoneNum") String phoneNum,
			final HttpSession session) {
		String codeString = String.valueOf(RandomUtils.getRandom(0, 999999));
		long time = System.currentTimeMillis();
		session.setAttribute("phoneNum", time + "-" + codeString);
		return codeString;
	}
}
