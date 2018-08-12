package com.scau.hyskjf.dao;

import com.scau.hyskjf.pojo.Labelhaveproduct;
import org.springframework.stereotype.Repository;

@Repository
public interface LabelhaveproductMapper {
    int insert(Labelhaveproduct record);

    int insertSelective(Labelhaveproduct record);
}