package com.zh.raback.domain;

/**
 * 油画的分类枚举
 *
 *
 */
public enum CategoryEnum {

    Character("人物"),Landscape("风景"),OBJECT("静物"),OTHER("其他");

    private String desc;

    CategoryEnum(String desc){
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
