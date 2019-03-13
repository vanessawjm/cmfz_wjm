package com.baizhi.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.baizhi.dao.AlbumDao;
import com.baizhi.entity.Album;
@Service
@Transactional(propagation=Propagation.REQUIRED)
public class AlbumServiceImpl implements AlbumService{

	@Autowired
	private AlbumDao albumDao;
	
	@Override
	@Transactional(propagation=Propagation.SUPPORTS)
	public List<Album> queryAll() {
		return albumDao.selectAll();
	}

	@Override
	public void insertAlbum(Album album) {
		String id = UUID.randomUUID().toString();
		album.setId(id);
		albumDao.insertItem(album);
	}

}
