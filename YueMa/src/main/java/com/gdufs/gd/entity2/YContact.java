package com.gdufs.gd.entity2;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Contact object
 * 
 * @author Administrator
 *
 */
@Entity
@Table(name = "YContact")
public class YContact {

	public YContact() {
		// TODO Auto-generated constructor stub
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", length = 11)
	private int id;

	@Column(name = "user_id", length = 13, nullable = false)
	private int user_id;

	@Column(name = "hostNum", length = 13, nullable = false)
	private String hostNum;

	@Column(name = "hostName", length = 20, nullable = false)
	private String hostName;

	@Column(name = "friendNum", length = 13, nullable = false)
	private String friendNum;

	@Column(name = "firendName", length = 20, nullable = false)
	private String firendName;

	@Column(name = "version", length = 11, nullable = false)
	private int version;

}
