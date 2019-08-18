package com.hzero.order.api.controller.v1;

import com.hzero.order.api.dto.OrderDTO;
import com.hzero.order.api.dto.ViewOrderDTO;
import com.hzero.order.app.service.OrderTotalService;
import com.hzero.order.config.SwaggerTags;
import com.hzero.order.domain.entity.Company;
import com.hzero.order.domain.entity.Customer;
import com.hzero.order.domain.entity.Item;
import com.hzero.order.domain.repository.CompanyRepository;
import com.hzero.order.domain.repository.CustomerRepository;
import com.hzero.order.domain.repository.ItemRepository;
import io.choerodon.core.iam.ResourceLevel;
import io.choerodon.mybatis.pagehelper.domain.PageRequest;
import io.choerodon.swagger.annotation.Permission;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.hzero.core.base.BaseController;
import org.hzero.core.util.Results;
import org.hzero.export.annotation.ExcelExport;
import org.hzero.export.vo.ExportParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author fei.nie@hand-china.com
 */
@Api(tags = SwaggerTags.ORDERTOTAL)
@RestController("orderTotalController.v1")
@RequestMapping("/v1/orders-total")
public class OrderTotalController extends BaseController {
    @Autowired
    private CompanyRepository companyRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private ItemRepository itemRepository;
    @Autowired
    private OrderTotalService orderTotalService;

    @Permission(level = ResourceLevel.SITE)
    @ApiOperation(value = "根据多条件查询订单信息")
    @GetMapping("/{organizationId}/query-orders")
    public ResponseEntity<List<ViewOrderDTO>> queryOrders(@PathVariable("organizationId") Long tenantId, OrderDTO orderDTO) {
        return Results.success(orderTotalService.selectOrders(orderDTO));
    }

    @Permission(level = ResourceLevel.SITE)
    @ApiOperation(value = "分页查询公司信息")
    @GetMapping("/{organizationId}/page-company")
    public ResponseEntity<List<Company>> pageCompany(@PathVariable("organizationId") Long tenantId, PageRequest pageRequest, Company company) {
        return Results.success(companyRepository.pageAndSort(pageRequest,company));
    }

    @Permission(level = ResourceLevel.SITE)
    @ApiOperation(value = "分页查询客户信息")
    @GetMapping("/{organizationId}/page-customer")
    public ResponseEntity<List<Customer>> pageCustomer(@PathVariable("organizationId") Long tenantId, PageRequest pageRequest, Customer customer) {
        return Results.success(customerRepository.pageAndSort(pageRequest, customer));
    }

    @Permission(level = ResourceLevel.SITE)
    @ApiOperation(value = "分页查询物料信息")
    @GetMapping("/{organizationId}/page-item")
    public ResponseEntity<List<Item>> pageItem(@PathVariable("organizationId") Long tenantId, PageRequest pageRequest, Item item) {
        return Results.success(itemRepository.pageAndSort(pageRequest, item));
    }

    @Permission(level = ResourceLevel.SITE)
    @ApiOperation(value = "导出订单数据")
    @GetMapping("/{organizationId}/export-orders")
    @ExcelExport(ViewOrderDTO.class)
    public ResponseEntity<List<ViewOrderDTO>> exportOrders(@PathVariable("organizationId") Long tenantId, OrderDTO orderDTO, ExportParam exportParam, HttpServletResponse response) {
        return Results.success(orderTotalService.selectOrders(orderDTO));
    }

}
