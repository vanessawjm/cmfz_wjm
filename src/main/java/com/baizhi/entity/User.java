package com.baizhi.entity;

import java.io.Serializable;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable{
	@ExcelIgnore
	private String id;
	@ExcelIgnore
	private String photo;
	@Excel(name="法名")
	private String username;
	@Excel(name="真实姓名")
	private String realname;
	@Excel(name="性别")
	private String sex;
	@Excel(name="省")
	private String privoince;
	@Excel(name="市")
	private String city;
	@Excel(name="签名")
	private String sign;
	@Excel(name="手机号")
	private String phone;
	@ExcelIgnore
	private String password;
	@ExcelIgnore
	private String salt;
	@Excel(name="注册时间")
	private String createTime;
	@Excel(name="用户状态")
	private String status;

	
}
