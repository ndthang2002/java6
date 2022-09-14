package com.thang.service.impl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.thang.entity.Account;
import com.thang.entity.Authority;
import com.thang.jparepository.AccountJparepository;
import com.thang.jparepository.AuthorityJparepository;
import com.thang.service.AuthorityService;



@Service
public class AuthorityServiceImpl implements AuthorityService{
	@Autowired private AuthorityJparepository authdao;
	@Autowired private AccountJparepository accdao;
	
	
	@Override
	public List<Authority> findAuthoritiesOfAdministrators() {
		List<Account> accounts = accdao.getAdministrators();
		return authdao.authoritiesOf(accounts);
	}

	@Override
	public List<Authority> findAll() {
		return authdao.findAll();
	}

	@Override
	public Authority create(Authority auth) {
		return authdao.save(auth);
	}

	@Override
	public void delete(Integer id) {
		authdao.deleteById(id);
	}

	@Override
	public List<Authority> getOneByRole(String username) {
		return authdao.getOneByRole(username);
	}

	@Override
	public void deleteByUsername(String username) {
		authdao.deleteByUserName(username);
	}

	/*Summary*/
	@Override
	public Long getTotalCustomer() {
		return authdao.findAll().stream().filter(e->e.getRole().getName().equals("Customers")).count();
	}
	
}


