package com.gdufs.gd.entity.back;
//package com.gdufs.gd.entity2;
//
//import java.io.Serializable;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
//import javax.persistence.Table;
//
//import org.hibernate.annotations.GenericGenerator;
//
//import com.gdufs.gd.entity.YUser;
//
///**
// * Phone-Number entity
// * @author Administrator
// *
// */
//@Entity
//@Table(name = "YPNum")
//public class YPNum implements Serializable {
//	private static final long serialVersionUID = 8176377380125264910L;
//
//	public YPNum() {}
//	
//	@Id
//	@GeneratedValue(generator = "system-uuid")
//	@GenericGenerator(name = "system-uuid", strategy = "uuid.hex")
//	@Column(name = "pId", unique = true, nullable = false, length = 50)
//	private String pId;
//	
//	@ManyToOne(targetEntity=YUser.class)
//	@JoinColumn(name="uId")
//	private String uId;
//	
//	@Column(name="userPNum",length=20,nullable=false)
//	private String userPNum;
//	
//	@Column(name="friendPNum",length=20,nullable=false)
//	private String friendPNum;
//
//	public String getpId() {
//		return pId;
//	}
//
//	public void setpId(String pId) {
//		this.pId = pId;
//	}
//
//	public String getuId() {
//		return uId;
//	}
//
//	public void setuId(String uId) {
//		this.uId = uId;
//	}
//
//	public String getUserPNum() {
//		return userPNum;
//	}
//
//	public void setUserPNum(String userPNum) {
//		this.userPNum = userPNum;
//	}
//
//	public String getFriendPNum() {
//		return friendPNum;
//	}
//
//	public void setFriendPNum(String friendPNum) {
//		this.friendPNum = friendPNum;
//	}
//
//	@Override
//	public String toString() {
//		return "YPNum [pId=" + pId + ", uId=" + uId + ", userPNum=" + userPNum
//				+ ", friendPNum=" + friendPNum + "]";
//	}
//	
// }
