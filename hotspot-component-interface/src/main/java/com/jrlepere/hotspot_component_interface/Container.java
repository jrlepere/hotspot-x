package com.jrlepere.hotspot_component_interface;

public class Container implements ProjectComponent {

	private String name;
	
	public Container() {}
	
	public Container(String name) {
		this.name = name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public boolean equals(Object otherContainer) {
		return (otherContainer instanceof Container)
				&& this.name.equals(((Container) otherContainer).name);
	}
	
	public String toString() {
		return "{name=" + name + "}";
	}
	
}
