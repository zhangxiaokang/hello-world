package com.hf.shjw_globalconfig.service;

import java.util.List;

import com.hf.shjw_globalconfig.model.Configure;

public interface ConfigureService {
	int insert(Configure record);

	int update(Configure record);

	int delete(Configure record);

	List<Configure> select();
	String selectByPrimaryKey(String type);
}
