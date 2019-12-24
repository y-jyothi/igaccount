package com.example.kalingaAcoounts.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Account")
public class Account implements Comparable<Account> {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int accountId;
	private String accountName;
	private int revenue;
	
	@OneToMany(cascade=CascadeType.PERSIST)
	List<Project> projects;
	@ManyToOne
	private IG ig;

	public IG getIg() {
		return ig;
	}

	public void setIg(IG ig) {
		this.ig = ig;
	}

	public Account(int accountId, String accountName, int revenue, List<Project> projects, IG ig) {
		super();
		this.accountId = accountId;
		this.accountName = accountName;
		this.revenue = revenue;
		this.projects = projects;
		this.ig = ig;
	}

	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Account(int accountId, String accountName, int revenue, List<Project> projects) {
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

	public List<Project> getProjects() {
		return projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}

	@Override
	public int compareTo(Account account) {
		int result=0;
		if(this.getRevenue()>account.getRevenue())
			//return account.getRevenue()-this.getRevenue();
			result=-1;
		else if(this.getRevenue()==account.getRevenue())
		{
			result=this.accountName.compareTo(account.getAccountName());
			return result;
		
		}
		
		return result;
	}
	
	
	
	
	

}
