package com.zyyu.ucp.enums;

import com.fasterxml.jackson.annotation.JsonCreator;

/**
 * 语料种类
 */
public enum CorpusCatgoryEnum {
    /**字词*/
    WORD,
    /**短句*/
    SHORT_SENTENCE,
    /**古诗词*/
    ANCIENT_POETRY,
    /**成语*/
    IDIOM,
    /**名人名言*/
    FAMOUS_QUOTES,
    /**俗语*/
    POPULAR_SAYING;

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
