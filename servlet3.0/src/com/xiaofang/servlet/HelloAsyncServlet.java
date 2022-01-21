package com.xiaofang.servlet;

import jakarta.servlet.AsyncContext;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(value = "/async", asyncSupported = true)
public class HelloAsyncServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        System.out.println("主线程开始..." + Thread.currentThread() + "==>" + System.currentTimeMillis());
        AsyncContext startContext = req.startAsync();

        startContext.start(() -> {
            try {
                System.out.println("副线程开始..." + Thread.currentThread() + "==>" + System.currentTimeMillis());
                sayHello();
                startContext.complete();
                ServletResponse response = startContext.getResponse();
                response.getWriter().write("Hello async...");
                System.out.println("副线程开始..." + Thread.currentThread() + "==>" + System.currentTimeMillis());
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        System.out.println("主线程开始..."+Thread.currentThread()+"==>"+System.currentTimeMillis());
    }

    public void sayHello() throws Exception {
        System.out.println(Thread.currentThread() + " processing...");
        Thread.sleep(3000);

    }
}
