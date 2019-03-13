package com.baizhi.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.baizhi.dao.UserDao;
import com.baizhi.entity.User;
import com.baizhi.entity.UserVo;
@Service
@Transactional(propagation=Propagation.SUPPORTS)
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	@Override
	public List<User> queryAllUser(Integer page, Integer rows) {
		Integer begin = (page-1)*rows;
		return userDao.queryAll(begin, rows);
	}

	@Override
	public Integer count() {
		return userDao.queryCount();
	}

	@Override
	public Map<String, Object> queryCountByMaleOrFemale() {
		
		
		HashMap<String, Object> map = new HashMap<String,Object>();
		ArrayList<String> list = new ArrayList<String>();
		ArrayList<Integer> list1 = new ArrayList<Integer>();
		ArrayList<Integer> list2 = new ArrayList<Integer>();
		for (int i = 0; i < 12; i++) {
		    list.add(i+1+"月");
		    list1.add(userDao.queryCountByMaleOrFemale(i+1, "男"));
		    list2.add(userDao.queryCountByMaleOrFemale(i+1,"女"));
		}
		map.put("months", list);
		map.put("man", list1);
		map.put("woman", list2);
		
		return map;
	}

	@Override
	public List<UserVo> queryMale() {
		List<UserVo> male = userDao.queryAddressByMale();
		
		return male;
	}

	@Override
	public List<UserVo> queryFemale() {
		List<UserVo> female = userDao.queryAddressByFemale();
		return female;
	}

	@Override
	public List<User> selectUser() {
		List<User> users = userDao.selectAll();
		return users;
	}

	

	
}
