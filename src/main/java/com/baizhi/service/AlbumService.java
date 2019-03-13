package com.baizhi.service;

import java.util.List;

import com.baizhi.entity.Album;

public interface AlbumService {
	public List<Album> queryAll();
	
	public void insertAlbum(Album album);
}
