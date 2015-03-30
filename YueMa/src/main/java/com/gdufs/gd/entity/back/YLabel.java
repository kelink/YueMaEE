package com.gdufs.gd.entity.back;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.gdufs.gd.entity.BaseEntity;

@Entity
@Table(name = "YLabel")
public class YLabel extends BaseEntity {

	private static final long serialVersionUID = 1L;

	public YLabel() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(length = 11, name = "id")
	private int id;

	@Column(name = "creatorId", length = 11, nullable = false)
	private int creatorId;

	@Column(name = "content", length = 10, nullable = false)
	private String content;

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

	@Override
	public String toString() {
		return "YLabel [id=" + id + ", creatorId=" + creatorId + ", content="
				+ content + "]";
	}

}
