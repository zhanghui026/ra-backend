package com.zh.raback.domain;

/**
 * The CurrentStateEnum enumeration.
 */
public enum CurrentStateEnum {
    TO_BE_FILED("待归档"), ART_GALLERY("艺术馆"), WAREHOUSE("仓库"), EXHIBITION("展览"), LEASING("租赁"), GIFT("赠与"), SALE("卖出"), DAMAGE_REPAIR("损坏修理"),
    PRIVATE_COLLECT("私人收藏"), EN_ROUTE("在途中"), LOSS("丢失"),OTHER_STATUS("其他状态");

    public String getDesc() {
        return desc;
    }

    private String desc;

    CurrentStateEnum(String desc){
        this.desc = desc;
    }



}
