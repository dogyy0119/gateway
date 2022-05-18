package com.chinamobile.ln.cloud.gis.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 云GIS控制台网关springboot启动类
 * @author: HuangFu
 * @date: 2020/4/7
 **/
@EnableDiscoveryClient
@SpringBootApplication
public class CloudGisGatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(CloudGisGatewayApplication.class, args);
    }
}
