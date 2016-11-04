/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.segvek.taskmanager.service.ParserManager;
import com.segvek.taskmanager.service.util.InputStreamUtil;
import java.io.IOException;
import com.segvek.taskmanager.service.impl.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Panas
 */
public class API extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (request.getContentType() != null && request.getContentType().equals("text/xml; charset=utf-8")) {
            response.setContentType("text/xml;charset=UTF-8");
            String xmlRequest = InputStreamUtil.readInputStrean(request.getInputStream());
            String xmlResponse = "error";
            try {

                /*закоментирована чать которая расчитана на Spring*/
//                ParserManager parserManager = (ParserManager) SpringUtil.getInstance().getBean("prserManager");
                ParserManager parserManager = ParserManagerImpl.getInstance(); //
                xmlResponse = parserManager.parse(xmlRequest);
            } catch (Exception ex) {
                response.getWriter().print("erorrrrruyjhgf");
            }
            response.getWriter().print(xmlResponse);
            return;
        } else {
            response.setContentType("text/html;charset=UTF-8");
            response.getWriter().print("<error>This content type dont text/xml</error>");
        }      
//        request.getRequestDispatcher("index.html").forward(request, response);
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
