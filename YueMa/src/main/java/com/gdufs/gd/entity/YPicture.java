package com.gdufs.gd.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * 图片表
 * 
 * @author Administrator
 *
 */
@Entity
@Table(name = "YPicture")
public class YPicture implements Serializable {

	private static final long serialVersionUID = 1L;
	private int id;
	private Date uploaDate;
	private String url;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", length = 11, nullable = false)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "uploaDate", length = 30, nullable = false)
	@DateTimeFormat(pattern = "yyyy-mm-dd hh:mm:ss")
	public Date getUploaDate() {
		return uploaDate;
	}

	public void setUploaDate(Date uploaDate) {
		this.uploaDate = uploaDate;
	}

	@Column(name = "id", length = 250, nullable = false)
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
