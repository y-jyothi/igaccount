package com.example.kalingaAcoounts.service.serviceimpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.kalingaAcoounts.dto.AccountDto;
import com.example.kalingaAcoounts.dto.IGDto;
import com.example.kalingaAcoounts.dto.ProjectDto;
import com.example.kalingaAcoounts.entity.Account;
import com.example.kalingaAcoounts.entity.IG;
import com.example.kalingaAcoounts.entity.Project;
import com.example.kalingaAcoounts.exceptions.serviceexceptions.CostIsMoreThanRevenue;
import com.example.kalingaAcoounts.exceptions.serviceexceptions.IGNotFoundException;
import com.example.kalingaAcoounts.exceptions.serviceexceptions.ServiceException;
import com.example.kalingaAcoounts.repository.AccountRepository;
import com.example.kalingaAcoounts.repository.IGRepository;
import com.example.kalingaAcoounts.service.KalingaService;

@Service
public class KalingaImpl implements KalingaService {

	ModelMapper mapper = new ModelMapper();

	@Autowired
	private IGRepository repo;

	@Autowired
	private AccountRepository accountRepo;

	@Override
	public IGDto insertIG(IGDto igDto) {
		IG ig = convertDtoToEntity(igDto);
		repo.save(ig);

		return igDto;
	}

	@Override
	public AccountDto insertAccount(AccountDto accountDto) throws ServiceException {
		int sum = 0;
		Account account = convertDtoToEntity(accountDto);
		List<ProjectDto> projectDto = accountDto.getProjects();
		List<Project> projects = new ArrayList<Project>();
		for (ProjectDto project : projectDto) {
			Project obj = convertDtoToEntity(project);
			sum = sum + project.getCost();
			projects.add(obj);
		}
		try {
			if (!(sum < account.getRevenue() || sum == account.getRevenue())) {
				throw new CostIsMoreThanRevenue("cost is more than revenue of acount");
			} else {
				account.setProjects(projects);
				accountRepo.save(account);
			}
		} catch (CostIsMoreThanRevenue e) {
			throw new ServiceException(e.getMessage(), e);

		}

		return accountDto;
	}

	@Override
	public String addAccountToIG(String accountName, String igName) throws ServiceException {
		IG ig =repo.findByigName(igName);
		Account account=accountRepo.findByaccountName(accountName);
		try {
			if(ig==null)
			{
				throw new IGNotFoundException("ig not found");
			}
			}
		catch(IGNotFoundException e)
		{
			throw new ServiceException(e.getMessage(), e);
		}
		account.setIg(ig);
		accountRepo.save(account);
		return "inserted";
	}
	@Override
	public List<AccountDto> getAllAccounts(String igName)  {
		IG ig =repo.findByigName(igName);
		List<Account> accounts=ig.getAccounts();
		Collections.sort(accounts);
		List<AccountDto> result=new ArrayList<AccountDto>();
		for (Account account : accounts) {
			AccountDto accountDto=convertEntityToDto(account);
			result.add(accountDto);
		}
		
		

		return result;
	}

	public IG convertDtoToEntity(IGDto igDto) {
		return mapper.map(igDto, IG.class);
	}

	public Account convertDtoToEntity(AccountDto accountDto) {
		return mapper.map(accountDto, Account.class);
	}

	public Project convertDtoToEntity(ProjectDto projectDto) {
		return mapper.map(projectDto, Project.class);
	}
	public AccountDto convertEntityToDto(Account account) {
		return mapper.map(account, AccountDto.class);
	}

	

}
