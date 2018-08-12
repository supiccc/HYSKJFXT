package com.scau.hyskjf.service.impl;

import com.scau.hyskjf.dao.MerchantinfoMapper;
import com.scau.hyskjf.dao.ProductinfoMapper;
import com.scau.hyskjf.pojo.Productinfo;
import com.scau.hyskjf.service.MerchantInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MerchantInfoServiceImpl implements MerchantInfoService {
    @Autowired
    MerchantinfoMapper merchantinfoMapper;


}
