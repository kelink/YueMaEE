package com.gdufs.gd.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "YActivityUser")
@IdClass(YActivityUserPK.class)
public class YActivityUser implements Serializable {

	private static final long serialVersionUID = 1L;
	private YActivity activity;
	private YUser user;
	private Date join_time;
	private int isTickOff;
	private int isAuth;

	@Id
	public YActivity getActivity() {
		return activity;
	}

	public void setActivity(YActivity activity) {
		this.activity = activity;
	}

	@Id
	public YUser getUser() {
		return user;
	}

	public void setUser(YUser user) {
		this.user = user;
	}

	@Column(name = "join_time", length = 50, nullable = false)
	@DateTimeFormat(pattern = "yyyy-mm-dd hh:mm:ss")
	public Date getJoin_time() {
		return join_time;
	}

	@Column(name = "join_time", length = 11, nullable = false)
	public void setJoin_time(Date join_time) {
		this.join_time = join_time;
	}

	@Column(name = "isTickOff", length = 11, nullable = false)
	public int getIsTickOff() {
		return isTickOff;
	}

	public void setIsTickOff(int isTickOff) {
		this.isTickOff = isTickOff;
	}

	public int getIsAuth() {
		return isAuth;
	}

	public void setIsAuth(int isAuth) {
		this.isAuth = isAuth;
	}

}