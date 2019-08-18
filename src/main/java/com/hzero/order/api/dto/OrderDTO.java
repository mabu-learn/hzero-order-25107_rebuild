package com.hzero.order.api.dto;

import com.hzero.order.domain.entity.*;

import javax.persistence.Transient;

/**
 * @author fei.nie@hand-china.com
 */

public class OrderDTO {
    @Transient
    private Company company;
    @Transient
    private Customer customer;
    @Transient
    private Item item;
    @Transient
    private SoHeader soHeader;
    @Transient
    private SoLine soLine;

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public SoHeader getSoHeader() {
        return soHeader;
    }

    public void setSoHeader(SoHeader soHeader) {
        this.soHeader = soHeader;
    }

    public SoLine getSoLine() {
        return soLine;
    }

    public void setSoLine(SoLine soLine) {
        this.soLine = soLine;
    }

    @Override
    public String toString() {
        return "OrderDTO{" +
                "销售订单号=" + soHeader.getOrderNumber() +
                ", 公司名称=" + company.getCompanyName() +
                ", 客户名称=" + customer.getCustomerName() +
                ", 订单日期=" + soHeader.getOrderDate() +
                ", 订单状态=" + soHeader.getOrderStatus() +
                ", 订单金额=" + soLine.getUnitSellingPrice() +
                '}';
    }
}
