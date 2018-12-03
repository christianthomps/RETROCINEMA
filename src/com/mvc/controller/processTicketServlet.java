package com.mvc.controller;

import javax.servlet.RequestDispatcher;
import java.lang.String;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class processTicketServlet extends HttpServlet {
    public processTicketServlet() {
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        int SeniorTicketNo = Integer.parseInt(String.valueOf(request.getAttribute("seniorTicketNo")));
        int AdultTicketNo = Integer.parseInt(String.valueOf(request.getAttribute("adultTicketNo")));
        int MinorTicketNo = Integer.parseInt(String.valueOf(request.getAttribute("minorTicketNo")));
        String title = String.valueOf(request.getAttribute("title"));
        Bookings booking = (Bookings) request.getAttribute("booking");
        System.out.println(booking);

        int seniorTicketPrice = SeniorTicketNo * 10;
        int adultTicketPrice = AdultTicketNo * 12;
        int minorTicketPrice = MinorTicketNo * 8;
        int totalPrice = seniorTicketPrice + adultTicketPrice + minorTicketPrice;

        //Ticket ticket


        RequestDispatcher rd = request.getRequestDispatcher("orderSummary.jsp");
        rd.forward(request,response);




    }
}