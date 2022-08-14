package com.lyy.emp.controller;

import cn.dsna.util.images.ValidateCode;
import com.sun.net.httpserver.HttpsServer;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "CreateCodeController", value = "/CreateCodeController")
public class CreateCodeController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ValidateCode validateCode = new ValidateCode(200,30,4,20);
        String code =  validateCode.getCode();
        HttpSession session = request.getSession();
        session.setAttribute("code",code);

        validateCode.write(response.getOutputStream());
    }
}
