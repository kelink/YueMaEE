package com.gdufs.gd.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "YActivityJoiner")
public class YActivityJoiner implements Serializable {

	private static final long serialVersionUID = 1456963955081474938L;

	public YActivityJoiner() {
		super();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", length = 11)
	private int id;

	@OneToOne
	@JoinColumn(name = "joiner_Id")
	private YUser user;

	@OneToOne
	@JoinColumn(name = "joiner_activity_Id")
	private YActivity activity;

	@Column(name = "joinTime", length = 50, nullable = false)
	@DateTimeFormat(pattern = "yyyy-mm-dd hh:mm:ss")
	private Date joinTime;

	@Column(name = "joinMessage", length = 100, nullable = false)
	@DateTimeFormat(pattern = "yyyy-mm-dd hh:mm:ss")
	private String joinMessage;

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

	public YActivity getActivity() {
		return activity;
	}

	public void setActivity(YActivity activity) {
		this.activity = activity;
	}

	public Date getJoinTime() {
		return joinTime;
	}

	public void setJoinTime(Date joinTime) {
		this.joinTime = joinTime;
	}

	public String getJoinMessage() {
		return joinMessage;
	}

	public void setJoinMessage(String joinMessage) {
		this.joinMessage = joinMessage;
	}

	@Override
	public String toString() {
		return "YActivityJoiner [id=" + id + ", user=" + user + ", activity="
				+ activity + ", joinTime=" + joinTime + ", joinMessage="
				+ joinMessage + "]";
	}

}
