package com.gdufs.gd.entity2;
//package com.gdufs.gd.entity;
//
//import java.io.Serializable;
//import java.util.Date;
//
//import com.google.gson.Gson;
//
//public class JPushMessage implements Serializable, Comparable<JPushMessage> {
//	private static final long serialVersionUID = 2098144222822581428L;
//	int id;
//	String title;
//	String content;
//	String channel;
//	long time;
//
//	// boolean readable;
//	public JPushMessage() {
//	}
//
//	public JPushMessage(int id, String title, String content, String channel) {
//		this.id = id;
//		this.title = title;
//		this.content = content;
//		this.channel = channel;
//		this.time = new Date().getTime();
//	}
//
//	@Override
//	public int compareTo(JPushMessage o) {
//		if (null == o)
//			return -1;
//		if (o.id == this.id)
//			return 0;
//		if (o.id > this.id)
//			return -1;
//		else
//			return 1;
//	}
//
//	@Override
//	public boolean equals(Object o) {
//		if (null == o)
//			return false;
//		if (!(o instanceof JPushMessage)) {
//			return false;
//		}
//		JPushMessage message = (JPushMessage) o;
//		return this.id == message.id;
//	}
//
//	@Override
//	public int hashCode() {
//		return this.id;
//	}
//
//	@Override
//	public String toString() {
//		return new Gson().toJson(this);
//	}
//
//	public int getId() {
//		return id;
//	}
//
//	public void setId(int id) {
//		this.id = id;
//	}
//
//	public String getTitle() {
//		return title;
//	}
//
//	public void setTitle(String title) {
//		this.title = title;
//	}
//
//	public String getContent() {
//		return content;
//	}
//
//	public void setContent(String content) {
//		this.content = content;
//	}
//
//	public String getChannel() {
//		return channel;
//	}
//
//	public void setChannel(String channel) {
//		this.channel = channel;
//	}
//
//	public long getTime() {
//		return time;
//	}
//
//	public void setTime(long time) {
//		this.time = time;
//	}
//
// }
