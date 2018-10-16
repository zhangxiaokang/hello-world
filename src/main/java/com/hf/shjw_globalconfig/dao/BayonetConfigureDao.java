package com.hf.shjw_globalconfig.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hf.shjw_globalconfig.model.BayonetConfigure;

public interface BayonetConfigureDao {
	int insert(BayonetConfigure record);

	int update(BayonetConfigure record);

	int delete(Integer id);

	List<BayonetConfigure> select();
	public void addEmps(@Param("emps")List<BayonetConfigure> emps);
}
