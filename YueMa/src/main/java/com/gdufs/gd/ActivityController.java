package com.gdufs.gd;

import java.util.Date;
import java.util.Locale;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gdufs.gd.service.YActivityService;
import com.gdufs.gd.service.YUserService;
import com.gdufs.gd.util.JacksonUtil;

@Controller
@RequestMapping("/activity")
public class ActivityController {

	private static final Logger logger = LoggerFactory
			.getLogger(ActivityController.class);

	public ActivityController() {
	}

	@Resource(name = "activityService")
	private YActivityService activityService;

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index(Locale locale, Model model) {
		return "activity";
	}

	// 发起活动
	@RequestMapping(value = "/newActivity", method = RequestMethod.POST)
	@ResponseBody
	public String newActivity(@RequestParam("phoneNum") String phoneNum,
			@RequestParam("pwd") String pwd,
			@RequestParam("registerCode") String registerCode,
			final HttpServletRequest request, final HttpSession session) {
		request.getParameter("");
		return JacksonUtil.writeEntity2JSON("");

	}

}
