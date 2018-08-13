package com.scau.hyskjf.service.impl;

import com.scau.hyskjf.dao.BrandlabelMapper;
import com.scau.hyskjf.dao.LabelhaveproductMapper;
import com.scau.hyskjf.dao.ProductinfoMapper;
import com.scau.hyskjf.pojo.Productinfo;
import com.scau.hyskjf.service.ProductInfoService;
import net.sf.ehcache.util.ProductInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductInfoServiceImpl implements ProductInfoService {
    @Autowired
    ProductinfoMapper productinfoMapper;

    @Autowired
    BrandlabelMapper brandlabelMapper;

    @Autowired
    LabelhaveproductMapper labelhaveproductMapper;

    public List<Productinfo> findMerAllProduct(Integer merID){
        return productinfoMapper.selectProductByMerID(merID);
    }

    public int insertProduct(Productinfo productinfo){
        return productinfoMapper.insert(productinfo);
    }

    public int updateProduct(Productinfo productinfo){
        return productinfoMapper.updateByPrimaryKeySelective(productinfo);
    }

    public void deleteProduct(Integer pduID){
        labelhaveproductMapper.deleteByPduID(pduID);
        productinfoMapper.deleteByPrimaryKey(pduID);
    }

    public List<Productinfo> queryLabelProduct(Integer merID, Integer labelID){
        return productinfoMapper.queryLabelProduct(merID,labelID);
    }
}
