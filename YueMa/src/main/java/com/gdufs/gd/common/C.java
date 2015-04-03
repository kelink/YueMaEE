package com.gdufs.gd.common;

public class C {
	// 请求参数的同一名称
	public class ParamsName {
		public static final String USERNAME = "userName";
		public static final String PASSWORD = "pwd";
		public static final String PHONE_NUM = "phoneNum";
		public static final String UID = "uID";
		public static final String REGIST_CODE = "registCode";
		public static final String CONTACT = "contact";
		public static final String HOST_NUM = "hostNum";
	}
	//用于返回的参数
	public class ResponseCode {
		public final static String NOEXCUTE ="-1" ;
		public final static String SUCCESS ="1";
		public final static String ERROR = "2";

	}

	public class ResponseMessage {
		public final static String REGIST_ERROR_PARMANTS = "error parmant";
		public final static String REGIST_CODE_TIME_OUT = "code over time, please get regist code again";
		public final static String REGIST_DB_ERROR = "regist in database error";
		public final static String NOEXCUTE = "no process current request";
		public final static String SUCCESS = "Execute successfully";
		public final static String REQUEST_ERROR = "Request occured error";
		public final static String NETWORK_ERROR = "NetWork occured error";
		public final static String UNKNOWN_ERROR = "Unknown error";
		public final static String ERROR = "execute error";
		public final static String NOT_FUND = "404 NOT Fund";
	}

}
