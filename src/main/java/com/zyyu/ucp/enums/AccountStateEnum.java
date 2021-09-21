package com.zyyu.ucp.enums;

import com.fasterxml.jackson.annotation.JsonCreator;

/**
 * 用户状态
 */
public enum AccountStateEnum {
    /**禁用*/
    FORBIDDEN,
    /**正常*/
    NORMAL;

    @JsonCreator
    public static AccountStateEnum valueOf(Integer index){
        AccountStateEnum[] values= AccountStateEnum.values();
        for(AccountStateEnum accountStateEnum :values){
            if(Integer.valueOf(accountStateEnum.ordinal()).equals(index)){
                return accountStateEnum;
            }
        }
        return null;
    }
}
