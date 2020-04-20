package com.luoye_ssm.service;

import com.luoye_ssm.domain.Product;

import java.util.List;

/**
 * 商品类业务接口
 */
public interface IProductService {

    /**
     * 查询所有商品的业务方法
     * @return所有商品
     * @throws Exception
     */
    public List<Product> findAll(int page,int size) throws Exception;

    /**
     * 保存商品
     * @param product
     */
    void save(Product product) throws Exception;
}
