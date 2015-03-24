package com.gdufs.gd.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "YActivity")
public class YActivity implements Serializable {

	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	private double price;

	private Set<YActivityUser> activityUsers;

	private YUser creator;// 创建者

	@Column(name = "title", length = 50, nullable = false)
	private String title;// 活动的title或者name

	@Column(name = "introduce", length = 100, nullable = false)
	private String introduce;// 活动的简介

	@Column(name = "createTimeDate", length = 50, nullable = false)
	@DateTimeFormat(pattern = "yyyy-mm-dd hh:mm:ss")
	private Date createTimeDate;// 活动创建日期

	@Column(name = "beginTime", length = 50, nullable = false)
	@DateTimeFormat(pattern = "yyyy-mm-dd hh:mm:ss")
	private Date beginTime;// 活动开始时间

	@Column(name = "endTime", length = 50, nullable = false)
	@DateTimeFormat(pattern = "yyyy-mm-dd hh:mm:ss")
	private Date endTime;// 活动结束时间

	@Column(name = "perCost", length = 20, nullable = false)
	private float perCost;// 活动预期花费每个人

	@Column(name = "bulkLink", length = 100, nullable = false)
	private String bulkLink;// 团购链接

	@Column(name = "activityAddress", length = 100, nullable = false)
	private String activityAddress;// 活动地点

	@Column(name = "collectAddress", length = 100, nullable = false)
	private String collectAddress;

	@Column(name = "activityAddressLongitude", length = 50, nullable = false)
	private String activityAddressLongitude;// 经度

	@Column(name = "activityAddressLatitude", length = 50, nullable = false)
	private String activityAddressLatitude;// 纬度

	@Column(name = "collectAddressLongitude", length = 50, nullable = false)
	private String collectAddressLongitude;// 纬度

	@Column(name = "collectAddressLatitude", length = 50, nullable = false)
	private String collectAddressLatitude;// 纬度

	@Column(name = "maxCount", length = 11, nullable = false)
	private int maxCount;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(length = 11, name = "id")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@OneToMany(mappedBy = "activity")
	public Set<YActivityUser> getActivityUsers() {
		return activityUsers;
	}

	public void setActivityUsers(Set<YActivityUser> activityUsers) {
		this.activityUsers = activityUsers;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getIntroduce() {
		return introduce;
	}

	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}

	public Date getCreateTimeDate() {
		return createTimeDate;
	}

	public void setCreateTimeDate(Date createTimeDate) {
		this.createTimeDate = createTimeDate;
	}

	public Date getBeginTime() {
		return beginTime;
	}

	public void setBeginTime(Date beginTime) {
		this.beginTime = beginTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public float getPerCost() {
		return perCost;
	}

	public void setPerCost(float perCost) {
		this.perCost = perCost;
	}

	public String getBulkLink() {
		return bulkLink;
	}

	public void setBulkLink(String bulkLink) {
		this.bulkLink = bulkLink;
	}

	public String getActivityAddress() {
		return activityAddress;
	}

	public void setActivityAddress(String activityAddress) {
		this.activityAddress = activityAddress;
	}

	public String getCollectAddress() {
		return collectAddress;
	}

	public void setCollectAddress(String collectAddress) {
		this.collectAddress = collectAddress;
	}

	public String getActivityAddressLongitude() {
		return activityAddressLongitude;
	}

	public void setActivityAddressLongitude(String activityAddressLongitude) {
		this.activityAddressLongitude = activityAddressLongitude;
	}

	public String getActivityAddressLatitude() {
		return activityAddressLatitude;
	}

	public void setActivityAddressLatitude(String activityAddressLatitude) {
		this.activityAddressLatitude = activityAddressLatitude;
	}

	public String getCollectAddressLongitude() {
		return collectAddressLongitude;
	}

	public void setCollectAddressLongitude(String collectAddressLongitude) {
		this.collectAddressLongitude = collectAddressLongitude;
	}

	public String getCollectAddressLatitude() {
		return collectAddressLatitude;
	}

	public void setCollectAddressLatitude(String collectAddressLatitude) {
		this.collectAddressLatitude = collectAddressLatitude;
	}

	public int getMaxCount() {
		return maxCount;
	}

	public void setMaxCount(int maxCount) {
		this.maxCount = maxCount;
	}

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "creatorId")
	public YUser getCreator() {
		return creator;
	}

	public void setCreator(YUser creator) {
		this.creator = creator;
	}

	@Override
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
		YActivity other = (YActivity) obj;
		if (id != other.id)
			return false;
		return true;
	}
}