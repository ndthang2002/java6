package com.thang.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.thang.entity.Order;
import com.thang.entity.OrderDetail;
import com.thang.jparepository.OrderDetailJparepository;
import com.thang.jparepository.OrderJparepository;
import com.thang.service.OrderService;
import com.fasterxml.jackson.core.type.TypeReference;

@Service
public class OrderServiceImpl implements OrderService{

	@Autowired private OrderJparepository orderjpa;
	@Autowired private OrderDetailJparepository orderdetailjpa;
	@Override
	public Order create(JsonNode orderData) {
		ObjectMapper mapper = new ObjectMapper();
		
		Order order = mapper.convertValue(orderData, Order.class);
		orderjpa.save(order);
		
		TypeReference<List<OrderDetail>> type = new TypeReference<>() {};
		List<OrderDetail> details = mapper.convertValue(orderData.get("orderDetails"), type)
				.stream().peek(d->d.setOrder(order)).collect(Collectors.toList());
		orderdetailjpa.saveAll(details);
		
		return order;
	}
	
	
	
	@Override
	public List<Order> findByUsername(String username) {
		return orderjpa.findByUsername(username);
	}
	/* Summary section */
	
	@Override
	public Long getToDayOrder() {
		return orderjpa.getTodayOrder();
	}
	@Override
	public Long totalOrder() {
		return orderjpa.count();
	}
	@Override
	public List<Object[]> getRevenueLast7Days() {
		return orderjpa.getRevenueLast7Days();
	}



	@Override
	public Order findById(Long id) {
		// TODO Auto-generated method stub
		return orderjpa.findById(id).get();
	}
	
}
