package com.example.kaoshi.controller;

import com.example.kaoshi.mapper.KaoShiMapper;
import com.example.kaoshi.pojo.KaoShi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author LYL
 * @create 2021/7/28 9:11
 */
@RestController
@CrossOrigin
public class KaoShiController {
    @Autowired
    KaoShiMapper kaoShiMapper;
    @RequestMapping("/queryAll")
    public List<KaoShi> queryAll(){
        return kaoShiMapper.queryAll();
    }

}
