//package com.gdufs.gd.entity2;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.EnumType;
//import javax.persistence.Enumerated;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.OneToOne;
//import javax.persistence.Table;
//
//import com.gdufs.gd.common.CRelation;
//import com.gdufs.gd.entity.YUser;
//
///**
// * Relation between Users
// * 
// * @author Administrator
// *
// */
//@Entity
//@Table(name = "YRelation")
//public class YRelation {
//
//	public YRelation() {
//	}
//
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@Column(length = 11, name = "id")
//	private int id;
//
//	@OneToOne
//	@JoinColumn(name = "user_id")
//	private YUser hostUser;
//
//	@Column(name = "friend_id", nullable = true, columnDefinition = "INT default 0")
//	private int friendUser;
//
//	@Column(name = "friendNum", nullable = false)
//	private String friendNum;
//
//	@Enumerated(EnumType.STRING)
//	@Column(name = "relaType", nullable = true, columnDefinition = "INT default 0")
//	private CRelation.FriendRelation relaType;
//
//	@Enumerated(EnumType.STRING)
//	@Column(name = "fromType", nullable = true, columnDefinition = "INT default 0")
//	private CRelation.RelationFrom fromType;
//
// }
