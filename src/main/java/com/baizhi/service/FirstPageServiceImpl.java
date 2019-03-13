package com.baizhi.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.baizhi.dao.AlbumDao;
import com.baizhi.dao.ArticleDao;
import com.baizhi.dao.BannerDao;
import com.baizhi.dao.UserDao;
import com.baizhi.entity.Album;
import com.baizhi.entity.Article;
import com.baizhi.entity.Banner;
import com.baizhi.entity.User;
@Service
@Transactional(propagation=Propagation.SUPPORTS)
public class FirstPageServiceImpl implements FirstPageService{
	@Autowired
	private BannerDao bannerDao;
	@Autowired
	private UserDao userDao;
	@Autowired
	private AlbumDao albumDao;
	@Autowired
	private ArticleDao articleDao;
	
	@Override
	public Map<String, Object> firstPage(String uid, String type,
			String sub_type) {
		Map<String,Object> map = new HashMap<String,Object>();
		User user = userDao.queryItem(uid);
		if(user!=null){
			if("all".equals(type)){
				List<Banner> list = bannerDao.selectAll();
				List<Album> list2 = albumDao.selectAll();
				List<Article> list3 = articleDao.selectAll();
				map.put("header", list);
				map.put("album", list2);
				map.put("article", list3);
				return map;
			}else if("wen".equals(type)){
				
			}else if("si".equals(type)){
				
			}
		}else{
			//throw new RuntimeException("用户不存在");
			return null;
		}
		return null;
		
	}

	


}
