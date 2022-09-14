package com.thang.jparepository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.thang.entity.Account;
import com.thang.entity.Authority;
@Repository
public interface AuthorityJparepository extends JpaRepository<Authority, Integer>{
	
	
	@Query("Select Distinct a From Authority a where a.account IN ?1")
	List<Authority> authoritiesOf(List<Account> accounts);
	
	@Query("Select a From Authority a where a.account.username like ?1")
	List<Authority> getOneByRole(String username);

	@Transactional
	@Modifying
	@Query("Delete from Authority where Username = ?1")
	void deleteByUserName(String username);
}
