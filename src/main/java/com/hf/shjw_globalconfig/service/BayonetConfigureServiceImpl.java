package com.hf.shjw_globalconfig.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hf.shjw_globalconfig.dao.BayonetConfigureDao;
import com.hf.shjw_globalconfig.model.BayonetConfigure;
@Service("BayonetConfigureService")
public class BayonetConfigureServiceImpl implements BayonetConfigureService{
	@Resource
	private BayonetConfigureDao bayonetConfigureDao;
	public int insert(BayonetConfigure record) {
		// TODO Auto-generated method stub
		return bayonetConfigureDao.insert(record);
	}

	public int update(BayonetConfigure record) {
		// TODO Auto-generated method stub
		return bayonetConfigureDao.update(record);
	}

	public int delete(Integer id) {
		// TODO Auto-generated method stub
		return bayonetConfigureDao.delete(id);
	}

	public List<BayonetConfigure> select() {
		// TODO Auto-generated method stub
		return bayonetConfigureDao.select();
	}

}
