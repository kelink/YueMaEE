package com.gdufs.gd.entity;
/**
 * Relation between Users
 * @author Administrator
 *
 */
public class YRelation {

	public YRelation() {}
	
	private String uId;
	
	private String fId;
	/**
	 * 陌生人:0
	 * 朋友:1
	 * 朋友的朋友: 2
	 * 
	 */
	private int relaType;
	
	/**
	 * 关系来自contacts:1
	 * 关系来自关注：2
	 */
	
	private int fromType;

}
