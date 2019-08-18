package com.hzero.order.api.controller.v1;

import com.hzero.order.api.dto.ViewLineDTO;
import com.hzero.order.api.dto.ViewOrderDTO;
import com.hzero.order.app.service.OrderDetailService;
import com.hzero.order.config.SwaggerTags;
import com.hzero.order.domain.repository.SoHeaderRepository;
import io.choerodon.core.iam.ResourceLevel;
import io.choerodon.mybatis.pagehelper.domain.PageRequest;
import io.choerodon.swagger.annotation.Permission;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.hzero.core.base.BaseController;
import org.hzero.core.util.Results;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author fei.nie@hand-china.com
 */
@Api(tags = SwaggerTags.ORDERDETAIL)
@RestController("orderDetailController.v1")
@RequestMapping("/v1/orders-detail")
public class OrderDetailController extends BaseController {
    @Autowired
    private OrderDetailService orderDetailService;
    @Autowired
    private SoHeaderRepository soHeaderRepository;

    @Permission(level = ResourceLevel.SITE)
    @ApiOperation(value = "查看单个订单的详细信息")
    @GetMapping("/{organizationId}/query-order-and-line")
    public ResponseEntity queryOrderAndLine(@PathVariable("organizationId") Long tenantId, String orderNumber, PageRequest pageRequest) {
        return Results.success(orderDetailService.queryOrderAndLine(orderNumber, pageRequest));
    }

    @Permission(level = ResourceLevel.SITE)
    @ApiOperation(value = "新增一条订单头信息及其相关行信息")
    @GetMapping("/{organizationId}/create-one-order")
    public ResponseEntity createOneOrder(@PathVariable("organizationId") Long tenantId, @RequestBody ViewOrderDTO viewOrderDTO,@RequestBody List<ViewLineDTO> viewLineDTOList) {
        orderDetailService.createOneOrder(viewOrderDTO, viewLineDTOList);
        return Results.success();
    }

    @Permission(level = ResourceLevel.SITE)
    @ApiOperation(value = "修改一条订单头信息及其相关行信息")
    @GetMapping("/{organizationId}/update-one-order")
    public ResponseEntity updateOneOrder(@PathVariable("organizationId") Long tenantId, Long soHeaderId, @RequestBody ViewOrderDTO viewOrderDTO,@RequestBody List<ViewLineDTO> viewLineDTOList) {
        orderDetailService.updateOneOrder(soHeaderId, viewOrderDTO, viewLineDTOList);
        return Results.success();
    }

}
