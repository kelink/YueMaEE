package com.gdufs.gd.entity.back;

import javax.persistence.Column;

public class YActivityLabel {

	public YActivityLabel() {
		// TODO Auto-generated constructor stub
	}

	@Column(name = "activity_id", length = 11, nullable = false)
	private int activity_id;

	@Column(name = "label_id", length = 11, nullable = false)
	private int label_id;

	public int getActivity_id() {
		return activity_id;
	}

	public void setActivity_id(int activity_id) {
		this.activity_id = activity_id;
	}

	public int getLabel_id() {
		return label_id;
	}

	public void setLabel_id(int label_id) {
		this.label_id = label_id;
	}

	@Override
	public String toString() {
		return "YActivityLabel [activity_id=" + activity_id + ", label_id="
				+ label_id + "]";
	}

}
