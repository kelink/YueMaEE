package com.gdufs.gd.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * 公告-用户类
 * 
 * @author Administrator
 *
 */
@Entity
@Table(name = "YBulletinUser")
@IdClass(YBulletinUserPK.class)
public class YBulletinUser implements Serializable {

	private static final long serialVersionUID = 1L;

	public YBulletinUser() {
	}

	private YBulletin bulletin;
	private YUser user;

	@Id
	public YBulletin getBulletin() {
		return bulletin;
	}

	public void setBulletin(YBulletin bulletin) {
		this.bulletin = bulletin;
	}

	@Id
	public YUser getUser() {
		return user;
	}

	public void setUser(YUser user) {
		this.user = user;
	}

	@Column(name = "isRead", length = 11, nullable = false)
	private int isRead;

	@Column(name = "readTime", length = 11, nullable = false)
	@DateTimeFormat(pattern = "yyyy-mm-dd hh:mm:ss")
	private Date readTime;

	public int getIsRead() {
		return isRead;
	}

	public void setIsRead(int isRead) {
		this.isRead = isRead;
	}

	public Date getReadTime() {
		return readTime;
	}

	public void setReadTime(Date readTime) {
		this.readTime = readTime;
	}

}
