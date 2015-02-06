package com.gdufs.gd.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * User Entity
 * @author Administrator
 *
 */
@Entity
@Table(name = "YUser")
public class YUser implements Serializable{
	private static final long serialVersionUID = 4946128427171569052L;

	public YUser() {}
	
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid.hex")
	@Column(name = "uId", unique = true, nullable = false, length = 50)
	private String uId;
	
	@Column(name="nickName",length=20,nullable=false)
	private String nickName;
	
	@Column(length=13,nullable=false)	
	private String phoneNumber;
	
	@Column(length=100,nullable=false)
	private String password;
	
	@Column(length=50,nullable=false)	
	private String facePath;
	
	@Column(length=20,nullable=false)
	private String introduce;
	
	@Column(length=50,nullable=false)
	@DateTimeFormat(pattern="yyyy-mm-dd hh:mm:ss")
	private Date createTime;
	
	@Column(length=50,nullable=false)
	@DateTimeFormat(pattern="yyyy-mm-dd hh:mm:ss")
	private Date lastLoginTimeDate;
	
	@Column(length=50,nullable=false)
	private String lastLoginMac;
	
	public String getuId() {
		return uId;
	}
	public void setuId(String uId) {
		this.uId = uId;
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
	public String getLastLoginMac() {
		return lastLoginMac;
	}
	public void setLastLoginMac(String lastLoginMac) {
		this.lastLoginMac = lastLoginMac;
	}
	@Override
	public String toString() {
		return "User [uId=" + uId + ", nickName=" + nickName + ", phoneNumber="
				+ phoneNumber + ", password=" + password + ", facePath="
				+ facePath + ", introduce=" + introduce + ", createTime="
				+ createTime + ", lastLoginTimeDate=" + lastLoginTimeDate
				+ ", lastLoginMac=" + lastLoginMac + "]";
	}
	
	
	
}
