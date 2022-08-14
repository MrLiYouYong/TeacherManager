package com.situ.web.filter;

import com.situ.web.pojo.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "login", urlPatterns = "/*")
public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("LoginFilter.init");
    }

    // HttpServletRequest extends ServletRequest
    // ServletRequest servletRequest = new HttpServletRequest();
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("LoginFilter.doFilter");
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String servletPath = request.getServletPath();
        System.out.println(servletPath);
        String method = request.getParameter("method");
        // 这些操作本身就是要去完成登录流程的，不需要执行后面是否登录的验证流程
        if (servletPath.endsWith(".js")
                || servletPath.endsWith(".png")
                || servletPath.endsWith(".jpg")
                || servletPath.endsWith(".css")
                || servletPath.equals("/login.jsp")
                || servletPath.equals("/verifyCode")
                || (servletPath.equals("/user") && method.equals("login"))
                || (servletPath.equals("/user") && method.equals("register"))) {
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if (user == null) {
            // Cannot forward after response has been committed
            response.sendRedirect(request.getContextPath() + "/login.jsp");
            return;
        }

        filterChain.doFilter(servletRequest, servletResponse);

    }

    @Override
    public void destroy() {
        System.out.println("LoginFilter.destroy");
    }
}
