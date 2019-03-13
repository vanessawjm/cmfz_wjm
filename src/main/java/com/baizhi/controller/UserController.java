package com.baizhi.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;

import com.baizhi.entity.User;
import com.baizhi.service.UserService;
@RestController
@RequestMapping("/user")
public class UserController{
	@Autowired
	private UserService userService;
	
	@RequestMapping("/queryUsers.do")
	public Map<String,Object> queryUsers(Integer page,Integer rows){
		HashMap<String,Object> map = new HashMap<String,Object>();
		map.put("title", userService.count());
		map.put("rows", userService.queryAllUser(page, rows));
		return map;
	}
	
	@RequestMapping("/echars.do")
	public Object echars(){
		Map<String, Object> map = userService.queryCountByMaleOrFemale();
		return map;
	}
	
	
	@RequestMapping("/male.do")
	public Object male(){
		return userService.queryMale();
	}
	
	@RequestMapping("/female.do")
	public Object female(){
		return userService.queryFemale();
	}
	
	
	
	@RequestMapping("/download.do")
	public void download(HttpServletRequest request,HttpServletResponse response) throws Exception{
		List<User> users = userService.selectUser();
		Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams("用户信息","用户"), 
				User.class, users);
		workbook.write(new FileOutputStream(new File("C:\\software\\tomcat8\\apache-tomcat-8.5.38\\webapps\\cmfz_wjm\\upFile\\user.xls")));
		workbook.close();
		
		String name = "user.xls";
		//获取文件路径
		String realPath = request.getSession().getServletContext().getRealPath("/upFile");
		//获取文件
		File file = new File(realPath,name);
		//根据文件后缀设置响应类型
		String substring = name.substring(name.lastIndexOf("."));
		response.setContentType(request.getSession().getServletContext().getMimeType(substring));
		//设置响应头
		response.setHeader("Content-disposition", "attachment;filename="+URLEncoder.encode(name, "utf-8"));
		//响应
		FileInputStream inputStream = new FileInputStream(file);
				
		FileCopyUtils.copy(inputStream, response.getOutputStream());
	}
	
	
	
}
