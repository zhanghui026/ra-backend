package com.zh.raback.web.rest;

import com.zh.raback.service.mock.ArtMockService;
import com.zh.raback.service.mock.MockService;
import liquibase.pro.packaged.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MockResource {

    @Autowired
    private MockService mockService;

    @Autowired
    private ArtMockService artMockService;

    @PostMapping("/mockData")
    public void initData(){
        mockService.init();
    }


    @PostMapping("/artmockData")
    public void initArt(){
        artMockService.mockArtist();
        artMockService.mockPainting();
    }


}
