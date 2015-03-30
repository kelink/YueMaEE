package com.gdufs.gd.entity.back;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.Type;
import org.springframework.format.annotation.DateTimeFormat;

public class YBulletin {

	public YBulletin() {
		// TODO Auto-generated constructor stub
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", length = 11, nullable = false)
	private int id;

	@Column(name = "userType", length = 11, nullable = false)
	private int userType;

	@Column(name = "title", length = 50, nullable = false)
	private String title;

	@Type(type = "text")
	@Column(name = "content", nullable = false)
	private String content;

	@Column(name = "createTime", length = 11, nullable = false)
	@DateTimeFormat(pattern = "yyyy-mm-dd hh:mm:ss")
	private Date createTime;

	@Column(name = "isCancle", length = 11, nullable = false)
	private int isCancle;

	@Column(name = "cancelTime", nullable = false)
	@DateTimeFormat(pattern = "yyyy-mm-dd hh:mm:ss")
	private Date cancelTime;

	@Column(name = "isDelete", length = 11, nullable = false)
	private int isDelete;

	@Column(name = "deleteTime", nullable = false)
	@DateTimeFormat(pattern = "yyyy-mm-dd hh:mm:ss")
	private Date deleteTime;

	@Column(name = "priority", length = 11, nullable = false)
	private int priority;

}
