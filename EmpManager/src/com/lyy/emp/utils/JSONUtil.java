package com.lyy.emp.utils;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JSONUtil {

    private JSONUtil() {

    }

    public static void toJSON(HttpServletResponse resp, Object obj) {
        try {
            resp.setContentType("text/html;charset=utf-8");
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.writeValue(resp.getWriter(), obj);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
