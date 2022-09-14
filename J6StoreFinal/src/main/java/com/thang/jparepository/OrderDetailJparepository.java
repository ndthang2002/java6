package com.thang.jparepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.thang.entity.OrderDetail;

public interface OrderDetailJparepository  extends JpaRepository<OrderDetail, Integer>{

}
