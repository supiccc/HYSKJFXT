package com.scau.hyskjf.service;

import com.scau.hyskjf.pojo.Merchant;
import com.scau.hyskjf.pojo.Merchantinfo;
import com.scau.hyskjf.pojo.MerchantinfoWithBLOBs;

public interface MerchantJoinService {
    void developJoin(MerchantinfoWithBLOBs merchantinfoWithBLOBs, Merchant merchant);

    void independentJoin(MerchantinfoWithBLOBs merchantinfoWithBLOBs, Merchant merchant);
}
