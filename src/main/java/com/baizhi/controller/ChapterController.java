package com.baizhi.controller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.baizhi.entity.Chapter;
import com.baizhi.service.ChapterService;
import com.baizhi.util.Mp3Util;

@RestController
@RequestMapping("/chapter")
public class ChapterController {
	@Autowired
	private ChapterService chapterService;
	
	
	@RequestMapping("/addChapter.do")
	public void addChapter(Chapter chapter,MultipartFile upFile,HttpSession session) throws Exception, IOException {
		System.out.println(chapter);
		//获取文件名
		String originalFilename = upFile.getOriginalFilename();
		//动态获取存放文件的文件路径
		String realPath = session.getServletContext().getRealPath("/upFile");
		//将文件存到文件夹中
		File file = new File(realPath+"\\"+originalFilename);
		upFile.transferTo(file);
		chapter.setUrl(originalFilename);
		//获取文件大小
		Long length = file.length();
		chapter.setSize(length);
		//获取文件时长
		String duration = Mp3Util.getDuration(file);
		chapter.setDuration(duration);
		
		chapterService.insertChapter(chapter);
		
	}
	
	
	@RequestMapping("/downFile.do")
	public void download(String name,HttpServletRequest request,HttpServletResponse response) throws Exception{
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
