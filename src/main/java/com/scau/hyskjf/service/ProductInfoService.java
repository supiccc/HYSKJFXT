package com.scau.hyskjf.service;

import com.scau.hyskjf.pojo.Productinfo;
import net.sf.ehcache.util.ProductInfo;

import java.util.List;

public interface ProductInfoService {
    List<Productinfo> findMerAllProduct(Integer merID);

    int insertProduct(Productinfo productinfo);

    int updateProduct(Productinfo productinfo);

    void deleteProduct(Integer pduID);

    List<Productinfo> queryLabelProduct(Integer merID, Integer labelID);
}
