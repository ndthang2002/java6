package com.thang.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.thang.entity.Account;

@Service
public interface AccountService {

	Account findById(String username);

	List<Account> getAdministrators();

	List<Account> findAll();

	Account create(Account account);

	Account update(Account account);

	Long getTotalAccount();

	List<Object[]> top10Customer();
}
