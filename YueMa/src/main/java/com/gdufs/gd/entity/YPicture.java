package com.gdufs.gd.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "YPicture")
public class YPicture implements Serializable {
	private static final long serialVersionUID = -560064900861907221L;

	public YPicture() {
		super();
	}

	// 多对一，@JoinColumn与@column类似，指定映射的数据库字段
	// @ManyToOne(targetEntity = YActivity.class)
	// @JoinColumn(name = "activity_Id", updatable = false)
	private YActivity activity;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", length = 11)
	private int id;

	@Column(name = "url", length = 200, nullable = false)
	private String url;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public YActivity getActivity() {
		return activity;
	}

	public void setActivity(YActivity activity) {
		this.activity = activity;
	}

	@Override
	public String toString() {
		return "YPicture [id=" + id + ", url=" + url + "]";
	}

}
