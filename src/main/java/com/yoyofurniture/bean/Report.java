package com.yoyofurniture.bean;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Report {
    private SaleOrder[] saleOrders;
    private LocalDateTime reportDateTime;
    private double revenue;

    public Report(SaleOrder[] saleOrders, LocalDateTime reportDateTime) {
        this.saleOrders = saleOrders;
        this.reportDateTime = reportDateTime;
        this.revenue = new ArrayList<>(List.of(saleOrders)).stream().mapToDouble(SaleOrder::getTotal).sum();
    }
}
