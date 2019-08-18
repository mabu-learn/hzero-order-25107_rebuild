package com.hzero.order.infra.repository.impl;

import com.hzero.order.domain.entity.Customer;
import com.hzero.order.domain.repository.CustomerRepository;
import io.choerodon.core.domain.Page;
import io.choerodon.mybatis.pagehelper.PageHelper;
import io.choerodon.mybatis.pagehelper.domain.PageRequest;
import org.hzero.mybatis.base.impl.BaseRepositoryImpl;
import org.springframework.stereotype.Repository;

/**
 * @author fei.nie@hand-china.com
 */
@Repository
public class CustomerRepositoryImpl extends BaseRepositoryImpl<Customer> implements CustomerRepository {
    @Override
    public Long getCustomerId(String customerName) {
        Customer customer = new Customer();
        customer.setCustomerName(customerName);
        return this.selectOne(customer).getCustomerId();
    }
}
