package com.scau.hyskjf.dao;

import com.scau.hyskjf.pojo.Reissuedetail;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReissuedetailMapper {
    int insert(Reissuedetail record);

    int insertSelective(Reissuedetail record);

    List<Reissuedetail>  findAllReissue();

    List<Reissuedetail> findByMemId(int memid);
}