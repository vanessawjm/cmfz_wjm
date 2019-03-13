package com.baizhi.controller;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.baizhi.entity.Admin;
import com.baizhi.service.AdminService;
import com.baizhi.util.ImageUtil;

@Controller
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	private AdminService adminService;
	
	@RequestMapping("/login.do")
	@ResponseBody
	private String login(Admin admin,HttpSession session,String clientCode){
		String code = (String)session.getAttribute("code");
		if(code.equalsIgnoreCase(clientCode)){
			Admin login = null;
			try {
				login = adminService.login(admin.getAdminName(), admin.getPassword());
				session.setAttribute("login", login);
				return "ok";
			} catch (Exception e) {
				String message = e.getMessage();
				return message;
			}
		}else{
			return "generateCaptcha is error";
		}
		
	}
	
	@RequestMapping("/generateCaptcha.do")
	private void generateCaptcha(HttpServletResponse response,HttpSession session) throws IOException{
		//生成验证码随机数
		String code = ImageUtil.getCode();
		//将随机数存入session中
		session.setAttribute("code", code);
		//获取验证码图片
		BufferedImage image = ImageUtil.createImage(code);
		//使用io流响应到客户端
		ServletOutputStream out = response.getOutputStream();
		ImageIO.write(image, "png", out);
	}
	
	
	@RequestMapping("/regist.do")
	@ResponseBody
	public String regist(Admin admin,HttpSession session,String clientCode){
		String code = (String)session.getAttribute("code");
		if(code.equalsIgnoreCase(clientCode)){
			try {
				adminService.regist(admin);;
				session.setAttribute("login", admin);
				return "ok";
			} catch (Exception e) {
				String message = e.getMessage();
				return message;
			}
		}else{
			return "验证码错误！";
		}
	}
	
	
}


