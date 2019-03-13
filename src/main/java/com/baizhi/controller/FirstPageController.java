package com.baizhi.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baizhi.service.FirstPageService;

@RestController
@RequestMapping("/First_page")
public class FirstPageController {
	@Autowired
	private FirstPageService firstPageService;
	
	@RequestMapping("/first_page.do")
	public Map<String,Object> firstPage(String uid,String type,String sub_type){
		Map<String, Object> map = firstPageService.firstPage(uid, type, sub_type);
		return map;
	}
}
