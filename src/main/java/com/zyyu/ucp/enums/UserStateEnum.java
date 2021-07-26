package com.zyyu.ucp.enums;

import com.fasterxml.jackson.annotation.JsonCreator;

/**
 * 用户状态
 */
public enum UserStateEnum {
    /**禁用*/
    FORBIDDEN,
    /**正常*/
    NORMAL;

    @JsonCreator
    public static UserStateEnum valueOf(Integer index){
        UserStateEnum[] values= UserStateEnum.values();
        for(UserStateEnum userStateEnum :values){
            if(Integer.valueOf(userStateEnum.ordinal()).equals(index)){
                return userStateEnum;
            }
        }
        return null;
    }
}
