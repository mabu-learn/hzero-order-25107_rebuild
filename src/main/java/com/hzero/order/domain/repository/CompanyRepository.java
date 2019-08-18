package com.hzero.order.domain.repository;

import com.hzero.order.domain.entity.Company;
import io.choerodon.core.domain.Page;
import io.choerodon.mybatis.pagehelper.domain.PageRequest;
import org.hzero.mybatis.base.BaseRepository;

/**
 * @author fei.nie@hand-china.com
 */
public interface CompanyRepository extends BaseRepository<Company> {

    /**
     * 根据公司ID获取公司名称
     * @param companyName
     * @return
     */
    Long getCompanyId(String companyName);

}
