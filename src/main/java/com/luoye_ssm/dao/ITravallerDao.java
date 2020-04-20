package com.luoye_ssm.dao;

import com.luoye_ssm.domain.Traveller;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 旅客信息持久层
 */
public interface ITravallerDao {

    @Select("select * from traveller where id in(select travellerId from order_traveller where orderId=#{orderId})")
    public List<Traveller> findByOrderId(int orderId) throws Exception;
}
