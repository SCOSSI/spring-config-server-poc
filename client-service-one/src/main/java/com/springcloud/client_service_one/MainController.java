package com.springcloud.client_service_one;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
@RequestMapping("/api")
public class MainController {
    @Value("${hello.world}")
    String applicationValue;

    @Value("${client.service}")
    String clientServiceValue;

    @GetMapping
    public String getServiceMessage() {
        return applicationValue + "," + clientServiceValue + " is working!" ;
    }
}
