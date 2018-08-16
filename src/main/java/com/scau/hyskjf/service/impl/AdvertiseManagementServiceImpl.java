package com.scau.hyskjf.service.impl;

import com.scau.hyskjf.dao.AdvertiseMapper;
import com.scau.hyskjf.pojo.Advertise;
import com.scau.hyskjf.service.AdvertiseManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: kevin
 * @Date: 2018/8/15 16:42
 * @Version 1.0
 */
@Service
public class AdvertiseManagementServiceImpl implements AdvertiseManagementService {

    @Autowired
    private AdvertiseMapper advertiseMapper;

    @Override
    public Advertise findById(int id) {
        return advertiseMapper.selectByPrimaryKey(id);
    }

    @Override
    public void updateAdvertise(Advertise advertise) {
        advertiseMapper.updateByPrimaryKeyWithBLOBs(advertise);
    }

    @Override
    public List<Advertise> findAll() {
        return advertiseMapper.findAllAdvertise();
    }
}
