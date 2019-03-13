package com.baizhi.service;

import com.baizhi.entity.Admin;

public interface AdminService {
	Admin login(String adminName, String password);
	
	void regist(Admin admin);

}
