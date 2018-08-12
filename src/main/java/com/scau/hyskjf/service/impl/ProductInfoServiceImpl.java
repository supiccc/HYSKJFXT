package com.scau.hyskjf.service.impl;

import com.scau.hyskjf.dao.BrandlabelMapper;
import com.scau.hyskjf.dao.LabelhaveproductMapper;
import com.scau.hyskjf.dao.ProductinfoMapper;
import com.scau.hyskjf.service.ProductInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductInfoServiceImpl implements ProductInfoService {
    @Autowired
    ProductinfoMapper productinfoMapper;

    @Autowired
    BrandlabelMapper brandlabelMapper;

    @Autowired
    LabelhaveproductMapper labelhaveproductMapper;


}
