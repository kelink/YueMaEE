package com.gdufs.gd.entity;

import java.io.Serializable;
import java.util.Calendar;
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
	private Calendar date;
	private Set<YActivityUser> activityUsers;

	private Set<YActivity> activities;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, targetEntity = YActivity.class)
	@JoinColumn(name = "creatorId")
	public Set<YActivity> getActivities() {
		return activities;
	}

	public void setActivities(Set<YActivity> activities) {
		this.activities = activities;
	}

	@Column(name = "nickName", length = 20, nullable = false)
	private String nickName;

	@Column(length = 13, nullable = false)
	private String phoneNumber;

	@Column(length = 100, nullable = false)
	private String password;

	@Column(length = 50, nullable = false)
	private String facePath;

	@Column(length = 20, nullable = false)
	private String introduce;

	@Column(length = 50, nullable = false)
	@DateTimeFormat(pattern = "yyyy-mm-dd hh:mm:ss")
	private Date createTime;

	@Column(length = 50, nullable = false)
	@DateTimeFormat(pattern = "yyyy-mm-dd hh:mm:ss")
	private Date lastLoginTimeDate;

	@Column(length = 50, nullable = false)
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

	public Calendar getDate() {
		return date;
	}

	public void setDate(Calendar date) {
		this.date = date;
	}

	@OneToMany(mappedBy = "user")
	public Set<YActivityUser> getActivityUsers() {
		return activityUsers;
	}

	public void setActivityUsers(Set<YActivityUser> activityUsers) {
		this.activityUsers = activityUsers;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFacePath() {
		return facePath;
	}

	public void setFacePath(String facePath) {
		this.facePath = facePath;
	}

	public String getIntroduce() {
		return introduce;
	}

	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getLastLoginTimeDate() {
		return lastLoginTimeDate;
	}

	public void setLastLoginTimeDate(Date lastLoginTimeDate) {
		this.lastLoginTimeDate = lastLoginTimeDate;
	}

	public String getLastLoginIp() {
		return lastLoginIp;
	}

	public void setLastLoginIp(String lastLoginIp) {
		this.lastLoginIp = lastLoginIp;
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