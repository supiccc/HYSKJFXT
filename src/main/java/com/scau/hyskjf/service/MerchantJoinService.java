package com.scau.hyskjf.service;

import com.scau.hyskjf.pojo.Merchant;
import com.scau.hyskjf.pojo.Merchantinfo;
import com.scau.hyskjf.pojo.MerchantinfoWithBLOBs;

public interface MerchantJoinService {
    Integer developJoin(MerchantinfoWithBLOBs merchantinfoWithBLOBs, Merchant merchant);

    Integer independentJoin(MerchantinfoWithBLOBs merchantinfoWithBLOBs, Merchant merchant);
}
