package com.situ.web.test;

import com.situ.web.util.MD5Util;

public class MD5Demo {

    public static void main(String[] args) {
        // 202CB962AC59075B964B07152D234B70
        String salt = "situ";
        String password = "123";
        password = MD5Util.MD5Encode(password + salt);
        System.out.println(MD5Util.MD5Encode("123"));;
    }
}
