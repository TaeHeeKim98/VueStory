package com.story.demo.service.home;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.story.demo.vo.home.StoryHomeVo;

import jakarta.websocket.server.ServerEndpoint;

import com.story.demo.repository.home.StoryHomeMapper;

@Service
public class StoryHomeService {
	
	// Set logger
	private final Logger logger = LogManager.getLogger(this.getClass());

	// Get class name for logger
	private final String className = this.getClass().toString();
	
	@Autowired
	private StoryHomeMapper StoryHomeMapper;
		
	public List<StoryHomeVo> homeList() {
		return StoryHomeMapper.homeList();
	}

}
