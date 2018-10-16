package com.hf.shjw_globalconfig.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.hf.shjw_globalconfig.model.Configure;
import com.hf.shjw_globalconfig.service.ConfigureService;

@RestController
@RequestMapping("/configure")
public class TestConfigure {
	@Resource
	private ConfigureService configureService;
	@GetMapping("/select")
	 public List<Configure> select(){
		 List<Configure> configure=configureService.select();
		 return configure;
	 }
	@GetMapping("/selectmax")
	 public String selectmax(){
		 String sort=configureService.selectByPrimaryKey("timeType");
		 return sort;
	 }
	@GetMapping("/save")
	@ResponseBody
	 public int save(HttpServletRequest request,@RequestBody JSONObject obj) throws IOException{
		Configure record=new Configure();
		String data=obj.toString();
		JSONArray jsonArray=JSONArray.parseArray(data);
		for(int i = 0; i < jsonArray.size();i++){
        	JSONObject job = jsonArray.getJSONObject(i);
        	 String id = job.getString("id");
        	 String configureKeyName=job.getString("configureKeyName");
        	 String parentId=job.getString("parentId");
        	 String type=job.getString("type");
        	 String sort=job.getString("sort");
        	 record.setId(Integer.parseInt(id));
     		 record.setConfigureKeyName(configureKeyName);
     		 record.setParentId(Integer.parseInt(parentId));
     		 record.setType(type);
     		 record.setSort(sort);
     		 configureService.update(record);
        }
		
		return 0;
		
	 }
	@GetMapping("/insert")
	@ResponseBody
	 public int insert(HttpServletRequest request,@RequestBody JSONObject obj){
		Configure record=new Configure();
		String data=obj.toString();
		JSONArray jsonArray=JSONArray.parseArray(data);
		for(int i = 0; i < jsonArray.size();i++){
			JSONObject job = jsonArray.getJSONObject(i);
			if(job.getString("type")=="timeType")
			{
				String configureKeyName = job.getString("configureKeyName");
				String parentId = job.getString("parentId");
				String type = job.getString("type");
				String configure=configureService.selectByPrimaryKey("timeType");
			}
		}
		//record.setId(Integer.parseInt(request.getParameter("id")));
		record.setConfigureKeyName(request.getParameter("configureKeyName"));
		record.setParentId(Integer.parseInt(request.getParameter("parentId")));
		return configureService.insert(record);
		
	 }
//	@GetMapping("/hello")
//    public String helloHtml(HashMap<String, Object> map) {
//        //map.put("hello", "欢迎进入HTML页面");
//        return "/new";
//    }
}
