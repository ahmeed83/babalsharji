package com.babalsharji.servlets;

import com.babalsharji.entity.Users;
import com.babalsharji.session.UsersFacade;
import com.babalsharji.util.Encryption;
import java.io.IOException;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "LinkController", urlPatterns = {
    "/index",
    "/home",
    "/register",
    "/login",
    "/logout",
    "/submitlogin"
})
public class LinkController extends HttpServlet {
    @EJB
    private UsersFacade usersFacade;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session;
        String userPath = request.getServletPath();
        switch (userPath) {
            case "/logout":
                session = request.getSession();
                session.invalidate();
                response.sendRedirect("home");
                break;
            case "/submitlogin":
                String encryptedPass;
                String email = request.getParameter("email");
                String password = request.getParameter("password");
                Encryption encryption = Encryption.getInstance();
                
                List<Users> userList = usersFacade.getUserByEmail(request.getParameter("email"));
                Users user = null;
                
                if(userList.size() > 0){
                    user = userList.get(userList.size()-1);
                }

                if(user != null){
                    encryptedPass = encryption.encryptPassword(password);
                    if(user.getPassword().equals(encryptedPass)){
                        session = request.getSession(true);
                        session.setAttribute("userid", user.getId());
                        user = usersFacade.find(user.getId());
                        session.setAttribute("name", user.getFirstname() +" "+ user.getLastname());
                        
                        response.sendRedirect("home");
                    }
                } else {
                    response.sendRedirect("login");
                }
                break;
         }
        
        try {
            request.getRequestDispatcher("/WEB-INF/view" + userPath + ".jsp").forward(request, response);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        response.setContentType("text/html;charset=UTF-8");
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
