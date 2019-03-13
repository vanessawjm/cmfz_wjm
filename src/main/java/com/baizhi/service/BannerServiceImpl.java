package com.baizhi.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.baizhi.dao.BannerDao;
import com.baizhi.entity.Banner;
@Service
@Transactional(propagation=Propagation.SUPPORTS)
public class BannerServiceImpl implements BannerService{
	@Autowired
	private BannerDao bannerDao;
	
	@Override
	public List<Banner> queryAllBanner(Integer page,Integer rows) {
		Integer begin = (page-1)*rows;
		return bannerDao.queryAll(begin,rows);
	}

	@Override
	public Integer queryCount() {
		return bannerDao.queryCount();
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void removeImg(String id) {
		bannerDao.removeItem(id);
	
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void addImg(Banner banner) {
		String str = UUID.randomUUID().toString();
		banner.setId(str);
		//默认是1，表示轮播
		banner.setStatus(1);
		bannerDao.insertItem(banner);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void updateStatus(Banner banner) {
		bannerDao.updateItem(banner);
	}
	
}	
