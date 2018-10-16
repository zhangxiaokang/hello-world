package com.hf.shjw_globalconfig.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hf.shjw_globalconfig.dao.ConfigureDao;
import com.hf.shjw_globalconfig.model.Configure;
@Service("ConfigureService")
public class ConfigureServiceImpl implements ConfigureService{
	@Resource
	private ConfigureDao configureDao;
	public int insert(Configure record){
		return configureDao.insert(record);
	}

	public int update(Configure record){
		return configureDao.update(record);
	}

	public int delete(Configure record){
		return configureDao.delete(record);
	}

	public List<Configure> select(){
		return configureDao.select();
	}

	public String selectByPrimaryKey(String type) {
		return configureDao.selectByPrimaryKey(type);
	}

}
