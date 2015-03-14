package com.gdufs.gd.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * Contact object 
 * @author Administrator
 *
 */
@Entity
@Table(name = "YContactObj")
public class YContactObj {

	public YContactObj() {
		// TODO Auto-generated constructor stub
	}
	
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid.hex")
	@Column(name = "uId", unique = true, nullable = false, length = 50)
	private String uId;
	
	@Column(name="hostNum",length=13,nullable=false)
	private String hostNum;
	
	@Column(name="hostName",length=20,nullable=false)
	private String hostName;
	
	@Column(name="friendNum",length=13,nullable=false)
	private String friendNum;
	
	@Column(name="firendName",length=20,nullable=false)
	private String firendName;
	
	@Column(name="version",length=11,nullable=false)
	private int version;

}
