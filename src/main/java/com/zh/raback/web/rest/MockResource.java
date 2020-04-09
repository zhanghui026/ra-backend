package com.zh.raback.web.rest;

import com.zh.raback.service.MockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MockResource {

    @Autowired
    private MockService mockService;

    @PostMapping("/mockData")
    public void initData(){
        mockService.init();
    }
}
