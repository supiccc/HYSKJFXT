package com.scau.hyskjf.dao;

import com.scau.hyskjf.pojo.Merchantmoneyreturn;
import org.springframework.stereotype.Repository;

@Repository
public interface MerchantmoneyreturnMapper {
    int insert(Merchantmoneyreturn record);

    int insertSelective(Merchantmoneyreturn record);
}