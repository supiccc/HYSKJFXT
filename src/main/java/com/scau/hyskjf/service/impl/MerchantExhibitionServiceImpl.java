package com.scau.hyskjf.service.impl;

import com.scau.hyskjf.dao.EvaluationMapper;
import com.scau.hyskjf.dao.MerchantdetailMapper;
import com.scau.hyskjf.dao.ProductinfoMapper;
import com.scau.hyskjf.pojo.EvaluationWithBLOBs;
import com.scau.hyskjf.pojo.MerchantInfoInExhibition;
import com.scau.hyskjf.pojo.MerchantdetailWithBLOBs;
import com.scau.hyskjf.pojo.Productinfo;
import com.scau.hyskjf.service.MerchantExhibitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by supiccc on 2018-08-14 20:15
 */
@Service
public class MerchantExhibitionServiceImpl implements MerchantExhibitionService {

    @Autowired
    MerchantdetailMapper merchantdetailMapper;

    @Autowired
    ProductinfoMapper productinfoMapper;

    @Autowired
    EvaluationMapper evaluationMapper;

    @Override
    public List<MerchantInfoInExhibition> getAll() {
        List<MerchantInfoInExhibition> result = new ArrayList<>();
        List<MerchantdetailWithBLOBs> tmps = merchantdetailMapper.selectAll();
        for (MerchantdetailWithBLOBs m : tmps) {
            MerchantInfoInExhibition r = new MerchantInfoInExhibition();
            r.setMerid(m.getMerid());
            r.setMername(m.getMername());
            r.setMerimage(m.getMerimage());
            r.setMertype(m.getMertype());
            r.setMertelphone(m.getMertelphone());
            r.setMerfax(m.getMerfax());
            r.setMercity(m.getMercity());
            r.setMerarea(m.getMerarea());
            r.setMerprincipal(m.getMerprincipal());
            r.setMerprovince(m.getMerprovince());
            r.setMerAddress(m.getMeradress());
            result.add(r);
        }
        return result;
    }

    @Override
    public Map doget(Integer merId) {
        Map result = new HashMap();
        MerchantdetailWithBLOBs tmp = merchantdetailMapper.selectByMerID(merId);
        if (tmp.equals(null)) return null;
        MerchantInfoInExhibition m = new MerchantInfoInExhibition();
        m.setMerid(tmp.getMerid());
        m.setMername(tmp.getMername());
        m.setMerimage(tmp.getMerimage());
        m.setMertype(tmp.getMertype());
        m.setMertelphone(tmp.getMertelphone());
        m.setMerfax(tmp.getMerfax());
        m.setMercity(tmp.getMercity());
        m.setMerarea(tmp.getMerarea());
        m.setMerprincipal(tmp.getMerprincipal());
        m.setMerprovince(tmp.getMerprovince());
        m.setMerAddress(tmp.getMeradress());
        m.setMerAddress(tmp.getMeradress());
        result.put("info", m);
        List<Productinfo> p = productinfoMapper.selectProductByMerID(merId);
        result.put("product", p);
        List<EvaluationWithBLOBs> e = evaluationMapper.selectByMerid(merId);
        result.put("evaluation", e);
        return result;
    }
}
