package com.hzero.order;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import io.choerodon.resource.annoation.EnableChoerodonResourceServer;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author 聂飞
 */
@EnableChoerodonResourceServer
@EnableDiscoveryClient
@SpringBootApplication
public class HzeroOrder25107Application {

    public static void main(String[] args) {
        SpringApplication.run(HzeroOrder25107Application.class, args);
    }
}


