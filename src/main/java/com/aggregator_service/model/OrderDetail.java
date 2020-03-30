package com.aggregator_service.model;

import java.util.List;

public class OrderDetail {
	private User user;
	private List<Order> orderList;

	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public List<Order> getOrderList() {
		return orderList;
	}
	public void setOrderList(List<Order> orderList) {
		this.orderList = orderList;
	}
//	public void setOrderList(List<Order> body) {
//		// TODO Auto-generated method stub
//		
//	}
//	
	

}
