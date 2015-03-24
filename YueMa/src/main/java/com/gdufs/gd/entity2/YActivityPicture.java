package com.gdufs.gd.entity2;

import javax.persistence.Column;

import com.gdufs.gd.entity.BaseEntity;

public class YActivityPicture extends BaseEntity {

	private static final long serialVersionUID = 1L;

	public YActivityPicture() {
	}

	@Column(name = "activity_id", length = 11, nullable = false)
	private int activity_id;

	@Column(name = "picture_id", length = 11, nullable = false)
	private int picture_id;

	public int getActivity_id() {
		return activity_id;
	}

	public void setActivity_id(int activity_id) {
		this.activity_id = activity_id;
	}

	public int getPicture_id() {
		return picture_id;
	}

	public void setPicture_id(int picture_id) {
		this.picture_id = picture_id;
	}

	@Override
	public String toString() {
		return "YActivityPicture [activity_id=" + activity_id + ", picture_id="
				+ picture_id + "]";
	}

}
