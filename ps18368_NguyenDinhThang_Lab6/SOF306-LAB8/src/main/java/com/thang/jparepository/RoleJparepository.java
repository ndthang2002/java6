package com.thang.jparepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.thang.entity.Role;

public interface RoleJparepository extends JpaRepository<Role, String>{

}
