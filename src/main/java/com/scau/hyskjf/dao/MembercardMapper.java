package com.scau.hyskjf.dao;

import com.scau.hyskjf.pojo.Membercard;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MembercardMapper {
    int deleteByPrimaryKey(Integer mcpkid);

    int insert(Membercard record);

    int insertSelective(Membercard record);

    Membercard selectByPrimaryKey(Integer mcpkid);

    int updateByPrimaryKeySelective(Membercard record);

    int updateByPrimaryKey(Membercard record);

    List<Membercard> queryAllCard(Integer merid);

    Membercard queryCardByMcid(String mcid);

    void updateMoneyByCarId(@Param("cardId") String cardId,@Param("money") float money);
}