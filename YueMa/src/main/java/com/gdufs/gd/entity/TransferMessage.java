package com.gdufs.gd.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 用于返回数据给客户端
 * 
 * @author Administrator
 *
 */
public class TransferMessage extends BaseEntity implements Serializable {
	private static final long serialVersionUID = 7814300739991315981L;

	public TransferMessage() {
		super();
	}

	private int code;
	private Date createTime;
	private Date expire;
	private String message;
	private Map<?, ?> resultMap;

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getExpire() {
		return expire;
	}

	public void setExpire(Date expire) {
		this.expire = expire;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Map<?, ?> getResultMap() {
		return resultMap;
	}

	public void setResultMap(Map<?, ?> resultMap) {
		this.resultMap = resultMap;
	}

	@Override
	public String toString() {
		return "TransferMessage [code=" + code + ", createTime=" + createTime
				+ ", expire=" + expire + ", message=" + message
				+ ", resultMap=" + resultMap + "]";
	}

}
