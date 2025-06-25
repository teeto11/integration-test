package com.example.teeto_integration_test.configuration;

import com.example.teeto_integration_test.service.PostService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ApplicationConfiguration {

    @Value("${base.url}")
    private String baseUrl;

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public PostService postService(RestTemplate restTemplate) {
        return new PostService(restTemplate, baseUrl);
    }
}
