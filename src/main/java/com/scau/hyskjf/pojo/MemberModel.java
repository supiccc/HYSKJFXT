package com.scau.hyskjf.pojo;

import java.util.List;

public class MemberModel {
    private List<Integer> memberIDs;

    public MemberModel(List<Integer> memberIDs){
        super();
        this.memberIDs=memberIDs;
    }

    public MemberModel(){
        super();
    }

    public List<Integer> getMemberIDs(){
        return memberIDs;
    }

    public void setMemberIDs(List<Integer> memberIDs){
        this.memberIDs=memberIDs;
    }

}
