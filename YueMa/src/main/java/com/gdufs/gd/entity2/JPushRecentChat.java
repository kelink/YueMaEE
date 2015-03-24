package com.gdufs.gd.entity2;
//package com.gdufs.gd.entity;
//
//import java.util.Calendar;
//import java.util.Date;
//
//import com.gdufs.gd.util.ServiceUtils;
//
//public class JPushRecentChat implements Comparable<JPushRecentChat> {
//	private String chatting;
//	private boolean isChannel;
//	private int unReadNumber;
//	private Date lastUpdated;
//
//	public JPushRecentChat(String chatting) {
//		this.chatting = chatting;
//		if (chatting.startsWith(ServiceUtils.CHANNEL_PREFIX)) {
//			this.isChannel = true;
//		} else {
//			this.isChannel = false;
//		}
//		this.lastUpdated = new Date();
//	}
//
//	public void clearUnread() {
//		this.unReadNumber = 0;
//	}
//
//	public void increaseUnread() {
//		this.unReadNumber++;
//		this.lastUpdated = new Date();
//	}
//
//	public boolean isToday() {
//		Calendar now = Calendar.getInstance();
//		Calendar updated = Calendar.getInstance();
//		updated.setTimeInMillis(lastUpdated.getTime());
//		return (now.get(Calendar.DAY_OF_YEAR) == updated
//				.get(Calendar.DAY_OF_YEAR));
//	}
//
//	public String getChatTarget(String myName) {
//		return chatting.substring(1, chatting.length());
//	}
//
//	public String getIsChannel() {
//		return String.valueOf(isChannel);
//	}
//
//	@Override
//	public int compareTo(JPushRecentChat o) {
//		if (null == o)
//			return -1;
//		JPushRecentChat rc = o;
//		return this.lastUpdated.compareTo(rc.lastUpdated);
//	}
//
//	@Override
//	public boolean equals(Object o) {
//		if (null == o)
//			return false;
//		if (!(o instanceof JPushRecentChat)) {
//			return false;
//		}
//		JPushRecentChat rc = (JPushRecentChat) o;
//		return this.toString().equals(rc.toString());
//	}
//
//	@Override
//	public int hashCode() {
//		return (int) lastUpdated.getTime();
//	}
//
//	@Override
//	public String toString() {
//		return "RecentChat - chatting:" + chatting + ", isChannel:" + isChannel
//				+ ", unReadNumber:" + unReadNumber + ", lastUpdateTime"
//				+ lastUpdated;
//	}
//
//	public String getChatting() {
//		return chatting;
//	}
//
//	public void setChatting(String chatting) {
//		this.chatting = chatting;
//	}
//
//	public boolean isChannel() {
//		return isChannel;
//	}
//
//	public void setChannel(boolean isChannel) {
//		this.isChannel = isChannel;
//	}
//
//	public int getUnReadNumber() {
//		return unReadNumber;
//	}
//
//	public void setUnReadNumber(int unReadNumber) {
//		this.unReadNumber = unReadNumber;
//	}
//
//	public Date getLastUpdated() {
//		return lastUpdated;
//	}
//
//	public void setLastUpdated(Date lastUpdated) {
//		this.lastUpdated = lastUpdated;
//	}
//
// }
