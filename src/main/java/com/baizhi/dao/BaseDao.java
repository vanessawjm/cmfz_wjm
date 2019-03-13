package com.baizhi.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface BaseDao<T> {
	void insertItem(T t);
	void updateItem(T t);
	T queryItem(String id);
	List<T> queryAll(@Param("begin") Integer begin, @Param("rows") Integer rows);
	List<T> selectAll();
	Integer queryCount();
	void removeItem(String id);
}
