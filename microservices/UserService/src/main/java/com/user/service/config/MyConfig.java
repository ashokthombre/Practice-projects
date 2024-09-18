package com.user.service.config;

import com.user.service.config.interceptor.RestTemplateInterceptor;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Configuration

public class MyConfig {


    @Bean
    @LoadBalanced
    public RestTemplate restTemplate()
    {
        RestTemplate restTemplate=new RestTemplate();

        List<ClientHttpRequestInterceptor> interceptors=new ArrayList<>();
        interceptors.add(new RestTemplateInterceptor());

        restTemplate.setInterceptors(interceptors);


        return restTemplate;
    }

}
