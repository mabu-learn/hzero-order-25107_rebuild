package com.hzero.order.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.service.Tag;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * Swagger Api 描述配置
 */
@Configuration
public class SwaggerTags {

    public static final String ORDERTOTAL = "OrderTotal";
    public static final String ORDERDETAIL = "OrderDetail";

    @Autowired
    public SwaggerTags(Docket docket) {
        docket.tags(
                new Tag(ORDERTOTAL, "订单汇总"),
                new Tag(ORDERDETAIL, "订单明细")
        );
    }
}
