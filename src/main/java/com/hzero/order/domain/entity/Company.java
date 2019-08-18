package com.hzero.order.domain.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.choerodon.mybatis.annotation.ModifyAudit;
import io.choerodon.mybatis.annotation.VersionAudit;
import io.choerodon.mybatis.domain.AuditDomain;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

/**
 * @author fei.nie@hand-china.com
 */
@ApiModel("公司信息")
@ModifyAudit
@VersionAudit
@Table(name = "hodr_company")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Company extends AuditDomain {
    @Id
    @GeneratedValue
    @Length(max = 20)
    private Long companyId;
    @NotBlank
    @Length(max = 60)
    @ApiModelProperty("公司编号")
    private String companyNumber;
    @NotBlank
    @Length(max = 240)
    @ApiModelProperty("公司名称")
    private String companyName;
    @NotBlank
    @Length(max = 1)
    @ApiModelProperty("启用标识")
    private Long enabledFlag;

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public String getCompanyNumber() {
        return companyNumber;
    }

    public void setCompanyNumber(String companyNumber) {
        this.companyNumber = companyNumber;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Long getEnabledFlag() {
        return enabledFlag;
    }

    public void setEnabledFlag(Long enabledFlag) {
        this.enabledFlag = enabledFlag;
    }
}
