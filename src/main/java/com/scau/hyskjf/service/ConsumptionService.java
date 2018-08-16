package com.scau.hyskjf.service;

import com.scau.hyskjf.pojo.CashConsumption;
import com.scau.hyskjf.pojo.CreditConsumption;
import com.scau.hyskjf.pojo.StoreConsumption;

public interface ConsumptionService {
    CreditConsumption creditConsumptionCheck(String mcID ,Float money, String pwd);

    Float creditCompute(CreditConsumption creditConsumption,Integer macID);

    StoreConsumption storeConsumptionCheck(String mcID , Float money, String pwd);

    Float storeCompute(StoreConsumption storeConsumption,Integer macID);

    CashConsumption cashConsumptionCheck(String mcID , Float money);

    Float cashCompute(CashConsumption cashConsumption,Integer macID);
}
