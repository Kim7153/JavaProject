package com.example.kaoshi;

import com.example.kaoshi.mapper.KaoShiMapper;
import com.example.kaoshi.pojo.KaoShi;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class KaoshiApplicationTests {
    @Autowired
    KaoShiMapper kaoShiMapper;

    @Test
    void contextLoads() {
        List<KaoShi> kaoShis = kaoShiMapper.queryAll();
        for (KaoShi kaoShi : kaoShis) {
            System.out.println(kaoShi);
        }
    }

}
