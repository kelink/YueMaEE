package com.gdufs.gd.entity.back;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * 公告-用户类
 * 
 * @author Administrator
 *
 */
public class YBulletinUser {

	public YBulletinUser() {
		// TODO Auto-generated constructor stub
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", length = 11, nullable = false)
	private int id;

	@Column(name = "userId", length = 11, nullable = false)
	private int userId;

	@Column(name = "isRead", length = 11, nullable = false)
	private int isRead;

	@Column(name = "readTime", length = 11, nullable = false)
	@DateTimeFormat(pattern = "yyyy-mm-dd hh:mm:ss")
	private Date readTime;
}
