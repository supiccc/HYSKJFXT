package com.scau.hyskjf.service;

import com.scau.hyskjf.pojo.Brandlabel;
import com.scau.hyskjf.pojo.Labelhaveproduct;
import net.sf.ehcache.util.ProductInfo;

import java.util.List;

public interface BrandLabelService {
    List<Brandlabel> queryAllLabel();

    List<Brandlabel> queryLabelByType(String labelType);

    int insertLabel(Brandlabel brandlabel);

    int deleteLabel(Integer labelID);

    int updateLabel(Brandlabel brandlabel);

    int insertProductLabel(Labelhaveproduct labelhaveproduct);

    int deleteProductLabel(Labelhaveproduct labelhaveproduct);
}
