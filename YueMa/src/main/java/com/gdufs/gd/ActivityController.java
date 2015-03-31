package com.gdufs.gd;

import java.util.Date;
import java.util.List;
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

import com.gdufs.gd.entity.YActivity;
import com.gdufs.gd.entity.YActivityUser;
import com.gdufs.gd.entity.YUser;
import com.gdufs.gd.service.YActivityService;
import com.gdufs.gd.service.YActivityUserService;
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

	@Resource(name = "userService")
	private YUserService userService;

	@Resource(name = "activityUserService")
	private YActivityUserService activityUserService;

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index(Locale locale, Model model) {
		return "activity";
	}

	// 上传图文

	// 发起活动
	@RequestMapping(value = "/newActivity", method = RequestMethod.GET)
	@ResponseBody
	public String newActivity(final HttpServletRequest request,
			@RequestParam("uId") int uId, final HttpSession session) {
		YActivity activity = new YActivity();
		YUser creator = userService.getUserById(uId);
		activity.setTitle("中心湖");
		activity.setIntroduce("骑单车");
		activity.setCreateTimeDate(new Date());
		activity.setBeginTime(new Date());
		activity.setEndTime(new Date());
		activity.setPerCost(10.5);
		activity.setBulkLink("http://www.baidu.com");
		activity.setActivityAddress("中心湖");
		activity.setActivityAddressLatitude("15.25685");
		activity.setActivityAddressLongitude("18.25685");
		activity.setCollectAddress("中行");
		activity.setCollectAddressLatitude("465.06548465");
		activity.setCollectAddressLongitude("465.06548465");
		activity.setMaxCount(10);
		activity.setCreator(creator);
		activityService.add(activity);
		return JacksonUtil.writeEntity2JSON("");
	}

	// 获取创建者所创建的所有活动
	@RequestMapping(value = "/getCreatorActivities", method = RequestMethod.GET)
	@ResponseBody
	public String getCreatorActivities(final HttpServletRequest request,
			@RequestParam("uId") int uId, final HttpSession session) {
		List<YActivity> activitiesList = activityService
				.getActivityByCreatorId(uId);
		return JacksonUtil.writeEntity2JSON(activitiesList.toString());
	}

	@RequestMapping(value = "/deleteActivity", method = RequestMethod.GET)
	@ResponseBody
	public String deleteActivity(final HttpServletRequest request,
			@RequestParam("activityId") int activityId,
			final HttpSession session) {
		activityService.deleteActivity(activityId);
		return "";
	}

	// 参与活动
	@RequestMapping(value = "/joinActivity", method = RequestMethod.GET)
	@ResponseBody
	public String joinActivity(@RequestParam("uId") int uId,
			@RequestParam("activityId") int activityId) {
		boolean isJoin = activityUserService.joinActivity(uId, activityId);
		return "";
	}

	// 退出活动
	@RequestMapping(value = "/quitActivity", method = RequestMethod.GET)
	@ResponseBody
	public String quitActivity(@RequestParam("uId") int uId,
			@RequestParam("activityId") int activityId) {
		boolean isQuit = activityUserService.quitActivity(uId, activityId);
		return "";
	}
}
