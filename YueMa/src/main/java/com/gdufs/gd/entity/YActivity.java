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
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "YActivity")
public class YActivity implements Serializable {
	private static final long serialVersionUID = 6495310789414594716L;

	public YActivity() {
		super();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", length = 11)
	private int id;

	@OneToOne
	@JoinColumn(name = "creator_Id")
	private YUser creator;

	@Column(name = "title", length = 50, nullable = false)
	private String title;// 活动的title或者name

	@Column(name = "introduce", length = 100, nullable = false)
	private String introduce;// 活动的简介

	@OneToMany(targetEntity = YPicture.class, cascade = CascadeType.ALL)
	@Fetch(FetchMode.JOIN)
	// updatable=false很关键，如果没有它，在级联删除的时候就会报错(反转的问题)
	@JoinColumn(name = "activity_Id", updatable = false)
	private Set<YPicture> pictures = new HashSet<YPicture>();// 活动添加的图片

	@OneToMany(targetEntity = YLabel.class, cascade = CascadeType.ALL)
	@Fetch(FetchMode.JOIN)
	// updatable=false很关键，如果没有它，在级联删除的时候就会报错(反转的问题)
	@JoinColumn(name = "activity_Id", updatable = false)
	private Set<YLabel> labels = new HashSet<YLabel>();// 活动添加的标签

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

	@Column(name = "collectAddressLatitude", length = 50, nullable = false)
	private String collectAddressLatitude;// 纬度

	@Column(name = "count", length = 11, nullable = false)
	private int count;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public YUser getCreator() {
		return creator;
	}

	public void setCreator(YUser creator) {
		this.creator = creator;
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

	public Set<YPicture> getPictures() {
		return pictures;
	}

	public void setPictures(Set<YPicture> pictures) {
		this.pictures = pictures;
	}

	public Set<YLabel> getLabels() {
		return labels;
	}

	public void setLabels(Set<YLabel> labels) {
		this.labels = labels;
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

	public String getCollectAddressLatitude() {
		return collectAddressLatitude;
	}

	public void setCollectAddressLatitude(String collectAddressLatitude) {
		this.collectAddressLatitude = collectAddressLatitude;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "YActivity [id=" + id + ", creator=" + creator + ", title="
				+ title + ", introduce=" + introduce + ", pictures=" + pictures
				+ ", labels=" + labels + ", createTimeDate=" + createTimeDate
				+ ", beginTime=" + beginTime + ", endTime=" + endTime
				+ ", perCost=" + perCost + ", bulkLink=" + bulkLink
				+ ", activityAddress=" + activityAddress + ", collectAddress="
				+ collectAddress + ", activityAddressLongitude="
				+ activityAddressLongitude + ", collectAddressLatitude="
				+ collectAddressLatitude + ", count=" + count + "]";
	}

}
