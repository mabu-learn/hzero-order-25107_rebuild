package com.hzero.order.infra.repository.impl;

import com.hzero.order.domain.entity.SoHeader;
import com.hzero.order.domain.repository.SoHeaderRepository;
import org.hzero.mybatis.base.impl.BaseRepositoryImpl;
import org.springframework.stereotype.Repository;

/**
 * @author fei.nie@hand-china.com
 */
@Repository
public class SoHeaderRepositoryImpl extends BaseRepositoryImpl<SoHeader> implements SoHeaderRepository {
    @Override
    public SoHeader selectOneOrder(String orderNumber) {
        SoHeader soHeader = new SoHeader();
        soHeader.setOrderNumber(orderNumber);
        return new SoHeaderRepositoryImpl().selectOne(soHeader);
    }

    @Override
    public Long getSoHeaderId(String orderNumber) {
        SoHeader soHeader = new SoHeader();
        soHeader.setOrderNumber(orderNumber);
        return this.selectOne(soHeader).getSoHeaderId();
    }

}
