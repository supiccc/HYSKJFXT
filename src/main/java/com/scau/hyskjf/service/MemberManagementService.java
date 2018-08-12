package com.scau.hyskjf.service;

import com.scau.hyskjf.pojo.Memberinfochange;

import java.util.List;

public interface MemberManagementService {
    List<Memberinfochange> findAllMemberinfochange();

    List<Memberinfochange> findchangeById(int id);
}
