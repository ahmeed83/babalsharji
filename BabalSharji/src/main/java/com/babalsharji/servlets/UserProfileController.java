package com.babalsharji.servlets;

import com.babalsharji.entity.Users;
import com.babalsharji.session.UsersFacade;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "UserProfileController", urlPatterns = {
    "/profile"
})
public class UserProfileController extends HttpServlet {
    @EJB
    private UsersFacade usersFacade;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String userPath = request.getServletPath();
        try {
            request.getRequestDispatcher("/WEB-INF/view" + userPath + ".jsp").forward(request, response);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        response.setContentType("text/html;charset=UTF-8");
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        boolean edit = false;
        String formatedNumber = "";
        String doB = "";
        Users user = usersFacade.find(id);
        
        if(user != null){
            if(user.getDateofbirth() != null){
                SimpleDateFormat df = new SimpleDateFormat("MM/dd/YYYY");
                doB = df.format(user.getDateofbirth());
            }
            if(user.getTelephone() != null){
                String number = user.getTelephone();
                formatedNumber = String.format("%s-%s %s %s", number.substring(0, 2),
                    number.substring(2, 5), number.substring(5, 8), number.substring(8, 10));
            }
            
            if(request.getParameter("edit") != null){
                edit = true;
                DateFormat format = new SimpleDateFormat("MM/dd/yyyy");
                try {
                    Date date = format.parse(doB);
                    doB = new SimpleDateFormat("yyyy-MM-dd").format(date);
                } catch (ParseException ex) {
                    Logger.getLogger(UserProfileController.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
            request.setAttribute("edit", edit);
            request.setAttribute("userDoB", doB);
            request.setAttribute("phoneNumber", formatedNumber);
            request.setAttribute("user", user);
        }
        
        processRequest(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }    
}