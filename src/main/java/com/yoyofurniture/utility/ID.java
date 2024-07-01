package com.yoyofurniture.utility;

public enum ID {
    OFFICER_ID(0),
    SALESPERSON_ID(1),
    SALESORDER_ID(2),
    CUSTOMER_ID(3);

    private final int index;

    ID(int index) {
        this.index = index;
    }

    public int getIndex() {
        return index;
    }
}
