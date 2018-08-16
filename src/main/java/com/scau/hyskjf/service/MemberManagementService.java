package com.scau.hyskjf.service;

import com.scau.hyskjf.pojo.Member;
import com.scau.hyskjf.pojo.Memberinfochange;
import com.scau.hyskjf.pojo.Reissuedetail;

import java.util.List;

public interface MemberManagementService {
    List<Memberinfochange> findAllMemberinfochange();

    List<Memberinfochange> findchangeById(int id);

    List<Reissuedetail> findAllReissue();

    List<Reissuedetail> findReissueByMemid(int id);

    Member findMemberinfoById(int id);
}
