package com.thang.Dao;

import javax.persistence.criteria.Order;

import org.springframework.data.jpa.repository.JpaRepository;

import com.thang.Entity.Hoadon;

public interface OrderDAO extends JpaRepository<Hoadon, Long>{

}
