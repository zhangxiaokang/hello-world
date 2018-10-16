package com.hf.shjw_globalconfig.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hf.shjw_globalconfig.dao.TimeConfigureDao;
import com.hf.shjw_globalconfig.model.TimeConfigure;

@Service("TimeConfigureService")
public class TimeConfigureServiceImpl implements TimeConfigureService{
	@Resource
	private TimeConfigureDao timeconfigureDao;

	public int insert(TimeConfigure record) {
		// TODO Auto-generated method stub
		return timeconfigureDao.insert(record);
	}

	public int update(TimeConfigure record) {
		// TODO Auto-generated method stub
		return timeconfigureDao.update(record);
	}

	public int delete(Integer id) {
		// TODO Auto-generated method stub
		return timeconfigureDao.delete(id);
	}

	public List<TimeConfigure> select() {
		// TODO Auto-generated method stub
		return timeconfigureDao.select();
	}
    public TimeConfigure selectById(Integer id){
    	return timeconfigureDao.selectById(id);
    }
}
