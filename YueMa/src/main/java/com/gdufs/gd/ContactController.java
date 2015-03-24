//package com.gdufs.gd;
//
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.HashMap;
//import java.util.Iterator;
//import java.util.List;
//import java.util.Locale;
//
//import javax.annotation.Resource;
//import javax.validation.groups.Default;
//
//import org.codehaus.jackson.JsonEncoding;
//import org.codehaus.jackson.JsonGenerator;
//import org.codehaus.jackson.map.ObjectMapper;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import com.gdufs.gd.common.CResponse;
//import com.gdufs.gd.entity.TransferMessage;
//import com.gdufs.gd.entity2.YContact;
//import com.gdufs.gd.service.YContactService;
//import com.gdufs.gd.util.JacksonUtil;
//import com.google.gson.JsonObject;
//
///**
// * handle request for application contact update 返回消息格式() code: message: time
// * 
// * @author Administrator
// *
// */
//@Controller
//@RequestMapping("/contact")
//public class ContactController {
//
//	private static final Logger logger = LoggerFactory
//			.getLogger(ContactController.class);
//
//	@Resource(name = "contactService")
//	private YContactService contactService;
//
//	/**
//	 * 添加通讯录 （发生更改时候需要更新二度人脉关系表）
//	 * 
//	 * @param contactList
//	 * @return
//	 */
//	@RequestMapping(value = { "/addContact" }, method = { RequestMethod.POST })
//	@ResponseBody
//	public String addContact(
//			@RequestParam(value = "contacts", defaultValue = "") List<YContact> contactList) {
//		TransferMessage messageObj = new TransferMessage();
//		if (contactService.addContactList(contactList) == true) {
//			messageObj.setCode(CResponse.Code.SUCCESS);
//			messageObj.setExpire(new Date());
//			messageObj.setMessage(CResponse.Message.SUCCESS);
//			logger.info("add contact success");
//		} else {
//			messageObj.setCode(CResponse.Code.ERROR);
//			messageObj.setExpire(new Date());
//			messageObj.setMessage(CResponse.Message.ERROR);
//			logger.error("add contact fail");
//		}
//		return JacksonUtil.writeEntity2JSON(messageObj);
//	}
//
//	/**
//	 * 获取表的所有通讯录
//	 */
//
//	/**
//	 * 获取表的所有通讯录
//	 */
//
//	/**
//	 * 更新通信录
//	 */
//	@RequestMapping(value = { "/updateContact" }, method = { RequestMethod.POST })
//	@ResponseBody
//	public String updateContact(
//			@RequestParam(value = "contacts", defaultValue = "") List<YContact> contactList) {
//
//		TransferMessage messageObj = new TransferMessage();
//		if (contactService.addContactList(contactList) == true) {
//			messageObj.setCode(CResponse.Code.SUCCESS);
//			messageObj.setExpire(new Date());
//			messageObj.setMessage(CResponse.Message.SUCCESS);
//			logger.info("update contact success");
//		} else {
//			messageObj.setCode(CResponse.Code.ERROR);
//			messageObj.setExpire(new Date());
//			messageObj.setMessage(CResponse.Message.ERROR);
//			logger.error("update contact fail");
//		}
//		return JacksonUtil.writeEntity2JSON(messageObj);
//	}
//
// }
