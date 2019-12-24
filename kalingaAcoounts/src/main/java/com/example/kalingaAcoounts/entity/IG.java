package com.example.kalingaAcoounts.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="IG")
public class IG {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int igId;
	 
	private String igName;
	
	@OneToMany(cascade=CascadeType.PERSIST,mappedBy="ig")
	List<Account> accounts;

	public IG() {
		super();
		// TODO Auto-generated constructor stub
	}

	public IG(int igId, String igName, List<Account> accounts) {
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

	public List<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}
	

}
