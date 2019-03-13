package com.baizhi.service;

import java.util.List;
import java.util.Map;

import com.baizhi.entity.User;
import com.baizhi.entity.UserVo;

public interface UserService {
	List<User> queryAllUser(Integer page, Integer rows);
	Integer count();
	
	Map<String,Object> queryCountByMaleOrFemale();
	
	//查询男
	List<UserVo> queryMale();
	
	//查询女
	List<UserVo> queryFemale();
	
	List<User> selectUser();

}
