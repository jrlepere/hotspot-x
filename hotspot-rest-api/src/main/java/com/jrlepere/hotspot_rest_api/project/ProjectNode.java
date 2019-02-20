package com.jrlepere.hotspot_rest_api.project;

public abstract class ProjectNode implements IProjectNode {

	// TODO: ID generator
	
	private int id;
	private IProjectNode parent;
	
	public ProjectNode(IProjectNode parent) {
		// id = gen id
		this.parent = parent;
	}
	
	public int getId() {
		return 0;
	}
	
	public boolean equals(Object otherProjectNode) {
		return (otherProjectNode instanceof ProjectNode)
				&& id == ((ProjectNode) otherProjectNode).id;
	}
	
}
