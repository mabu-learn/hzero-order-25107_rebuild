package com.hzero.order.infra.mapper;

import com.hzero.order.api.dto.OrderDTO;
import com.hzero.order.api.dto.ViewOrderDTO;
import com.hzero.order.domain.entity.SoHeader;
import io.choerodon.mybatis.common.BaseMapper;

import java.util.List;

/**
 * @author fei.nie@hand-china.com
 */
public interface SoHeaderMapper extends BaseMapper<SoHeader> {
    /**
     * 基于查询公司、客户、销售订单号、物料、订单状态查询销售订单数据
     * @param orderDTO
     * @return
     */
    List<ViewOrderDTO> selectOrders(OrderDTO orderDTO);
}
