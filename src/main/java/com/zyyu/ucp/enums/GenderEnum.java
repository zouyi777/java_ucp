package com.zyyu.ucp.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 性别类型枚举
 * @JsonFormat(shape = JsonFormat.Shape.OBJECT) 将枚举序列化成对象，解决JSON格式返回前端的只有name的问题
 */
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum GenderEnum {
    /**男*/
    MAN(10,"男"),
    /**女*/
    FEMALE(11,"女");

    private Integer  index;
    private String otherName;

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public String getOtherName() {
        return otherName;
    }

    public void setOtherName(String otherName) {
        this.otherName = otherName;
    }

    GenderEnum(Integer  index,String otherName){
       this.index = index;
       this.otherName = otherName;
    }

    /**
     * 根据code获取枚举类型
     * @param index
     * 添加@JsonCreator注解：为了解决
     * InvalidFormatException: Cannot deserialize value of type `com.zyyu.ucp.enums.GenderEnum`
     * from number 10: index value outside legal index range [0..1]
     * @return
     */
    @JsonCreator
    public static GenderEnum valueOf(Integer index){
        GenderEnum[] values=GenderEnum.values();
        for(GenderEnum genderEnum:values){
            if(genderEnum.getIndex().equals(index)){
                return genderEnum;
            }
        }
        return null;
    }
}
