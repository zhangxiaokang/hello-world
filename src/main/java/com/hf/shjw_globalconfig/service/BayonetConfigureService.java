package com.hf.shjw_globalconfig.service;

import java.util.List;

import com.hf.shjw_globalconfig.model.BayonetConfigure;

public interface BayonetConfigureService {
	int insert(BayonetConfigure record);

	int update(BayonetConfigure record);

	int delete(Integer id);

	List<BayonetConfigure> select();
}
