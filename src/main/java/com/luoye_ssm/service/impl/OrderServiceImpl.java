package com.luoye_ssm.service.impl;

import com.github.pagehelper.PageHelper;
import com.luoye_ssm.dao.IOrderDao;
import com.luoye_ssm.domain.Order;
import com.luoye_ssm.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("orderService")
@Transactional
public class OrderServiceImpl implements IOrderService{

    @Autowired
    private IOrderDao orderDao;

    @Override
    public List<Order> findAll(int page,int size) throws Exception {

        PageHelper.startPage(page,size);
        return orderDao.findAll();
    }

    @Override
    public Order findById(int orderId) throws Exception {
        return orderDao.findById(orderId);
    }
}
