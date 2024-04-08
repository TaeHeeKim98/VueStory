package com.story.demo.controller.home;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.binding.MapperMethod.ParamMap;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.story.demo.service.home.StoryHomeService;
import com.story.demo.vo.home.StoryHomeVo;

@RestController
@CrossOrigin
public class StoryHomeController {
	// Set logger
	private final Logger logger = LogManager.getLogger(this.getClass());

	// Get class name for logger
	private final String className = this.getClass().toString();
	
	@Autowired
	private StoryHomeService homeservice;
	
	@GetMapping("/home")
	@ResponseBody
	public Map<String, Object> home() throws Exception {
		
		logger.info("home start");
		className.getClass();
		Map<String, Object> resultMap = new HashMap<>();
		
		List<StoryHomeVo> homeList = homeservice.homeList();
		
		logger.info("   - homelist : " + homeList);
		
		resultMap.put("homelist", homeList);
		
		return resultMap;
	}
	@PostMapping("/createItem")
	public boolean createItem(@RequestParam Map<String, Object> paramMap)throws Exception {
		
		boolean state = false;
		logger.info("createItem start");
		logger.info("   - param :" + paramMap);
		
		System.out.println("   - param :" + paramMap);
		
		if((paramMap.get("title")!= "") || (paramMap.get("contents") != "")) {
			state = homeservice.createItem(paramMap);
		}
		
		System.out.println("   - state :" + state);
		logger.info("   - state :" + state);
		
		return state;
	}
	
	@DeleteMapping("/deletItem")
	public boolean deletItem(@RequestParam Map<String, Object> paramMap) throws Exception {
		boolean state = false;
		
		logger.info("delete start");
		logger.info("   - param :" + paramMap);
		System.out.println("   - param :" + paramMap);
		state = (homeservice.deleteItem(paramMap));
		
		logger.info("   - state :" + state);
		
		return state;
	}
}
