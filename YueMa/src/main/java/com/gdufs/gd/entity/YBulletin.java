package com.gdufs.gd.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.Type;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * 系统公告表
 * 
 * @author Administrator
 *
 */
@Entity
@Table(name = "YBulletin")
public class YBulletin implements Serializable {
	private static final long serialVersionUID = 1L;

	public YBulletin() {
	}

	private Set<YBulletinUser> YBulletinUser;
	private int id;
	private int userType;
	private String title;
	private String content;
	private Date createTime;
	private int isCancle;
	private Date cancelTime;
	private int isDelete;
	private Date deleteTime;

	@OneToMany(mappedBy = "bulletin")
	public Set<YBulletinUser> getYBulletinUser() {
		return YBulletinUser;
	}

	public void setYBulletinUser(Set<YBulletinUser> yBulletinUser) {
		YBulletinUser = yBulletinUser;
	}

	private int priority;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", length = 11, nullable = false)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "userType", length = 11, nullable = false)
	public int getUserType() {
		return userType;
	}

	public void setUserType(int userType) {
		this.userType = userType;
	}

	@Column(name = "title", length = 50, nullable = false)
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Type(type = "text")
	@Column(name = "content", nullable = false)
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Column(name = "createTime", length = 30, nullable = false)
	@DateTimeFormat(pattern = "yyyy-mm-dd hh:mm:ss")
	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Column(name = "isCancle", length = 11, nullable = false)
	public int getIsCancle() {
		return isCancle;
	}

	public void setIsCancle(int isCancle) {
		this.isCancle = isCancle;
	}

	@Column(name = "cancelTime", nullable = false)
	@DateTimeFormat(pattern = "yyyy-mm-dd hh:mm:ss")
	public Date getCancelTime() {
		return cancelTime;
	}

	public void setCancelTime(Date cancelTime) {
		this.cancelTime = cancelTime;
	}

	@Column(name = "isDelete", length = 11, nullable = false)
	public int getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(int isDelete) {
		this.isDelete = isDelete;
	}

	@Column(name = "deleteTime", nullable = false)
	@DateTimeFormat(pattern = "yyyy-mm-dd hh:mm:ss")
	public Date getDeleteTime() {
		return deleteTime;
	}

	public void setDeleteTime(Date deleteTime) {
		this.deleteTime = deleteTime;
	}

	@Column(name = "priority", length = 11, nullable = false)
	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
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
		YBulletin other = (YBulletin) obj;
		if (id != other.id)
			return false;
		return true;
	}

}
