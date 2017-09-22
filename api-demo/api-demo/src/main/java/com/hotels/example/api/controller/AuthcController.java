package com.hotels.example.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.hotels.example.api.model.LoginInfo;
import com.hotels.example.api.service.AuthcService;

@RestController
public class AuthcController {

    @Autowired
    private AuthcService authcService;

    @RequestMapping(path = "/login", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Void> login(@RequestBody final LoginInfo loginInfo) {
        authcService.login(loginInfo);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(path = "/logout", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<Void> logout() {
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
