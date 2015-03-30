package com.gdufs.gd.entity.back;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * 用户之间的信息类
 * 
 * @author Administrator
 *
 */
public class YMessage {

	public YMessage() {
		// TODO Auto-generated constructor stub
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(length = 11, name = "id")
	private int id;

	@Column(name = "creatorId", length = 11, nullable = false)
	private int creatorId;

	@Column(name = "content", length = 10, nullable = false)
	private String content;

	@Column(name = "createTime", length = 50, nullable = false)
	@DateTimeFormat(pattern = "yyyy-mm-dd hh:mm:ss")
	private Date createTime;

	@Column(name = "type", length = 11, nullable = false)
	private int type;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCreatorId() {
		return creatorId;
	}

	public void setCreatorId(int creatorId) {
		this.creatorId = creatorId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "YMessage [id=" + id + ", creatorId=" + creatorId + ", content="
				+ content + ", createTime=" + createTime + ", type=" + type
				+ "]";
	}

}
