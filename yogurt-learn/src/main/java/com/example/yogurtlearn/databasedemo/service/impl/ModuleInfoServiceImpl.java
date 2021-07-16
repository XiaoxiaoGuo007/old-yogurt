package com.example.yogurtlearn.databasedemo.service.impl;

import com.example.yogurtlearn.databasedemo.dao.ModuleInfoMapper;
import com.example.yogurtlearn.databasedemo.entity.ModuleInfo;
import com.example.yogurtlearn.databasedemo.service.ModuleInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ModuleInfoServiceImpl implements ModuleInfoService {

    @Autowired
    private ModuleInfoMapper moduleInfoMapper;

    public ModuleInfo demoModuleInfo(Integer id){
        ModuleInfo byModuleId = moduleInfoMapper.findByModuleId(id);
        return byModuleId;
    }
}
