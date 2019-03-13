package com.baizhi.dao;

import java.util.List;



import com.baizhi.entity.Meun;

public interface MeunDao extends BaseDao<Meun> {
	List<Meun> queryMeuns();
}
