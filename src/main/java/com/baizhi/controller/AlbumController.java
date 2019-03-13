package com.baizhi.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.baizhi.entity.Album;
import com.baizhi.service.AlbumService;

@RestController
@RequestMapping("/Album")
public class AlbumController {
	@Autowired
	private AlbumService albumService;

	@RequestMapping("/queryAll.do")
	public List<Album> queryAll(){
		List<Album> albums = albumService.queryAll();
		return albums;
	}
	
	@RequestMapping("/insertAlbum.do")
	public void insertAlbum(Album album,MultipartFile upImg,HttpSession session) throws Exception, IOException{
		//封面照片
		//获取上传文件的名称
		String originalFilename = upImg.getOriginalFilename();
		//动态获取保存文件的路径
		String realPath = session.getServletContext().getRealPath("/img/upload");
		//将文件保存到服务器上
		upImg.transferTo(new File(realPath+"\\"+originalFilename));
		album.setCoverImg(originalFilename);
		albumService.insertAlbum(album);
	}
}
