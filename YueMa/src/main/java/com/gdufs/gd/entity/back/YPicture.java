package com.gdufs.gd.entity.back;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.gdufs.gd.entity.BaseEntity;

@Entity
@Table(name = "YPicture")
public class YPicture extends BaseEntity implements Serializable {
	private static final long serialVersionUID = -560064900861907221L;

	public YPicture() {
		super();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(length = 11, name = "id")
	private int id;

	@Column(name = "createTime", length = 50, nullable = false)
	@DateTimeFormat(pattern = "yyyy-mm-dd hh:mm:ss")
	private Date createTime;

	@Column(name = "url", length = 50, nullable = false)
	private String url;

	@Column(name = "creatorId", length = 50, nullable = false)
	private int creatorId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int getCreatorId() {
		return creatorId;
	}

	public void setCreatorId(int creatorId) {
		this.creatorId = creatorId;
	}

	@Override
	public String toString() {
		return "YPicture [id=" + id + ", createTime=" + createTime + ", url="
				+ url + ", creatorId=" + creatorId + "]";
	}

}
