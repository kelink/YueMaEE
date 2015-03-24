package com.gdufs.gd.entity2;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;

public class YMessageUser {

	public YMessageUser() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(length = 11, name = "id")
	private int id;

	@Column(name = "userId", length = 11, nullable = false)
	private int userId;

	@Column(name = "messageId", length = 11, nullable = false)
	private int messageId;

	@Column(name = "isRead", length = 11, nullable = false)
	private int isRead;

	@Column(name = "readTime", length = 11, nullable = false)
	@DateTimeFormat(pattern = "yyyy-mm-dd hh:mm:ss")
	private int readTime;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getMessageId() {
		return messageId;
	}

	public void setMessageId(int messageId) {
		this.messageId = messageId;
	}

	public int getIsRead() {
		return isRead;
	}

	public void setIsRead(int isRead) {
		this.isRead = isRead;
	}

	public int getReadTime() {
		return readTime;
	}

	public void setReadTime(int readTime) {
		this.readTime = readTime;
	}

	@Override
	public String toString() {
		return "YMessageUser [id=" + id + ", userId=" + userId + ", messageId="
				+ messageId + ", isRead=" + isRead + ", readTime=" + readTime
				+ "]";
	}

}
