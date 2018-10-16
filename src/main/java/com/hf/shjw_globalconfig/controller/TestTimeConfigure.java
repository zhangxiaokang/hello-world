package com.hf.shjw_globalconfig.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.hf.shjw_globalconfig.model.TimeConfigure;
import com.hf.shjw_globalconfig.service.TimeConfigureService;

@RestController
@RequestMapping("/timeconfigure")
public class TestTimeConfigure {
	@Resource
	private TimeConfigureService timeConfigureService;
/**
 * @author 0380009045
 * @Description 查询数据表中所有的时间段配置信息
 * @return
 */
	@GetMapping("/timeselect")
	public List<TimeConfigure> select() {
//		RequestJson result = new RequestJson();
		try{
		List<TimeConfigure> configure = timeConfigureService.select();
		return configure;
		}catch (Exception e) {
            e.printStackTrace();
            return null;
        }
	}
	@GetMapping("/timeupdate")
	public int updateTimeConfigure(HttpServletRequest request, @RequestBody JSONObject obj) {
		TimeConfigure timeConfigure = new TimeConfigure();
		try {
			Integer id = Integer.parseInt(obj.getString("id"));
			timeConfigure = timeConfigureService.selectById(id);
			if (timeConfigure != null) {
				String timeName = obj.getString("timeName");
				String beginTime = obj.getString("beginTime");
				String endTime = obj.getString("endTime");
				timeConfigure.setId(id);
				timeConfigure.setTimeName(timeName);
				timeConfigure.setBeginTime(beginTime);
				timeConfigure.setEndTime(endTime);
				timeConfigureService.update(timeConfigure);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		// String data = obj.toString();
		// JSONArray jsonArray = JSONArray.parseArray(data);
		// for (int i = 0; i < jsonArray.size(); i++) {
		// JSONObject job = jsonArray.getJSONObject(i);
		// Integer id = Integer.parseInt(job.getString("id"));
		// }
		return 0;
	}
	@GetMapping("/timeinsert")
	public int insertTimeConfigure(HttpServletRequest request, @RequestBody JSONObject obj) {
		TimeConfigure timeConfigure = new TimeConfigure();
		try {
//			String json = "{\"timeName\":\"晚上\",\"beginTime\":\"18:00\",\"endTime\":\"20:00\"}";
//			JSONObject obj = JSONObject.parseObject(json);
			String timeName = obj.getString("timeName");
			String beginTime = obj.getString("beginTime");
			String endTime = obj.getString("endTime");
			timeConfigure.setTimeName(timeName);
			timeConfigure.setBeginTime(beginTime);
			timeConfigure.setEndTime(endTime);
			timeConfigureService.insert(timeConfigure);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	@GetMapping("/timedelete")
	public int deleteTimeConfigure(HttpServletRequest request, @RequestBody JSONObject obj){
		TimeConfigure timeConfigure = new TimeConfigure();
		try {
			Integer id = Integer.parseInt(obj.getString("id"));
			// timeConfigure.setId(id);
			timeConfigure = timeConfigureService.selectById(id);
			if (timeConfigure != null) {
				timeConfigureService.delete(id);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
		
	}
	
}
