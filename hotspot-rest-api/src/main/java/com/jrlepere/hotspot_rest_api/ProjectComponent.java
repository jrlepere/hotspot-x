package com.jrlepere.hotspot_rest_api;

public abstract class ProjectComponent implements IProjectComponent {

	private String name;
	private int id;
	
	public ProjectComponent(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
}
