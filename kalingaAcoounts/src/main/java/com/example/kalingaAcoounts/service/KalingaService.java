package com.example.kalingaAcoounts.service;

import java.util.List;

import com.example.kalingaAcoounts.dto.AccountDto;
import com.example.kalingaAcoounts.dto.IGDto;
import com.example.kalingaAcoounts.entity.Account;
import com.example.kalingaAcoounts.exceptions.serviceexceptions.ServiceException;

public interface KalingaService {
	
	public IGDto insertIG(IGDto ig);
	public AccountDto insertAccount(AccountDto account)throws ServiceException;
	public String addAccountToIG(String accountName,String igName)throws ServiceException;
	public List<AccountDto> getAllAccounts(String igName);
}
