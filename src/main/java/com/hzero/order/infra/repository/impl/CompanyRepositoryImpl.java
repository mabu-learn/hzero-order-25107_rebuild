package com.hzero.order.infra.repository.impl;

import com.hzero.order.domain.entity.Company;
import com.hzero.order.domain.repository.CompanyRepository;
import io.choerodon.core.domain.Page;
import io.choerodon.mybatis.pagehelper.PageHelper;
import io.choerodon.mybatis.pagehelper.domain.PageRequest;
import org.hzero.mybatis.base.impl.BaseRepositoryImpl;
import org.springframework.stereotype.Repository;

/**
 * @author fei.nie@hand-china.com
 */
@Repository
public class CompanyRepositoryImpl extends BaseRepositoryImpl<Company> implements CompanyRepository {
    @Override
    public Long getCompanyId(String companyName) {
        Company company = new Company();
        company.setCompanyName(companyName);
        return this.selectOne(company).getCompanyId();
    }
}
