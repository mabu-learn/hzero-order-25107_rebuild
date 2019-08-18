package com.hzero.order.app.service.impl;

import com.hzero.order.api.dto.ViewLineDTO;
import com.hzero.order.api.dto.ViewOrderDTO;
import com.hzero.order.app.service.OrderDetailService;
import com.hzero.order.domain.entity.*;
import com.hzero.order.domain.repository.*;
import io.choerodon.core.exception.CommonException;
import io.choerodon.mybatis.pagehelper.domain.PageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author fei.nie@hand-china.com
 */
@Service
public class OrderDetailServiceImpl implements OrderDetailService {
    @Autowired
    private CompanyRepository companyRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private ItemRepository itemRepository;
    @Autowired
    private SoHeaderRepository soHeaderRepository;
    @Autowired
    private SoLineRepository soLineRepository;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public List queryOrderAndLine(String orderNumber,PageRequest pageRequest) {
        SoHeader soHeader = soHeaderRepository.selectOneOrder(orderNumber);
        SoLine soLine = new SoLine();
        soLine.setSoLineId(soHeader.getSoHeaderId());
        List<SoLine> soLineList = soLineRepository.selectPageLines(soLine,pageRequest);
        List list = new ArrayList();
        list.add(soHeader);
        list.add(soLineList);
        return list;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void createOneOrder(ViewOrderDTO viewOrderDTO, List<ViewLineDTO> viewLineDTOList) {
        // 判断该订单是否存在
        SoHeader exist = new SoHeader();
        exist.setOrderNumber(viewOrderDTO.getOrderNumber());
        if (soHeaderRepository.select(exist).size() > 0) {
            // 订单存在
            throw new CommonException("该订单已存在");
        }

        // 插入订单头信息
        SoHeader soHeader = new SoHeader();
        soHeader.setOrderNumber(viewOrderDTO.getOrderNumber());
        soHeader.setCompanyId(companyRepository.getCompanyId(viewOrderDTO.getCompanyName()));
        soHeader.setCustomerId(customerRepository.getCustomerId(viewOrderDTO.getCustomerName()));
        soHeader.setOrderDate(viewOrderDTO.getOrderDate());
        soHeader.setOrderStatus(viewOrderDTO.getOrderStatus());
        soHeaderRepository.insert(soHeader);

        //插入订单行信息
        Long soHeaderId = soHeaderRepository.selectOne(soHeader).getSoHeaderId();
        for (ViewLineDTO viewLineDTO : viewLineDTOList) {
            SoLine soLine = new SoLine();
            soLine.setSoHeaderId(soHeaderId);
            soLine.setLineNumber(viewLineDTO.getLineNumber());
            soLine.setItemId(itemRepository.getItemId(viewLineDTO.getItemCode()));
            soLine.setOrderQuantity(viewOrderDTO.getOrderQuantity());
            soLine.setOrderQuantityUom(viewOrderDTO.getOrderQuantityUom());
            soLine.setUnitSellingPrice(viewLineDTO.getUnitSellingPrice());
            soLine.setDescription(viewLineDTO.getDescription());
            soLine.setAddition1(viewLineDTO.getAddition1());
            soLine.setAddition2(viewLineDTO.getAddition2());
            soLine.setAddition3(viewLineDTO.getAddition3());
            soLine.setAddition4(viewLineDTO.getAddition4());
            soLine.setAddition5(viewLineDTO.getAddition5());
            soLineRepository.insert(soLine);
        }
    }

    @Override
    public void updateOneOrder(Long soHeaderId, ViewOrderDTO viewOrderDTO, List<ViewLineDTO> viewLineDTOList) {
        // 更新订单头信息
        SoHeader soHeader = new SoHeader();
        soHeader.setSoHeaderId(soHeaderId);
        soHeader.setOrderNumber(viewOrderDTO.getOrderNumber());
        soHeader.setCompanyId(companyRepository.getCompanyId(viewOrderDTO.getCompanyName()));
        soHeader.setCustomerId(customerRepository.getCustomerId(viewOrderDTO.getCustomerName()));
        soHeader.setOrderDate(viewOrderDTO.getOrderDate());
        soHeader.setOrderStatus(viewOrderDTO.getOrderStatus());
        soHeaderRepository.updateByPrimaryKey(soHeader);

        // 更新订单行信息
        for (ViewLineDTO viewLineDTO : viewLineDTOList) {
            SoLine soLine = new SoLine();
            soLine.setSoHeaderId(soHeaderId);
            soLine.setLineNumber(viewLineDTO.getLineNumber());
            soLine.setSoLineId(soLineRepository.selectOne(soLine).getSoLineId());
            soLine.setItemId(itemRepository.getItemId(viewLineDTO.getItemCode()));
            soLine.setOrderQuantity(viewOrderDTO.getOrderQuantity());
            soLine.setOrderQuantityUom(viewOrderDTO.getOrderQuantityUom());
            soLine.setUnitSellingPrice(viewLineDTO.getUnitSellingPrice());
            soLine.setDescription(viewLineDTO.getDescription());
            soLine.setAddition1(viewLineDTO.getAddition1());
            soLine.setAddition2(viewLineDTO.getAddition2());
            soLine.setAddition3(viewLineDTO.getAddition3());
            soLine.setAddition4(viewLineDTO.getAddition4());
            soLine.setAddition5(viewLineDTO.getAddition5());
            soLineRepository.updateByPrimaryKey(soLine);
        }

    }
}
