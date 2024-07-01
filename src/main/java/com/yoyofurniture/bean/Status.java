package com.yoyofurniture.bean;

public enum Status {
    PENDING("PENDING"),
    UNAPPROVED("UNAPPROVED"),
    APPROVED("APPROVED"),
    PREPARING("PREPARING"),
    WORK_DONE("WORK_DONE"),
    CLOSED("CLOSED");

    private final String status;

    Status(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
    
    public static String[] getAllStatuses() {
        Status[] statuses = Status.values();
        String[] statusArray = new String[statuses.length];
        for (int i = 0; i < statuses.length; i++) {
            statusArray[i] = statuses[i].getStatus();
        }
        return statusArray;
    }
}
