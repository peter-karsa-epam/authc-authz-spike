package com.hotels.example.api.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.hotels.example.api.model.CalculationRequest;
import com.hotels.example.api.model.rest.response.RestResult;

@Service
public class ContentService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ContentService.class);

    private final RestTemplate restTemplate;

    @Autowired
    public ContentService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.setConnectTimeout(1000).build();
    }

    public Double add(final CalculationRequest calcRequest) {
        LOGGER.info(String.format("RestTemplate: %s, CalcRequest: %s", restTemplate, calcRequest));
        return this.restTemplate.getForObject(String.format("http://localhost:8090/service/add/%s/%s",
                calcRequest.getFirstOperand(), calcRequest.getSecondOperand()), RestResult.class).getValue();
    }
}
