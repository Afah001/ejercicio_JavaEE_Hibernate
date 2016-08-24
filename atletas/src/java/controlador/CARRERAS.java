/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.HibernateUtil;
import modelo.atleta;
import modelo.carrera;
import modelo.maraton;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;


public class CARRERAS extends HttpServlet {

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
        
        
         String accion=request.getParameter("accion");
        
        if(accion.equals("consultarATLETAS_MARATONES")){
            SessionFactory sf=HibernateUtil.getSessionFactory();
           
            Session sesion=sf.openSession();
            sesion.beginTransaction();  
            
           try{Query consulta1=sesion.createQuery("FROM atleta");
            List <atleta> atletas=consulta1.list();
            request.setAttribute("lista1", atletas);
            
            Query consulta2=sesion.createQuery("FROM maraton");
            List <maraton> maratones=consulta2.list();
            request.setAttribute("lista2", maratones);
            
            sesion.getTransaction().commit();
            
             request.getRequestDispatcher("registroCarreras.jsp").forward(request, response);
           }finally{
              sesion.close(); 
           }
            
        }else{
                if(accion.equals("insertar")){
                    try {
                     DateFormat formatter = new SimpleDateFormat("Y-M-D");
                      Date fecha=formatter.parse(request.getParameter("_fecha"));


                     int idatleta=Integer.parseInt(request.getParameter("atleta"));
                     int idmaraton=Integer.parseInt(request.getParameter("maraton"));

                      SessionFactory sf=HibernateUtil.getSessionFactory();
                      Session sesion=sf.openSession();
                      sesion.beginTransaction();

                      atleta atleta=(atleta)sesion.get(atleta.class, idatleta);
                      maraton maraton=(maraton)sesion.get(maraton.class, idmaraton);

                      carrera carrera=new carrera(fecha,atleta,maraton);
                      sesion.save(carrera);

                      sesion.getTransaction().commit();
                      sesion.close();

                        request.getRequestDispatcher("CARRERAS?accion=consultarATLETAS_MARATONES").forward(request, response);
                  } catch (ParseException ex) {
                      Logger.getLogger(ATLETAS.class.getName()).log(Level.SEVERE, null, ex);
                  }
                }else{
                     if(accion.equals("consultar")){
                        SessionFactory sf=HibernateUtil.getSessionFactory();
                        Session sesion=sf.openSession();
                       sesion.beginTransaction();

                       try{ 
                        Query consultar=sesion.createQuery("FROM carrera");
                         List <carrera> carreras=consultar.list();
                       request.setAttribute("lista", carreras);

                         sesion.getTransaction().commit();
                         request.getRequestDispatcher("consultaCarreras.jsp").forward(request, response);

                       }finally{
                            sesion.close();
                       }

                    }else{
                          if(accion.equals("delete")){
                          SessionFactory sf=HibernateUtil.getSessionFactory();
                          Session sesion=sf.openSession();
                          sesion.beginTransaction();   
                          
                          int id=Integer.parseInt(request.getParameter("id"));
                          carrera c=(carrera)sesion.load(carrera.class,id);   
                          sesion.delete(c);
                          
                          sesion.getTransaction().commit();
                          sesion.close();
                          request.getRequestDispatcher("CARRERAS?accion=consultar").forward(request, response);
                          }
                    }
                }
         }
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
