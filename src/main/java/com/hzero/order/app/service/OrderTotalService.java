package com.hzero.order.app.service;

import com.hzero.order.api.dto.OrderDTO;
import com.hzero.order.api.dto.ViewOrderDTO;

import java.util.List;

/**
 * @author fei.nie@hand-china.com
 */
public interface OrderTotalService {

    /**
     * 根据选定的查询条件查询相关的订单信息
     * @param orderDTO
     * @return
     */
    List<ViewOrderDTO> selectOrders(OrderDTO orderDTO);

    /**
     * 导入订单数据
     */
    void importOrders();
}
