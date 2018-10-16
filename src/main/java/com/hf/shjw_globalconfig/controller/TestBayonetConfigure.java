package com.hf.shjw_globalconfig.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.hf.shjw_globalconfig.model.BayonetConfigure;
import com.hf.shjw_globalconfig.service.BayonetConfigureService;

@RestController
@RequestMapping("/bayonetconfigure")
public class TestBayonetConfigure {
	@Resource
	private BayonetConfigureService bayonetConfigureService;
	@GetMapping("/select")
	 public List<BayonetConfigure> select(){
		 List<BayonetConfigure> configure=bayonetConfigureService.select();
		 return configure;
	 }
	@GetMapping("/selectbyid")//get
	 public String selectById(HttpServletRequest request,HttpServletResponse response){//@PathVariable("id") Integer id){
		String id=request.getParameter("id"); 
		int d=Integer.parseInt(id);
		//List<BayonetConfigure> configure=bayonetConfigureService.select();
		 return id;
	 }
	@PostMapping("/selectbytype")//post
	 public List<BayonetConfigure> selectByType(HttpServletRequest request,HttpServletResponse response){
		 String type=request.getParameter("type");
		 String name=request.getParameter("name");
		 List<BayonetConfigure> configure=bayonetConfigureService.select();
		 return configure;
	 }
	@PostMapping("/save")
	 public int addFiledProperty(){//HttpServletRequest request, @RequestBody JSONObject obj){
		 //String jsonStr=obj.toJSONString();
		 String jsonStr="[{\"id\":17,\"type\":\"bayonet_type\",\"description\":\"卡口类型\",\"name\":\"人脸卡口\",\"value\":\"\",\"sort\":\"\",\"memo\":null},{\"id\":2,\"type\":\"bayonet_type\",\"description\":\"卡口类型\",\"name\":\"车辆卡口\",\"value\":\"\",\"sort\":\"\",\"memo\":null},{\"id\":null,\"type\":\"bayonet_type\",\"description\":\"卡口类型\",\"name\":\"人脸卡口\",\"value\":\"\",\"sort\":\"\",\"memo\":null}]";
		 JSONArray jsonArray=JSONArray.parseArray(jsonStr);
		 List<BayonetConfigure> currList=new ArrayList<BayonetConfigure>();
		 for(int i=0;i<jsonArray.size();i++){
			 JSONObject job = jsonArray.getJSONObject(i);
			 BayonetConfigure bayonetConfigure=new BayonetConfigure();
			if (job.getString("id") !=null) {
				bayonetConfigure.setId(Integer.parseInt(job.getString("id")));
			}
			 bayonetConfigure.setType(job.getString("type"));
			 bayonetConfigure.setDescription(job.getString("description"));
			 bayonetConfigure.setName(job.getString("name"));
			 currList.add(bayonetConfigure);
		 }
		 List<BayonetConfigure> oldList=bayonetConfigureService.select();
		 List<BayonetConfigure> list1=new ArrayList<BayonetConfigure>();//批量更新
		 List<BayonetConfigure> list2=new ArrayList<BayonetConfigure>();//批量插入
		 List<BayonetConfigure> list3=new ArrayList<BayonetConfigure>();//批量删除
		 int i, j;
		for (i = 0; i < currList.size(); i++) {
			if (currList.get(i).getId() != null) {
				for (j = 0; j < oldList.size(); j++) {
					if (currList.get(i).getId().equals(oldList.get(j).getId())) {
						list1.add(currList.get(i));// 更新
						//bayonetConfigureService.update(currList.get(i));
						break;
					}
				}
				if(j==oldList.size()){
					bayonetConfigureService.insert(currList.get(i)); 
				}
			}
		}
		for(i=0;i<currList.size();i++){
			if (currList.get(i).getId() ==null) {
					list2.add(currList.get(i));// 插入
				//bayonetConfigureService.insert(currList.get(i)); 
			}
		}

		for (i = 0; i < oldList.size(); i++)// 删
		{
			for (j = 0; j < currList.size(); j++) {
				if (currList.get(j).getId() != null) {
					if (oldList.get(i).getId() == currList.get(j).getId())
						break;
				}
			}
			if (j == currList.size()) {
				list3.add(oldList.get(i));
				//bayonetConfigureService.delete(oldList.get(i).getId());
			}
		}
//		if(list1.size()>0)
//			 for(int q=0;q<list1.size();q++){
//				 bayonetConfigureService.update(list1.get(q)); 
//			 }
//		if(list2.size()>0)
//			 for(int q=0;q<list2.size();q++){
//				 bayonetConfigureService.insert(list2.get(q)); 
//			 }
//		if(list3.size()>0)
//			 for(int q=0;q<list3.size();q++){
//				 bayonetConfigureService.delete(list3.get(q).getId()); 
//			 }
		 return 0;
	 }
}
