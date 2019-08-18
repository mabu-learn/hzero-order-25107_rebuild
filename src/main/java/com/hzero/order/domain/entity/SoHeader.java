package com.hzero.order.domain.entity;

import io.choerodon.mybatis.annotation.ModifyAudit;
import io.choerodon.mybatis.annotation.VersionAudit;
import io.choerodon.mybatis.domain.AuditDomain;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;

/**
 * @author fei.nie@hand-china.com
 */
@ApiModel("销售订单头信息")
@ModifyAudit
@VersionAudit
@Table(name = "hodr_so_header")
public class SoHeader extends AuditDomain {
    @Id
    @GeneratedValue
    @Length(max = 20)
    private Long soHeaderId;
    @NotBlank
    @Length(max = 60)
    @ApiModelProperty("订单编号")
    private String orderNumber;
    @NotBlank
    @Length(max = 60)
    @ApiModelProperty("公司ID")
    private Long companyId;
    @NotBlank
    @Length(max = 20)
    @ApiModelProperty("订单日期")
    private Date orderDate;
    @NotBlank
    @Length(max = 30)
    @ApiModelProperty("订单状态")
    private String orderStatus;
    @NotBlank
    @Length(max = 20)
    @ApiModelProperty("客户ID")
    private Long customerId;

    public Long getSoHeaderId() {
        return soHeaderId;
    }

    public void setSoHeaderId(Long soHeaderId) {
        this.soHeaderId = soHeaderId;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }
}
