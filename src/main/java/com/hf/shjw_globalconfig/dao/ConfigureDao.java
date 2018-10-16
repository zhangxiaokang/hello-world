package com.hf.shjw_globalconfig.dao;

import java.util.List;

import com.hf.shjw_globalconfig.model.Configure;

public interface ConfigureDao {
	int insert(Configure record);

	int update(Configure record);

	int delete(Configure record);

	List<Configure> select();
	String selectByPrimaryKey(String type);
}
