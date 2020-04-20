package com.luoye_ssm.dao;

import com.luoye_ssm.domain.Member;
import com.luoye_ssm.domain.Order;
import com.luoye_ssm.domain.Product;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 订单数据持久层
 */
@Repository("orderDao")
public interface IOrderDao {

    @Select("select * from `order`")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "orderNum",column = "orderNum"),
            @Result(property = "orderTime",column = "orderTime"),
            @Result(property = "orderStatus",column = "orderStatus"),
            @Result(property = "propleCount",column = "peopleCount"),
            @Result(property = "payType",column = "payType"),
            @Result(property = "orderDesc",column = "orderDesc"),
            @Result(property = "product",column = "productId",javaType = Product.class,one = @One(select = "com.luoye_ssm.dao.IProductDao.findById"))
    })
    public List<Order> findAll() throws Exception;


    @Select("select * from `order` where id=#{orderId}")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "orderNum",column = "orderNum"),
            @Result(property = "orderTime",column = "orderTime"),
            @Result(property = "orderStatus",column = "orderStatus"),
            @Result(property = "propleCount",column = "peopleCount"),
            @Result(property = "payType",column = "payType"),
            @Result(property = "orderDesc",column = "orderDesc"),
            @Result(property = "product",column = "productId",javaType = Product.class,one = @One(select = "com.luoye_ssm.dao.IProductDao.findById")),
            @Result(property = "member",column = "memberId",javaType = Member.class,one = @One(select = "com.luoye_ssm.dao.IMemberDao.findById")),
            @Result(property = "travellers",column = "id",javaType = List.class,many = @Many(select = "com.luoye_ssm.dao.ITravallerDao.findByOrderId"))
    })
    public Order findById(int orderId) throws Exception;
}
