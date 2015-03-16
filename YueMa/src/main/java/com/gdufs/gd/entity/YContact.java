package com.gdufs.gd.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * Contact object
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

	@OneToOne
	@JoinColumn(name = "user_Id")
	private YUser user;

	@Column(name = "hostNum", length = 13, nullable = false)
	private String hostNum;

	@Column(name = "hostName", length = 20, nullable = false)
	private String hostName;

	@Column(name = "friendNum", length = 13, nullable = false)
	private String friendNum;

	@Column(name = "firendName", length = 20, nullable = false)
	private String firendName;

	@Column(name = "version", length = 11, nullable = false)
	private int version;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public YUser getUser() {
		return user;
	}

	public void setUser(YUser user) {
		this.user = user;
	}

	public String getHostNum() {
		return hostNum;
	}

	public void setHostNum(String hostNum) {
		this.hostNum = hostNum;
	}

	public String getHostName() {
		return hostName;
	}

	public void setHostName(String hostName) {
		this.hostName = hostName;
	}

	public String getFriendNum() {
		return friendNum;
	}

	public void setFriendNum(String friendNum) {
		this.friendNum = friendNum;
	}

	public String getFirendName() {
		return firendName;
	}

	public void setFirendName(String firendName) {
		this.firendName = firendName;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	@Override
	public String toString() {
		return "YContact [id=" + id + ", user=" + user + ", hostNum=" + hostNum
				+ ", hostName=" + hostName + ", friendNum=" + friendNum
				+ ", firendName=" + firendName + ", version=" + version + "]";
	}

}
