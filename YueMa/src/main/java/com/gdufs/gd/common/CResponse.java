package com.gdufs.gd.common;

public class CResponse {
	public class Code {
		public final static int SUCCESS = 0;
		public final static int REQUEST_ERROR = 1;
		public final static int NETWORK_ERROR = 2;
		public final static int UNKNOWN_ERROR = 3;
		public final static int ERROR = 4;
		public final static int NOT_FUND = 5;
	}

	public class Message {
		public final static String SUCCESS = "Execute successfully";
		public final static String REQUEST_ERROR = "Request occured error";
		public final static String NETWORK_ERROR = "NetWork occured error";
		public final static String UNKNOWN_ERROR = "Unknown error";
		public final static String ERROR = "Execute occured error";
		public final static String NOT_FUND = "Resource not found";
	}
}
