package com.gdufs.gd.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "YUser")
public class YUser implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private Set<YActivityUser> activityUsers;
	private Set<YBulletinUser> bulletinUsers;
	private Set<YActivity> activities;
	private Set<YMessageUser> messageUsers;
	private Set<YRemindUser> remindUsers;
	private String nickName;
	private String phoneNumber;
	private String password;
	private String facePath;
	private String introduce;
	private Date createTime;
	private Date lastLoginTimeDate;
	private String lastLoginIp;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(length = 11, name = "id")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@OneToMany(mappedBy = "user")
	public Set<YActivityUser> getActivityUsers() {
		return activityUsers;
	}

	public void setActivityUsers(Set<YActivityUser> activityUsers) {
		this.activityUsers = activityUsers;
	}

	@OneToMany(mappedBy = "user")
	public Set<YBulletinUser> getBulletinUsers() {
		return bulletinUsers;
	}

	public void setBulletinUsers(Set<YBulletinUser> bulletinUsers) {
		this.bulletinUsers = bulletinUsers;
	}

	@OneToMany(mappedBy = "user")
	public Set<YMessageUser> getMessageUsers() {
		return messageUsers;
	}

	public void setMessageUsers(Set<YMessageUser> messageUsers) {
		this.messageUsers = messageUsers;
	}

	@OneToMany(mappedBy = "user")
	public Set<YRemindUser> getRemindUsers() {
		return remindUsers;
	}

	public void setRemindUsers(Set<YRemindUser> remindUsers) {
		this.remindUsers = remindUsers;
	}

	@Column(name = "nickName", length = 20, nullable = false)
	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	@Column(length = 13, nullable = false)
	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Column(length = 100, nullable = false)
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(length = 50)
	public String getFacePath() {
		return facePath;
	}

	public void setFacePath(String facePath) {
		this.facePath = facePath;
	}

	@Column(length = 20)
	public String getIntroduce() {
		return introduce;
	}

	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}

	@Column(length = 50, nullable = false)
	@DateTimeFormat(pattern = "yyyy-mm-dd hh:mm:ss")
	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Column(length = 50)
	@DateTimeFormat(pattern = "yyyy-mm-dd hh:mm:ss")
	public Date getLastLoginTimeDate() {
		return lastLoginTimeDate;
	}

	public void setLastLoginTimeDate(Date lastLoginTimeDate) {
		this.lastLoginTimeDate = lastLoginTimeDate;
	}

	@Column(length = 50)
	public String getLastLoginIp() {
		return lastLoginIp;
	}

	public void setLastLoginIp(String lastLoginIp) {
		this.lastLoginIp = lastLoginIp;
	}

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, targetEntity = YActivity.class)
	@JoinColumn(name = "creatorId")
	public Set<YActivity> getActivities() {
		return activities;
	}

	public void setActivities(Set<YActivity> activities) {
		this.activities = activities;
	}

	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		YUser other = (YUser) obj;
		if (id != other.id)
			return false;
		return true;
	}
}