package com.scau.hyskjf.dao;

import com.scau.hyskjf.pojo.Reissue;
import org.springframework.stereotype.Repository;

@Repository
public interface ReissueMapper {
    int deleteByPrimaryKey(Integer reiid);

    int insert(Reissue record);

    int insertSelective(Reissue record);

    Reissue selectByPrimaryKey(Integer reiid);

    int updateByPrimaryKeySelective(Reissue record);

    int updateByPrimaryKeyWithBLOBs(Reissue record);

    int updateByPrimaryKey(Reissue record);
}