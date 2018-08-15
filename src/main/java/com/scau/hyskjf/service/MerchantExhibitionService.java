package com.scau.hyskjf.service;

import com.scau.hyskjf.pojo.MerchantInfoInExhibition;

import java.util.List;
import java.util.Map;

/**
 * Created by supiccc on 2018-08-14 20:15
 */
public interface MerchantExhibitionService {

    List<MerchantInfoInExhibition> getAll(); // 获取所有商家信息

    Map doget(Integer merId); // 获取某个商家的基本信息、产品及评论
}
