package com.example.kaoshi.mapper;

import com.example.kaoshi.pojo.KaoShi;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author LYL
 * @create 2021/7/28 8:45
 */
@Mapper
@Component
public interface KaoShiMapper {
    //查询所有
    List<KaoShi> queryAll();
}
