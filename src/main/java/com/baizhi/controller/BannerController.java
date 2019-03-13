package com.baizhi.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.baizhi.entity.Banner;
import com.baizhi.service.BannerService;

@Controller
@RequestMapping("/Banner")
public class BannerController {
	@Autowired
	private BannerService bannerService;
	
	@RequestMapping("/queryAllBanner.do")
	@ResponseBody
	public Map<String,Object> queryAllBanner(Integer page,Integer rows){
		Map<String,Object> map = new HashMap<String,Object>();
		Integer count = bannerService.queryCount();
		List<Banner> banners = bannerService.queryAllBanner(page,rows);
		//存入信息的总条数
		map.put("rows", banners);
		//存入数据集合
		map.put("total", count);
		return map;
	}
	
	@RequestMapping("/remove.do")
	@ResponseBody
	public void removeBanner(String id){
		bannerService.removeImg(id);
	}
	
	@RequestMapping("/add.do")
	@ResponseBody
	public void addBanner(@RequestParam(value = "upload", required = false)MultipartFile upload,Banner banner,HttpSession session) throws IllegalStateException, IOException, Exception{
		//获取上传文件名称
		String originalFileName = upload.getOriginalFilename();
		//获取上传文件类型
		//String contentType = upload.getContentType();
		//动态获取保存的文件路径
		String realPath = session.getServletContext().getRealPath("/img/upload");
		//保存上传文件的地址
		upload.transferTo(new File(realPath+"\\"+originalFileName));
		//保存到数据库中的名字
		banner.setImgPath(originalFileName);
		bannerService.addImg(banner);
	}
	
	@RequestMapping("/update.do")
	@ResponseBody
	public void updateStatus(String id,Integer status){
		Banner banner = new Banner();
		banner.setId(id);
		banner.setStatus(status);
		bannerService.updateStatus(banner);
	}
	
}
