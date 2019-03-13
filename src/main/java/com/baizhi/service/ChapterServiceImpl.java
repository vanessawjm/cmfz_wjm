package com.baizhi.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.baizhi.dao.ChapterDao;
import com.baizhi.entity.Chapter;
@Service
@Transactional(propagation=Propagation.REQUIRED)
public class ChapterServiceImpl implements ChapterService {

	@Autowired
	private ChapterDao chapterDao;
	
	@Override
	public void insertChapter(Chapter chapter) {
		String id = UUID.randomUUID().toString();
		chapter.setId(id);
		chapterDao.insertItem(chapter);
	}

}
