package com.baizhi.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baizhi.entity.Meun;
import com.baizhi.service.MeunService;

@Controller
@RequestMapping("/Meun")
public class MeunController {
	@Autowired 
	private MeunService meunService;
	
	@RequestMapping("/queryMeun.do")
	@ResponseBody
	public List<Meun> queryMeun(){
		List<Meun> meuns = meunService.queryMeun();
		return meuns;
	}
}
