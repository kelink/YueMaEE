package com.gdufs.gd.entity2;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.Type;
import org.springframework.format.annotation.DateTimeFormat;

public class YRemind {

	public YRemind() {
		// TODO Auto-generated constructor stub
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", length = 11, nullable = false)
	private int id;

	@Column(name = "type", length = 11, nullable = false)
	private int type;

	@Column(name = "creatorId", length = 11, nullable = false)
	private int creatorId;

	@Type(type = "text")
	@Column(name = "content", nullable = false)
	private String content;

	@Column(name = "createTime", length = 11, nullable = false)
	@DateTimeFormat(pattern = "yyyy-mm-dd hh:mm:ss")
	private Date createTime;
}
