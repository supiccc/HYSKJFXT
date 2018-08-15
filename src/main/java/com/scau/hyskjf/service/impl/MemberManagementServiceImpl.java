package com.scau.hyskjf.service.impl;

import com.scau.hyskjf.dao.MemberMapper;
import com.scau.hyskjf.dao.MemberinfochangeMapper;
import com.scau.hyskjf.dao.ReissuedetailMapper;
import com.scau.hyskjf.pojo.Member;
import com.scau.hyskjf.pojo.Memberinfochange;
import com.scau.hyskjf.pojo.Reissuedetail;
import com.scau.hyskjf.service.MemberManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberManagementServiceImpl implements MemberManagementService {
    @Autowired
    private MemberinfochangeMapper memberinfochangeMapper;

    @Autowired
    private ReissuedetailMapper reissuedetailMapper;

    @Autowired
    private MemberMapper memberMapper;

    @Override
    public List<Memberinfochange> findAllMemberinfochange() {
        return memberinfochangeMapper.findAllMemberinfochange();
    }

    @Override
    public List<Memberinfochange> findchangeById(int id) {
        return memberinfochangeMapper.selectchangesByMemid(id);
    }

    @Override
    public List<Reissuedetail> findAllReissue() {
        return reissuedetailMapper.findAllReissue();
    }

    @Override
    public List<Reissuedetail> findReissueByMemid(int id) {
        return reissuedetailMapper.findByMemId(id);
    }

    @Override
    public Member findMemberinfoById(int id) {
        return memberMapper.selectByPrimaryKey(id);
    }
}
