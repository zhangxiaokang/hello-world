package com.hf.shjw_globalconfig.service;

import java.util.List;

import com.hf.shjw_globalconfig.model.TimeConfigure;

public interface TimeConfigureService {
	int insert(TimeConfigure record);

	int update(TimeConfigure record);

	int delete(Integer id);

	List<TimeConfigure> select();
	TimeConfigure selectById(Integer id);
}
