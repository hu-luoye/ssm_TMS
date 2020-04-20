package com.luoye_ssm.dao;

import com.luoye_ssm.domain.Product;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 商品的接口类
 */
@Repository("productDao")
public interface IProductDao {

    /**
     * 查询所有的商品信息
     * @return返回所有商品信息
     * @throws Exception
     */
    @Select("select * from product")
    public List<Product> findAll() throws Exception;

   @Insert("insert into product(productNum,productName,cityName,departureTime,productPrice,productDesc,productStaus) values(#{productNum},#{productName},#{cityName},#{departureTime},#{productPrice},#{productDesc},#{productStaus})")
   public void save(Product product);

    @Select("select * from product where id=#{id}")
    Product findById(int id);
}
