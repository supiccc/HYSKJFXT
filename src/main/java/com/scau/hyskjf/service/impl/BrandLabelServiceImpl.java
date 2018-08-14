package com.scau.hyskjf.service.impl;

import com.scau.hyskjf.dao.BrandlabelMapper;
import com.scau.hyskjf.dao.LabelhaveproductMapper;
import com.scau.hyskjf.pojo.Brandlabel;
import com.scau.hyskjf.pojo.Labelhaveproduct;
import com.scau.hyskjf.service.BrandLabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandLabelServiceImpl implements BrandLabelService {
    @Autowired
    LabelhaveproductMapper labelhaveproductMapper;

    @Autowired
    BrandlabelMapper brandlabelMapper;

    public List<Brandlabel> queryAllLabel(){
        return brandlabelMapper.queryAllLabel();
    }

    public List<Brandlabel> queryLabelByType(String labelType){
        return brandlabelMapper.queryLabelByType(labelType);
    }

    public int insertLabel(Brandlabel brandlabel){
        return brandlabelMapper.insert(brandlabel);
    }

    public int deleteLabel(Integer labelID){
        labelhaveproductMapper.deleteByLabelID(labelID);
        return brandlabelMapper.deleteByPrimaryKey(labelID);
    }

    public int updateLabel(Brandlabel brandlabel){
        return brandlabelMapper.updateByPrimaryKeySelective(brandlabel);
    }

    public int insertProductLabel(Labelhaveproduct labelhaveproduct){
        return labelhaveproductMapper.insert(labelhaveproduct);
    }

    public int deleteProductLabel(Labelhaveproduct labelhaveproduct){
        return labelhaveproductMapper.deleteByLabelhaveproduct(labelhaveproduct);
    }


}
