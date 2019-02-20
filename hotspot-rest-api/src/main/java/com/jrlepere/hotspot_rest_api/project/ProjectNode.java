package com.jrlepere.hotspot_rest_api.project;

import java.util.concurrent.atomic.AtomicInteger;

public abstract class ProjectNode implements IProjectNode {
	
	private static AtomicInteger integerCounter = new AtomicInteger();
	private int id;
	private IProjectNode parent;
	
	public ProjectNode(IProjectNode parent) {
		id = integerCounter.incrementAndGet();
		this.parent = parent;
	}
	
	public int getId() {
		return id;
	}
	
	public boolean equals(Object otherProjectNode) {
		return (otherProjectNode instanceof ProjectNode)
				&& id == ((ProjectNode) otherProjectNode).id;
	}
	
}
