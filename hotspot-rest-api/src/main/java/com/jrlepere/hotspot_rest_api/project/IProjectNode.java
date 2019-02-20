package com.jrlepere.hotspot_rest_api.project;

import java.util.Collection;

import com.jrlepere.hotspot_component_interface.Method;
import com.jrlepere.hotspot_component_interface.ProjectComponent;

public interface IProjectNode {
	public int getId();
	public void addChild(IProjectNode child);
	public IProjectNode getChildNode(ProjectComponent component);
	public ProjectComponent getProjectComponent();
	public Collection<Integer> getChildComponentIds();
	public Collection<Method> getMethods();
	public boolean containsChildComponent(ProjectComponent component);
}
