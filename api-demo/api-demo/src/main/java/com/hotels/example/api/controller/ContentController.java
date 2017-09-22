package com.hotels.example.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.hotels.example.api.model.CalculationRequest;
import com.hotels.example.api.service.ContentService;

@RestController
public class ContentController {

    @Autowired
    private ContentService contentService;

    @RequestMapping(path = "/add", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Double> add(@RequestBody final CalculationRequest calcRequest) {
        final Double result = contentService.add(calcRequest);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
