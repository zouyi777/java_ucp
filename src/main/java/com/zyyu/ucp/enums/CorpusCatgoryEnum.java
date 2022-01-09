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
    POETRY(2,"诗词"),
    /**成语*/
    IDIOM(3,"成语"),
    /**名人名言*/
    FAMOUS_QUOTES(4,"名人名言"),
    /**俗语*/
    POPULAR_SAYING(5,"俗语"),
    /**歌词*/
    LYRIC(6,"歌词");

    private Integer code;

    private String otherName;

    CorpusCatgoryEnum(Integer code, String otherName){
          this.code = code;
          this.otherName = otherName;
    }
    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getOtherName() {
        return otherName;
    }

    public void setOtherName(String otherName) {
        this.otherName = otherName;
    }

    @JsonCreator
    public static CorpusCatgoryEnum valueOf(Integer code){
        CorpusCatgoryEnum[] values= CorpusCatgoryEnum.values();
        for(CorpusCatgoryEnum corpusCatgoryEnum :values){
            if(corpusCatgoryEnum.getCode().equals(code)){
                return corpusCatgoryEnum;
            }
        }
        return null;
    }
}
