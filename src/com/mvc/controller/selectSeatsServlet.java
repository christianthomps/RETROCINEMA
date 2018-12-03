package com.mvc.controller;

import java.lang.String;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class selectSeatsServlet extends HttpServlet {
    public selectSeatsServlet() {
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        int SeniorTicketNo = Integer.parseInt(String.valueOf(request.getAttribute("SeniorTicketNo")));
        int AdultTicketNo = Integer.parseInt(String.valueOf(request.getAttribute("AdultTicketNo")));
        int MinorTicketNo = Integer.parseInt(String.valueOf(request.getAttribute("MinorTicketNo")));
        String title = String.valueOf(request.getAttribute("title"));

        HttpSession session=request.getSession();
        String email = String.valueOf(session.getAttribute("email"));
        RegisteredUser user = new RegisteredUser();
        int UID = user.getIDNum(email);


        Showings showTimes = new Showings();
        ArrayList<Showings> showingsList = showTimes.retrieveShowingsForMovie(title);

        int totalTickets = SeniorTicketNo + AdultTicketNo + MinorTicketNo;
        String showTime = String.valueOf(request.getAttribute("showTime"));
        ArrayList<Showings> shows = showTimes.retrieveShowingsForMoviAndTime(title, showTime);

        int SID = shows.get(0).getSID();

        Seat seats = new Seat();
        ArrayList<Seat> allSeats = seats.getAllSeatsForShowing(SID);

        String SeatsHTML = "";
        int i = 0;

        //building HTML radio buttons for selecting seats
        for(Seat s : allSeats){
            if(i==5){
                SeatsHTML += "<br>";
            }
            SeatsHTML += "<input id=\"" + i + "\" type=\"radio\" value=\"" + i + "\">\n" +
                        "<label for=\"" + i + "\">" + i + "</label>";
            i++;
        }


        Bookings booking = new Bookings();
        booking.setNumOfTickets(totalTickets);
        booking.setShowingID(SID);
        booking.setUserID(UID);
        request.setAttribute("Booking", booking);

        request.setAttribute("SeatsHTML", SeatsHTML);
        request.setAttribute("SID",SID);
        request.setAttribute("seniorTicketNo", SeniorTicketNo);
        request.setAttribute("adultTicketNo", AdultTicketNo);
        request.setAttribute("childTicketNo", MinorTicketNo);
        request.setAttribute("totalTickets", totalTickets);
        request.setAttribute("showTime", showTime);
        request.setAttribute("title", title);

        RequestDispatcher rd = request.getRequestDispatcher("selectSeats.jsp");
        rd.forward(request,response);





    }
}