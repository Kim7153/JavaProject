package com.kuang.utils;

import org.junit.Test;

import java.util.UUID;

public class IDuitls {
    public static String getId(){
        return UUID.randomUUID().toString().replaceAll("-","");
    }
    @Test
    public void test(){
        System.out.println(getId());
    }
}
