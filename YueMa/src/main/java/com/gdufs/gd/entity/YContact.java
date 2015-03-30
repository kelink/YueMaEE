package com.gdufs.gd.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 用户联系表，也是一度人脉表
 * 
 * @author Administrator
 *
 */
@Entity
@Table(name = "YContact")
public class YContact {

	public YContact() {
		// TODO Auto-generated constructor stub
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", length = 11)
	private int id;

	@Column(name = "hostNum", length = 20, nullable = false)
	private String hostNum;

	@Column(name = "friendNum", length = 20, nullable = false)
	private String friendNum;

	@Column(name = "version", length = 11, nullable = false)
	private int version;

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

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

}
