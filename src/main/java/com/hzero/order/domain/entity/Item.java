package com.hzero.order.domain.entity;

import io.choerodon.mybatis.annotation.ModifyAudit;
import io.choerodon.mybatis.annotation.VersionAudit;
import io.choerodon.mybatis.domain.AuditDomain;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Length;
import org.hzero.core.util.Regexs;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.Date;

/**
 * @author fei.nie@hand-china.com
 */
@ApiModel("物料信息")
@ModifyAudit
@VersionAudit
@Table(name = "hodr_item")
public class Item extends AuditDomain {
    @Id
    @GeneratedValue
    @Length(max = 20)
    private Long itemId;
    @NotBlank
    @Length(max = 60)
    @ApiModelProperty("物料编码")
    private String itemCode;
    @NotBlank
    @Length(max = 60)
    @ApiModelProperty("物料单位")
    private String itemUom;
    @NotBlank
    @Length(max = 240)
    @ApiModelProperty("物料描述")
    private String itemDescription;
    @NotBlank
    @Length(max = 1)
    @ApiModelProperty("可销售标识")
    private Long saleableFlag;
    @Pattern(regexp = Regexs.DATE)
    private Date startActiveDate;
    @Pattern(regexp = Regexs.DATE)
    private Date endActiveDate;
    @NotBlank
    @Length(max = 1)
    @ApiModelProperty("启用标识")
    private Long enabledFlag;

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getItemUom() {
        return itemUom;
    }

    public void setItemUom(String itemUom) {
        this.itemUom = itemUom;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public Long getSaleableFlag() {
        return saleableFlag;
    }

    public void setSaleableFlag(Long saleableFlag) {
        this.saleableFlag = saleableFlag;
    }

    public Date getStartActiveDate() {
        return startActiveDate;
    }

    public void setStartActiveDate(Date startActiveDate) {
        this.startActiveDate = startActiveDate;
    }

    public Date getEndActiveDate() {
        return endActiveDate;
    }

    public void setEndActiveDate(Date endActiveDate) {
        this.endActiveDate = endActiveDate;
    }

    public Long getEnabledFlag() {
        return enabledFlag;
    }

    public void setEnabledFlag(Long enabledFlag) {
        this.enabledFlag = enabledFlag;
    }
}
