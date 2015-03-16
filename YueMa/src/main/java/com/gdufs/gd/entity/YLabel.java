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
@Table(name = "YLabel")
public class YLabel implements Serializable {

	private static final long serialVersionUID = -5623432428498766037L;

	public YLabel() {
	}

	// // 多对一，@JoinColumn与@column类似，指定映射的数据库字段
	// @ManyToOne(targetEntity = YActivity.class)
	// @JoinColumn(name = "activity_label_Id", updatable = false)
	private YActivity activity;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(length = 11)
	private int id;

	@Column(name = "content", length = 50, nullable = false)
	private String content;

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

	@Override
	public String toString() {
		return "Ylabel [id=" + id + ", content=" + content + "]";
	}

}
