package com.hzero.order.domain.repository;

import com.hzero.order.domain.entity.Customer;
import io.choerodon.core.domain.Page;
import io.choerodon.mybatis.pagehelper.domain.PageRequest;
import org.hzero.mybatis.base.BaseRepository;

/**
 * @author fei.nie@hand-china.com
 */
public interface CustomerRepository extends BaseRepository<Customer> {
    /**
     * 根据客户名称得到客户ID
     * @param customerName
     * @return
     */
    Long getCustomerId(String customerName);

}
