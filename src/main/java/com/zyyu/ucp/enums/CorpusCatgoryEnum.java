package com.zyyu.ucp.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 语料种类
 */
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum CorpusCatgoryEnum {
    /**字词*/
    WORD(0,"字词"),
    /**短句*/
    SHORT_SENTENCE(1,"短句"),
    /**古诗词*/
    ANCIENT_POETRY(2,"古诗词"),
    /**成语*/
    IDIOM(3,"成语"),
    /**名人名言*/
    FAMOUS_QUOTES(4,"名人名言"),
    /**俗语*/
    POPULAR_SAYING(5,"俗语");

    private int code;

    private String otherName;

    CorpusCatgoryEnum(int code,String otherName){
          this.code = code;
          this.otherName = otherName;
    }
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getOtherName() {
        return otherName;
    }

    public void setOtherName(String otherName) {
        this.otherName = otherName;
    }

    @JsonCreator
    public static CorpusCatgoryEnum valueOf(Integer index){
        CorpusCatgoryEnum[] values= CorpusCatgoryEnum.values();
        for(CorpusCatgoryEnum corpusCatgoryEnum :values){
            if(Integer.valueOf(corpusCatgoryEnum.ordinal()).equals(index)){
                return corpusCatgoryEnum;
            }
        }
        return null;
    }
}
