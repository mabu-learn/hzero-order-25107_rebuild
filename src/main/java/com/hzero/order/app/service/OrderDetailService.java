package com.hzero.order.app.service;

import com.hzero.order.api.dto.ViewLineDTO;
import com.hzero.order.api.dto.ViewOrderDTO;
import io.choerodon.mybatis.pagehelper.domain.PageRequest;

import java.util.List;

/**
 * @author fei.nie@hand-china.com
 */
public interface OrderDetailService {
    /**
     * 根据订单号查询订单头信息和订单行信息
     * @param orderNumber
     * @param pageRequest
     * @return
     */
    List queryOrderAndLine(String orderNumber, PageRequest pageRequest);

    /**
     * 新增一条订单及其行信息
     * @param viewOrderDTO
     * @param viewLineDTOList
     */
    void createOneOrder(ViewOrderDTO viewOrderDTO, List<ViewLineDTO> viewLineDTOList);

    /**
     * 修改一条订单及其行信息
     * @param soHeaderId
     * @param viewOrderDTO
     * @param viewLineDTOList
     */
    void updateOneOrder(Long soHeaderId, ViewOrderDTO viewOrderDTO, List<ViewLineDTO> viewLineDTOList);

}
