package com.baizhi.service;

import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.baizhi.dao.AdminDao;
import com.baizhi.entity.Admin;

@Service
@Transactional(propagation=Propagation.SUPPORTS)
public class AdminServiceImpl implements AdminService {
	@Autowired
	private AdminDao adminDao;

	@Override
	public Admin login(String adminName, String password) {
		Admin admin = adminDao.queryAdminByAdminName(adminName);
		if(admin != null){
			if(admin.getPassword().equals(password)){
				return admin;
			}else{
				throw new RuntimeException("password is error");
			}
		}else{
			throw new RuntimeException("admin is not exist");
		}
	}

	@Override
	public void regist(Admin admin) {
		Admin admin1 = adminDao.queryAdminByAdminName(admin.getAdminName());
		if(admin1==null){
			String id = UUID.randomUUID().toString();
			admin.setId(id);
			adminDao.insertItem(admin);
		}else{
			throw new RuntimeException("admin is existed");
		}
	}

}
