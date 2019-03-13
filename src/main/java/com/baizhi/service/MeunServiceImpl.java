package com.baizhi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baizhi.dao.MeunDao;
import com.baizhi.entity.Meun;

@Service
public class MeunServiceImpl implements MeunService{
	@Autowired
	private MeunDao meunDao;
	
	//菜单显示
	@Override
	public List<Meun> queryMeun() {
		return meunDao.queryMeuns();
	}
	
}
