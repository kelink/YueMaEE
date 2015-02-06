package com.gdufs.gd.dao;

import java.util.List;
import com.gdufs.gd.entity.YUser;
public interface YUserDao {
	public boolean addYUser(YUser user) throws Exception;
	public boolean updateYUser(YUser user)throws Exception;
	public boolean delteYUser(String uId)throws Exception;
	public YUser getYUserById(String uId)throws Exception;
	public List<YUser> getYUserList()throws Exception;
}