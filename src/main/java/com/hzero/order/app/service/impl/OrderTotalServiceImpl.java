package com.hzero.order.app.service.impl;

import com.hzero.order.api.dto.OrderDTO;
import com.hzero.order.api.dto.ViewOrderDTO;
import com.hzero.order.app.service.OrderTotalService;
import com.hzero.order.infra.mapper.SoHeaderMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author fei.nie@hand-china.com
 */
@Service
public class OrderTotalServiceImpl implements OrderTotalService {

    private final SoHeaderMapper soHeaderMapper;

    public OrderTotalServiceImpl(SoHeaderMapper soHeaderMapper) {
        this.soHeaderMapper = soHeaderMapper;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public List<ViewOrderDTO> selectOrders(OrderDTO orderDTO) {
        System.out.println("-------------进入查询----------------");
        return soHeaderMapper.selectOrders(orderDTO);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void importOrders() {

    }


}
