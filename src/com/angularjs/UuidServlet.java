package com.angularjs;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

public class UuidServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        String contextPath = req.getContextPath();
        if("/getUuid.do".equals(uri.split(contextPath)[1])) {
            String[] uuid = UUID.randomUUID().toString().split("-");
            StringBuffer sb = new StringBuffer();
            for(int i=0;i<uuid.length;i++) {
                sb.append(uuid[i]);
            }
            resp.setCharacterEncoding("utf-8");
            resp.setHeader("Content-Type","json/application;charset=UTF-8");
           String json = "{\"uuid\":\"" + sb.toString() + "\"}";
            resp.getWriter().write(json);
        }else {
            super.doGet(req,resp);
        }
    }
}
