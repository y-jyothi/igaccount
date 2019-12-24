package com.example.kalingaAcoounts.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.kalingaAcoounts.entity.Account;


@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {

	Account findByaccountName(String accountName);

}
