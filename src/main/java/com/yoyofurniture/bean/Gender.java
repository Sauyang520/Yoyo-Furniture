package com.yoyofurniture.bean;

public enum Gender {
    ALL("ALL"),
    MALE("MALE"),
    FEMALE("FEMALE");

    private final String gender;

    Gender(String gender) {
        this.gender = gender;
    }

    public String getGender() {
        return gender;
    }
}
