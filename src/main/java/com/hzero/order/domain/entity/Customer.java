package com.hzero.order.domain.entity;

import io.choerodon.mybatis.annotation.ModifyAudit;
import io.choerodon.mybatis.annotation.VersionAudit;
import io.choerodon.mybatis.domain.AuditDomain;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Length;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

/**
 * @author fei.nie@hand-china.com
 */
@ApiModel("客户信息")
@ModifyAudit
@VersionAudit
@Table(name = "hodr_customer")
public class Customer extends AuditDomain {
    @Id
    @GeneratedValue
    @Length(max = 20)
    private Long customerId;
    @NotBlank
    @Length(max = 60)
    @ApiModelProperty("客户编号")
    private String customerNumber;
    @NotBlank
    @Length(max = 240)
    @ApiModelProperty("客户名称")
    private String customerName;
    @NotBlank
    @Length(max = 20)
    private Long companyId;
    @NotBlank
    @Length(max = 1)
    @ApiModelProperty("启用标识")
    private Long enabledFlag;

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(String customerNumber) {
        this.customerNumber = customerNumber;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public Long getEnabledFlag() {
        return enabledFlag;
    }

    public void setEnabledFlag(Long enabledFlag) {
        this.enabledFlag = enabledFlag;
    }
}
