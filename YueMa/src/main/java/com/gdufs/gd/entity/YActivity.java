package com.gdufs.gd.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "YActivity")
public class YActivity implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private Set<YActivityUser> activityUsers = new HashSet<YActivityUser>();
	private Set<YPicture> pictures;//该活动的图片
	private Set<YLabel> labels;//活动所带的标签
	private YUser creator;// 创建者
	private String title;// 活动的title或者name
	private String introduce;// 活动的简介
	private Date createTimeDate;// 活动创建日期
	private Date beginTime;// 活动开始时间
	private Date endTime;// 活动结束时间
	private double perCost;// 活动预期花费每个人
	private String bulkLink;// 团购链接
	private String activityAddress;// 活动地点
	private String collectAddress;
	private String activityAddressLongitude;// 经度
	private String activityAddressLatitude;// 纬度
	private String collectAddressLongitude;// 纬度
	private String collectAddressLatitude;// 纬度
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

	 @OneToMany(mappedBy = "activity", cascade = CascadeType.ALL, fetch =
	 FetchType.LAZY)
	public Set<YActivityUser> getActivityUsers() {
		return activityUsers;
	}

	public void setActivityUsers(Set<YActivityUser> activityUsers) {
		this.activityUsers = activityUsers;
	}

	@Column(name = "title", length = 50, nullable = false)
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name = "introduce", length = 100, nullable = false)
	public String getIntroduce() {
		return introduce;
	}

	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}

	@Column(name = "createTimeDate", length = 50, nullable = false)
	@DateTimeFormat(pattern = "yyyy-mm-dd hh:mm:ss")
	public Date getCreateTimeDate() {
		return createTimeDate;
	}

	public void setCreateTimeDate(Date createTimeDate) {
		this.createTimeDate = createTimeDate;
	}

	@Column(name = "beginTime", length = 50, nullable = false)
	@DateTimeFormat(pattern = "yyyy-mm-dd hh:mm:ss")
	public Date getBeginTime() {
		return beginTime;
	}

	public void setBeginTime(Date beginTime) {
		this.beginTime = beginTime;
	}

	@Column(name = "endTime", length = 50, nullable = false)
	@DateTimeFormat(pattern = "yyyy-mm-dd hh:mm:ss")
	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	@Column(name = "perCost", length = 20, nullable = false)
	public double getPerCost() {
		return perCost;
	}

	public void setPerCost(double perCost) {
		this.perCost = perCost;
	}

	@Column(name = "bulkLink", length = 100, nullable = false)
	public String getBulkLink() {
		return bulkLink;
	}

	public void setBulkLink(String bulkLink) {
		this.bulkLink = bulkLink;
	}

	@Column(name = "activityAddress", length = 100, nullable = false)
	public String getActivityAddress() {
		return activityAddress;
	}

	public void setActivityAddress(String activityAddress) {
		this.activityAddress = activityAddress;
	}

	@Column(name = "collectAddress", length = 100, nullable = false)
	public String getCollectAddress() {
		return collectAddress;
	}

	public void setCollectAddress(String collectAddress) {
		this.collectAddress = collectAddress;
	}

	@Column(name = "activityAddressLongitude", length = 50, nullable = false)
	public String getActivityAddressLongitude() {
		return activityAddressLongitude;
	}

	public void setActivityAddressLongitude(String activityAddressLongitude) {
		this.activityAddressLongitude = activityAddressLongitude;
	}

	@Column(name = "activityAddressLatitude", length = 50, nullable = false)
	public String getActivityAddressLatitude() {
		return activityAddressLatitude;
	}

	public void setActivityAddressLatitude(String activityAddressLatitude) {
		this.activityAddressLatitude = activityAddressLatitude;
	}

	@Column(name = "collectAddressLongitude", length = 50, nullable = false)
	public String getCollectAddressLongitude() {
		return collectAddressLongitude;
	}

	public void setCollectAddressLongitude(String collectAddressLongitude) {
		this.collectAddressLongitude = collectAddressLongitude;
	}

	@Column(name = "collectAddressLatitude", length = 50, nullable = false)
	public String getCollectAddressLatitude() {
		return collectAddressLatitude;
	}

	public void setCollectAddressLatitude(String collectAddressLatitude) {
		this.collectAddressLatitude = collectAddressLatitude;
	}

	@Column(name = "maxCount", length = 11, nullable = false)
	public int getMaxCount() {
		return maxCount;
	}

	public void setMaxCount(int maxCount) {
		this.maxCount = maxCount;
	}

	@ManyToOne
	@JoinColumn(name = "creatorId")
	public YUser getCreator() {
		return creator;
	}

	public void setCreator(YUser creator) {
		this.creator = creator;
	}
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, targetEntity = YPicture.class)
	@JoinColumn(name = "activityId")
	public Set<YPicture> getPictures() {
		return pictures;
	}

	public void setPictures(Set<YPicture> pictures) {
		this.pictures = pictures;
	}
	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, targetEntity = YLabel.class)
	@JoinColumn(name = "activityId")
	public Set<YLabel> getLabels() {
		return labels;
	}

	public void setLabels(Set<YLabel> labels) {
		this.labels = labels;
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

	@Override
	public String toString() {
		return "YActivity [id=" + id + ", activityUsers=" + activityUsers
				+ ", creator=" + creator + ", title=" + title + ", introduce="
				+ introduce + ", createTimeDate=" + createTimeDate
				+ ", beginTime=" + beginTime + ", endTime=" + endTime
				+ ", perCost=" + perCost + ", bulkLink=" + bulkLink
				+ ", activityAddress=" + activityAddress + ", collectAddress="
				+ collectAddress + ", activityAddressLongitude="
				+ activityAddressLongitude + ", activityAddressLatitude="
				+ activityAddressLatitude + ", collectAddressLongitude="
				+ collectAddressLongitude + ", collectAddressLatitude="
				+ collectAddressLatitude + ", maxCount=" + maxCount + "]";
	}

}