package com.example.kalingaAcoounts.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.kalingaAcoounts.dto.AccountDto;
import com.example.kalingaAcoounts.dto.IGDto;
import com.example.kalingaAcoounts.exceptions.serviceexceptions.ServiceException;
import com.example.kalingaAcoounts.service.KalingaService;

@RestController
public class AppController {

	@Autowired
	KalingaService ser;

	@PostMapping(value = "/IG")
	public IGDto insertIg(@RequestBody IGDto igDto) {
		return ser.insertIG(igDto);

	}

	@PostMapping(value = "/Account")
	public AccountDto insertAccount(@RequestBody AccountDto accountDto) throws ServiceException {
		return ser.insertAccount(accountDto);

	}
	@PutMapping(value="/assign/{igName}/{accountName}")
	public String aasignAccountToIg(@PathVariable("igName") String igName,@PathVariable("accountName") String accountName) throws ServiceException {
	return ser.addAccountToIG(accountName, igName);
	}
	
	@GetMapping(value="/getAccounts/{igName}") 
	public List<AccountDto> getAllAccountsByIGName(@PathVariable("igName") String igName)
	{
		return ser.getAllAccounts(igName);
		
	}

}
