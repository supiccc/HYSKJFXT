package com.scau.hyskjf.service.impl;

import com.scau.hyskjf.dao.MemberinfochangeMapper;
import com.scau.hyskjf.pojo.Memberinfochange;
import com.scau.hyskjf.service.MemberManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberManagementServiceImpl implements MemberManagementService {
    @Autowired
    private MemberinfochangeMapper memberinfochangeMapper;

    @Override
    public List<Memberinfochange> findAllMemberinfochange() {
        return memberinfochangeMapper.findAllMemberinfochange();
    }

    @Override
    public List<Memberinfochange> findchangeById(int id) {
        return memberinfochangeMapper.selectchangesByMemid(id);
    }
}
