package com.hotels.example.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.hotels.example.api.model.CalculationRequest;

@Service
public class ContentService {

    private final RestTemplate restTemplate;

    @Autowired
    public ContentService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.setConnectTimeout(1000).build();
    }

    public Double add(final CalculationRequest calcRequest) {
        return this.restTemplate.getForObject("http://localhost:8080/service/add/{firstOperand}/{secondOperand}",
                Double.class, calcRequest.getFirstOperand(), calcRequest.getSecondOperand());
    }
}
