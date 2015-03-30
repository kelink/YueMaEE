package com.gdufs.gd;

import java.util.Date;
import java.util.Locale;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gdufs.gd.common.CResponse;
import com.gdufs.gd.entity.TransferMessage;
import com.gdufs.gd.entity.YUser;
import com.gdufs.gd.service.YUserService;
import com.gdufs.gd.util.JPushUtil;
import com.gdufs.gd.util.JacksonUtil;
import com.gdufs.gd.util.RandomUtils;

@Controller
@RequestMapping("/user")
public class UserController {

	private static final Logger logger = LoggerFactory
			.getLogger(UserController.class);

	@Resource(name = "userService")
	private YUserService userService;

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index(Locale locale, Model model) {
		return "register";
	}

	// 注册
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	@ResponseBody
	public String register(@RequestParam("phoneNum") String phoneNum,
			@RequestParam("pwd") String pwd,
			@RequestParam("registerCode") String registerCode,
			final HttpSession session) {
		TransferMessage message = new TransferMessage();
		if (phoneNum == null || phoneNum.equals("") || pwd == null
				|| pwd.equals("") || registerCode == null
				|| registerCode.equals("")) {
			message.setCode(CResponse.Code.REQUEST_ERROR);
			message.setMessage(CResponse.Message.REGIST_ERROR_PARMANTS);
			message.setResultMap(null);

		} else {
			YUser user = new YUser();
			user.setPassword(pwd);
			user.setPhoneNumber(phoneNum);
			user.setCreateTime(new Date());
			user.setNickName(phoneNum);// 默认名
			message = userService.register(user, session, registerCode,
					phoneNum);
		}
		return JacksonUtil.writeEntity2JSON(message);

	}

	// 验证注册码
	@RequestMapping(value = "/getRegisterCode", method = RequestMethod.GET)
	@ResponseBody
	public String getRegisterCode(@RequestParam("phoneNum") String phoneNum,
			final HttpSession session) {
		String codeString = String.valueOf(RandomUtils.getRandom(0, 999999));
		long time = System.currentTimeMillis();
		session.setAttribute(phoneNum, time + "-" + codeString);
		JPushUtil.getInstant().sendPush(
				JPushUtil.buildPushObject_all_all_alert(codeString));
		return codeString;
	}
}
