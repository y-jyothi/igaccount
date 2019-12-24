package com.example.kalingaAcoounts.dto;

public class ProjectDto {
	
private int projectId;
	
	private String projectName;
	
	private int cost;

	public ProjectDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProjectDto(int projectId, String projectName, int cost) {
		super();
		this.projectId = projectId;
		this.projectName = projectName;
		this.cost = cost;
	}

	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}


}
