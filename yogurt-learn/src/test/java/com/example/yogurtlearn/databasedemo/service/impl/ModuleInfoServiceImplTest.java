package com.example.yogurtlearn.databasedemo.service.impl;

import com.example.yogurtlearn.BaseTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;


class ModuleInfoServiceImplTest extends BaseTest {
    @Autowired
    public ModuleInfoServiceImpl moduleInfoService;

    @Test
    public void Test(){
        System.out.println(moduleInfoService.demoModuleInfo(1));
    }

}