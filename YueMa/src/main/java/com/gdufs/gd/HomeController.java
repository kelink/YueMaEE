package com.gdufs.gd;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gdufs.gd.entity.YUser;
import com.gdufs.gd.service.YUserService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Resource(name="userService")
	private YUserService userService;
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String test(Locale locale, Model model) {
			YUser user=new YUser();
			user.setFacePath("C:\\1.jpg");
			user.setIntroduce("test");
			user.setCreateTime(new Date());
			user.setNickName("test");
			user.setPassword("123321");
			user.setPhoneNumber("18825162514");
			user.setLastLoginMac("192.168.202.73");	
			user.setLastLoginTimeDate(new Date());
			userService.addYUser(user);
			//System.out.println(userService.getYUserById("20150111001"));
		return "home";
	}
	
}
