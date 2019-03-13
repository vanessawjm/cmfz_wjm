package com.baizhi.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baizhi.entity.User;
import com.baizhi.entity.UserVo;

public interface UserDao extends BaseDao<User> {
	Integer queryCountByMaleOrFemale(@Param("months") Integer months, @Param("sex") String sex);
	
	List<UserVo> queryAddressByFemale();
	List<UserVo> queryAddressByMale();
	
	
	
	
}
