package com.scau.hyskjf.service;

import com.scau.hyskjf.pojo.Advertise;

import java.util.List;

/**
 * @Author: kevin
 * @Date: 2018/8/15 16:42
 * @Version 1.0
 */
public interface AdvertiseManagementService {
    Advertise findById(int id);

    void updateAdvertise(Advertise advertise);

    List<Advertise> findAll();
}
