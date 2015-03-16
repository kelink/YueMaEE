package com.gdufs.gd;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

import javax.annotation.Resource;
import javax.validation.groups.Default;

import org.codehaus.jackson.JsonEncoding;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gdufs.gd.common.CResponse;
import com.gdufs.gd.entity.TransferMessage;
import com.gdufs.gd.entity.YContact;
import com.gdufs.gd.entity.YUser;
import com.gdufs.gd.service.YContactService;
import com.gdufs.gd.service.YUserService;
import com.gdufs.gd.util.JacksonUtil;
import com.google.gson.JsonObject;

/**
 * handle request for application contact update 返回消息格式() code: message: time
 * 
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/contact")
public class ContactController {

	private static final Logger logger = LoggerFactory
			.getLogger(ContactController.class);

	@Resource(name = "contactService")
	private YContactService contactService;

	// 添加通讯录
	@RequestMapping(value = "/addContact", method = RequestMethod.GET)
	@ResponseBody
	public String addContact() {
		TransferMessage messageObj = new TransferMessage();
		YContact contact = new YContact();
		YUser user = new YUser();
		user.setId(2);
		contact.setUser(user);
		contact.setHostName("a");
		contact.setHostNum("11");
		contact.setFriendNum("22");
		contact.setFirendName("b");
		contact.setVersion(0);
		ArrayList<YContact> list = new ArrayList<YContact>();
		list.add(contact);

		if (contactService.addContactList(list) == true) {
			messageObj.setCode(CResponse.Code.SUCCESS);
			messageObj.setExpire(new Date());
			messageObj.setMessage(CResponse.Message.SUCCESS);
		} else {
			messageObj.setCode(CResponse.Code.ERROR);
			messageObj.setExpire(new Date());
			messageObj.setMessage(CResponse.Message.ERROR);
		}
		return JacksonUtil.writeEntity2JSON(messageObj);
	}

	// /**
	// * 更新通信录 code: (0~4) message:0 成功，1 请求参数错误,2网络异常，3未知原因，4更新出错 time:时间
	// */
	// @RequestMapping(value = { "/updateContact" }, method = {
	// RequestMethod.GET })
	// @ResponseBody
	// public String updateContact(
	// @RequestParam(value = "contacts", defaultValue = "") List<String>
	// contacts,
	// @RequestParam(value = "uid", defaultValue = "") int uid,
	// @RequestParam(value = "uNum", defaultValue = "") String uNum) {
	//
	// return "test";
	// }

}
