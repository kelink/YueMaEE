package com.gdufs.gd;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

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

import com.gdufs.gd.entity.TransferMessage;
import com.gdufs.gd.entity.YContact;
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

	// 添加通讯录
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	@ResponseBody
	public String addContact(
			@RequestParam(value = "contact", defaultValue = "", required = true) List<YContact> contact) {
		TransferMessage messageObj = new TransferMessage();

		messageObj.setCode("1003");
		messageObj.setExpire(new Date());
		messageObj.setMessage("test");

		// JsonObject object = new JsonObject();
		// object.addProperty("22", "test");
		// object.addProperty("52", "test");
		//
		// HashMap<String, String> aHashMap = new HashMap<String, String>();
		// aHashMap.put("jj", "sad");
		// messageObj.setResultMap(aHashMap);
		// System.out.println(JacksonUtil.writeEntity2JSON(messageObj));
		// return object.toString();
		return null;
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
