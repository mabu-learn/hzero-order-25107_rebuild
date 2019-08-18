package com.hzero.order.domain.entity;

import io.choerodon.mybatis.annotation.ModifyAudit;
import io.choerodon.mybatis.annotation.VersionAudit;
import io.choerodon.mybatis.domain.AuditDomain;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;

/**
 * @author fei.nie@hand-china.com
 */
@ApiModel("销售订单行信息")
@ModifyAudit
@VersionAudit
@Table(name = "hodr_so_line")
public class SoLine extends AuditDomain {
    @Id
    @GeneratedValue
    @Length(max = 20)
    private Long soLineId;
    @NotBlank
    @Length(max = 20)
    @ApiModelProperty("订单头ID")
    private Long soHeaderId;
    @NotBlank
    @Length(max = 10)
    @ApiModelProperty("行号")
    private Long lineNumber;
    @NotBlank
    @Length(max = 20)
    @ApiModelProperty("产品ID")
    private Long itemId;
    @NotBlank
    @Length(max = 27)
    @ApiModelProperty("数量")
    private BigDecimal orderQuantity;
    @NotBlank
    @Length(max = 60)
    @ApiModelProperty("产品单位")
    private String orderQuantityUom;
    @NotBlank
    @Length(max = 31)
    @ApiModelProperty("销售单价")
    private BigDecimal unitSellingPrice;
    @Length(max = 240)
    @ApiModelProperty("备注")
    private String description;
    @Length(max = 150)
    @ApiModelProperty("附加信息1")
    private String addition1;
    @Length(max = 150)
    @ApiModelProperty("附加信息2")
    private String addition2;
    @Length(max = 150)
    @ApiModelProperty("附加信息3")
    private String addition3;
    @Length(max = 150)
    @ApiModelProperty("附加信息4")
    private String addition4;
    @Length(max = 150)
    @ApiModelProperty("附加信息5")
    private String addition5;

    public Long getSoLineId() {
        return soLineId;
    }

    public void setSoLineId(Long soLineId) {
        this.soLineId = soLineId;
    }

    public Long getSoHeaderId() {
        return soHeaderId;
    }

    public void setSoHeaderId(Long soHeaderId) {
        this.soHeaderId = soHeaderId;
    }

    public Long getLineNumber() {
        return lineNumber;
    }

    public void setLineNumber(Long lineNumber) {
        this.lineNumber = lineNumber;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public BigDecimal getOrderQuantity() {
        return orderQuantity;
    }

    public void setOrderQuantity(BigDecimal orderQuantity) {
        this.orderQuantity = orderQuantity;
    }

    public String getOrderQuantityUom() {
        return orderQuantityUom;
    }

    public void setOrderQuantityUom(String orderQuantityUom) {
        this.orderQuantityUom = orderQuantityUom;
    }

    public BigDecimal getUnitSellingPrice() {
        return unitSellingPrice;
    }

    public void setUnitSellingPrice(BigDecimal unitSellingPrice) {
        this.unitSellingPrice = unitSellingPrice;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAddition1() {
        return addition1;
    }

    public void setAddition1(String addition1) {
        this.addition1 = addition1;
    }

    public String getAddition2() {
        return addition2;
    }

    public void setAddition2(String addition2) {
        this.addition2 = addition2;
    }

    public String getAddition3() {
        return addition3;
    }

    public void setAddition3(String addition3) {
        this.addition3 = addition3;
    }

    public String getAddition4() {
        return addition4;
    }

    public void setAddition4(String addition4) {
        this.addition4 = addition4;
    }

    public String getAddition5() {
        return addition5;
    }

    public void setAddition5(String addition5) {
        this.addition5 = addition5;
    }
}
