package com.baizhi.service;

import java.util.List;

import com.baizhi.entity.Banner;

public interface BannerService {
	//分页查询轮播图
	List<Banner> queryAllBanner(Integer page, Integer rows);
	//查询总总页数
	Integer queryCount();
	//删除一张轮播图同时删除数据库中的图片
	void removeImg(String id);
	//添加
	void addImg(Banner banner);
	//修改图片状态
	void updateStatus(Banner banner);
}	
