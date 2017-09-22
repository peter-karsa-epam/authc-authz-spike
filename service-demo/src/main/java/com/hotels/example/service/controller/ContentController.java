package com.hotels.example.service.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.hotels.example.service.model.rest.result.RestResult;

@RestController
@RequestMapping("/service")
public class ContentController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ContentController.class);

    @RequestMapping(path = "/add/{first}/{second}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<RestResult> add(@PathVariable("first") final double first,
            @PathVariable("second") final double second) {
        LOGGER.info(String.format("First: %s, second: %s", first, second));
        RestResult result = new RestResult();
        result.setValue(first + second);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
