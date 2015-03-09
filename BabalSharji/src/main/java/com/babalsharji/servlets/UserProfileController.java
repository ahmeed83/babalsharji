package com.babalsharji.servlets;

import com.babalsharji.entity.Users;
import com.babalsharji.session.UsersFacade;
import java.io.IOException;
import java.util.HashMap;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "UserProfileController", urlPatterns = {
    "/profile",
    "/editprofile",
    "/submitprofile"})
public class UserProfileController extends HttpServlet {

    @EJB
    private UsersFacade usersFacade;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String userPath = request.getServletPath();
        Boolean edit = false;
        if (request.getSession().getAttribute("userid") != null) {
            Users user = usersFacade.find(Integer.parseInt(request.getSession().getAttribute("userid").toString()));
            switch (userPath) {
                case ("/editprofile"):
                    userPath = "/profile";
                    edit = true;
                    break;
                case ("/submitprofile"):
                    userPath = "/profile";
                    HashMap<String,String[]> params = (HashMap<String,String[]>) request.getParameterMap();
                    
                    user.setFirstname(params.get("firstname")[0]);
                    user.setLastname(params.get("lastname")[0]);
                    
                    user.setDateofbirth(params.get("dob")[0]);
                    user.setGender(params.get("gender")[0].equals("")  ? null : params.get("gender")[0]);
                    user.setAddress(params.get("address")[0]);
                    user.setEmail(params.get("email")[0]);
                    user.setTelephone(params.get("phone")[0].replaceAll( "[^\\d]", "" ));
                    usersFacade.edit(user);
                    break;
            }
            request.setAttribute("edit", edit);
            request.setAttribute("user", user);
        } else {
            response.sendRedirect("login");
        }
        try {
            request.getRequestDispatcher("/WEB-INF/view" + userPath + ".jsp").forward(request, response);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        response.setContentType("text/html;charset=UTF-8");
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}
