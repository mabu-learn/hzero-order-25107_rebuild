package com.hzero.order.domain.repository;

import com.hzero.order.domain.entity.SoHeader;
import com.hzero.order.domain.entity.SoLine;
import io.choerodon.mybatis.pagehelper.domain.PageRequest;
import org.hzero.mybatis.base.BaseRepository;

import java.util.List;

/**
 * @author fei.nie@hand-china.com
 */
public interface SoHeaderRepository extends BaseRepository<SoHeader> {
    /**
     * 根据订单号查询该订单头信息
     * @param orderNumber
     * @return
     */
    SoHeader selectOneOrder(String orderNumber);

    /**
     * 根据订单号查询订单ID
     * @param orderNumber
     * @return
     */
    Long getSoHeaderId(String orderNumber);
}
