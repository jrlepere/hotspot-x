package com.jrlepere.hotspot_rest_api;

import java.util.HashMap;
import java.util.Map;

import com.jrlepere.hotspot_rest_api.project.IProjectNode;

public class IdComponentMapper {

	private Map<Integer, IProjectNode> idComponentMapper;
	
	public IdComponentMapper() {
		this.idComponentMapper = new HashMap<>();
	}
	
	public void add(int componentId, IProjectNode node) {
		idComponentMapper.put(componentId, node);
	}
	
	public IProjectNode getComponent(int componentId) {
		return idComponentMapper.get(componentId);
	}
	
}
