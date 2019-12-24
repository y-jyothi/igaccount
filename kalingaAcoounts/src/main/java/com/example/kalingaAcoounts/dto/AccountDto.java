package com.example.kalingaAcoounts.dto;

import java.util.List;

import com.example.kalingaAcoounts.entity.IG;

public class AccountDto {
	
	private int accountId;
	private String accountName;
	private int revenue;
	
	
	List<ProjectDto> projects;
	private IGDto ig;


	public IGDto getIg() {
		return ig;
	}


	public void setIg(IGDto ig) {
		this.ig = ig;
	}


	public AccountDto(int accountId, String accountName, int revenue, List<ProjectDto> projects, IGDto ig) {
		super();
		this.accountId = accountId;
		this.accountName = accountName;
		this.revenue = revenue;
		this.projects = projects;
		this.ig = ig;
	}


	public AccountDto() {
		super();
		// TODO Auto-generated constructor stub
	}


	public AccountDto(int accountId, String accountName, int revenue, List<ProjectDto> projects) {
		super();
		this.accountId = accountId;
		this.accountName = accountName;
		this.revenue = revenue;
		this.projects = projects;
	}


	public int getAccountId() {
		return accountId;
	}


	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}


	public String getAccountName() {
		return accountName;
	}


	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}


	public int getRevenue() {
		return revenue;
	}


	public void setRevenue(int revenue) {
		this.revenue = revenue;
	}


	public List<ProjectDto> getProjects() {
		return projects;
	}


	public void setProjects(List<ProjectDto> projects) {
		this.projects = projects;
	}


}
