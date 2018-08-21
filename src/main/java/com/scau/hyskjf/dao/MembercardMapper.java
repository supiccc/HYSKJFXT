package com.scau.hyskjf.dao;

import com.scau.hyskjf.pojo.Membercard;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
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

//    @Select("select * from MemberCard where memID = #{memid}")
    List selectByMember(Integer memid);

    List<Membercard> queryAllCard(Integer merid);

    Membercard queryCardByMcid(String mcid);

    void updateMoneyByCarId(@Param("cardId") String cardId,@Param("money") float money);

    Membercard selectByCardId(String cardId);

    Membercard queryCardByMcidAndMerId(@Param("mcid") String mcid, @Param("merid") Integer merid);
}