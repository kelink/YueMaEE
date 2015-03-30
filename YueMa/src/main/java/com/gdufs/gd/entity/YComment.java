package com.gdufs.gd.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.gdufs.gd.entity.BaseEntity;

/**
 * 活动评价表
 * 
 * @author Administrator
 *
 */
@Entity
@Table(name = "YComment")
public class YComment extends BaseEntity {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", length = 11, nullable = false)
	private int id;

	@Column(name = "content", length = 200, nullable = false)
	private String content;

	@Column(name = "creatorId", length = 11, nullable = false)
	private int creatorId;

	@Column(name = "createTime", length = 11, nullable = false)
	@DateTimeFormat(pattern = "yyyy-mm-dd hh:mm:ss")
	private Date createTime;

	@Column(name = "isDelete", length = 11, nullable = false)
	private int isDelete;

	@Column(name = "fatherCommentId", length = 11, nullable = false)
	private int fatherCommentId;

	@Column(name = "activityId", length = 11, nullable = false)
	private int activityId;

	@Column(name = "commentPath", length = 200, nullable = false)
	private String commentPath;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getCreatorId() {
		return creatorId;
	}

	public void setCreatorId(int creatorId) {
		this.creatorId = creatorId;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public int getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(int isDelete) {
		this.isDelete = isDelete;
	}

	public int getFatherCommentId() {
		return fatherCommentId;
	}

	public void setFatherCommentId(int fatherCommentId) {
		this.fatherCommentId = fatherCommentId;
	}

	public int getActivityId() {
		return activityId;
	}

	public void setActivityId(int activityId) {
		this.activityId = activityId;
	}

	public String getCommentPath() {
		return commentPath;
	}

	public void setCommentPath(String commentPath) {
		this.commentPath = commentPath;
	}

	@Override
	public String toString() {
		return "YComment [id=" + id + ", content=" + content + ", creatorId="
				+ creatorId + ", createTime=" + createTime + ", isDelete="
				+ isDelete + ", fatherCommentId=" + fatherCommentId
				+ ", activityId=" + activityId + ", commentPath=" + commentPath
				+ "]";
	}

}
