package com.luoye_ssm.service;

import com.luoye_ssm.domain.Order;

import java.util.List;

/**
 * 订单业务层
 */
public interface IOrderService {

    public List<Order> findAll(int page,int size) throws Exception;

    public Order findById(int orderId) throws Exception;
}
