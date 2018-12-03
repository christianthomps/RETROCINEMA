package com.mvc.controller;

import javax.servlet.RequestDispatcher;
import java.lang.String;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//C:\Users\Christian\IdeaProjects\TheCinemaProject\src\com\mvc\controller\RegisterServlet.java
public class updateAccountServlet extends HttpServlet {
    public updateAccountServlet() {
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        //Copying all the input parameters in to local variables
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String phonenumber = request.getParameter("phonenumber");
        String address = request.getParameter("street") + "/" + request.getParameter("city") + ", " + request.getParameter("state") + "/" + request.getParameter("zipcode");

        //How to know which user

    }
}