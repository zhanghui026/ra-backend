package com.zh.raback.domain;

/**
 * The MaterialEnum enumeration.
 */
public enum MaterialEnum {
    /*亚麻油画布,纯棉油画布,化纤（涤纶）油画布,棉麻（55%麻,45%棉）油画布，其他材质油画布*/
    LINSEED_CANVAS("亚麻油"),
    COTTON_CANVAS("纯棉"),
    CHEMICAL_FIBER_CANVAS("化纤"),
    COTTON_HEMP_CANVAS("棉麻"),
    OTHER_MATERIALS_CANVAS("其他材质");



    private String desc;

    MaterialEnum(String desc){
        this.desc = desc;
    }

}
