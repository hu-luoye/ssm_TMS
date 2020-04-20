package com.luoye_ssm.service.impl;

import com.github.pagehelper.PageHelper;
import com.luoye_ssm.dao.IProductDao;
import com.luoye_ssm.domain.Product;
import com.luoye_ssm.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 商品业务层的实现类
 */
@Service
@Transactional
public class ProductServiceImpl implements IProductService {

    @Autowired
    private IProductDao productDao;

    @Override
    public List<Product> findAll(int page,int size) throws Exception {

        //设置分页
        PageHelper.startPage(page,size);
        return productDao.findAll();
    }

    @Override
    public void save(Product product) throws Exception {
        productDao.save(product);
    }
}
