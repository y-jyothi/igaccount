package com.example.kalingaAcoounts.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.OneToMany;

import com.example.kalingaAcoounts.entity.Account;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class IGDto {
	
	private int igId;
	 
	private String igName;
	
	@OneToMany(cascade=CascadeType.PERSIST)
	List<AccountDto> accounts;

	public IGDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public IGDto(int igId, String igName, List<AccountDto> accounts) {
		super();
		this.igId = igId;
		this.igName = igName;
		this.accounts = accounts;
	}

	public int getIgId() {
		return igId;
	}

	public void setIgId(int igId) {
		this.igId = igId;
	}

	public String getIgName() {
		return igName;
	}

	public void setIgName(String igName) {
		this.igName = igName;
	}
@JsonIgnore
	public List<AccountDto> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<AccountDto> accounts) {
		this.accounts = accounts;
	}



}
