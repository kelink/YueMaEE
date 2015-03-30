package com.gdufs.gd.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 二度人脉表
 * 
 * @author Administrator
 *
 */
@Entity
@Table(name = "YRelationSecond")
public class YRelationSecond {

	public YRelationSecond() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(length = 11, name = "id")
	private int id;

	@Column(name = "hostNum", nullable = false)
	private String hostNum;

	@Column(name = "friendNum", nullable = false)
	private String friendNum;

	@Column(name = "middle", nullable = false)
	private String middle;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getHostNum() {
		return hostNum;
	}

	public void setHostNum(String hostNum) {
		this.hostNum = hostNum;
	}

	public String getFriendNum() {
		return friendNum;
	}

	public void setFriendNum(String friendNum) {
		this.friendNum = friendNum;
	}

	public String getMiddle() {
		return middle;
	}

	public void setMiddle(String middle) {
		this.middle = middle;
	}

}
