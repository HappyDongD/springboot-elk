package com.springboot.study.common.config;

public enum SexEnum {
    MALE(1, "男"), FEMAL(0, "女");
    private int id;
    private String name;

    public static SexEnum getEnumByid(int id) {
        for (SexEnum value : SexEnum.values()) {
            if (value.getId() == id) {
                return value;
            }
        }
        return null;
    }

    private SexEnum(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}