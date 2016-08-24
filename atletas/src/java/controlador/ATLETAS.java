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
import org.hibernate.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;


public class ATLETAS extends HttpServlet {

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
     
      SessionFactory sf=HibernateUtil.getSessionFactory();
      Session sesion=sf.openSession();
       sesion.beginTransaction();   
       
        if(accion.equals("insertar")){
            
         
              
         try {
             String nombre=request.getParameter("_nombre");
             String apellido=request.getParameter("_apellido");
             DateFormat formatter = new SimpleDateFormat("Y-M-D");
             Date fecha=formatter.parse(request.getParameter("_fechaNacimiento"));
             String documento=request.getParameter("_documento");
             
            
             
             
             atleta atleta=new atleta(nombre,apellido,fecha,documento);
             
             sesion.save(atleta);
             
             sesion.getTransaction().commit();
             
             sesion.close();
             
             request.getRequestDispatcher("registroAtletas.jsp").forward(request, response);
         } catch (ParseException ex) {
             Logger.getLogger(ATLETAS.class.getName()).log(Level.SEVERE, null, ex);
         }
                       
                       
            
        }else{
            if(accion.equals("consultar")){
                // SessionFactory sf=HibernateUtil.getSessionFactory();
                 //Session sesion=sf.openSession();
                //sesion.beginTransaction();
                
               try{ 
                Query consultar=sesion.createQuery("FROM atleta");
                 List <atleta> atletas=consultar.list();
               request.setAttribute("lista", atletas);
               
                 sesion.getTransaction().commit();
                 request.getRequestDispatcher("consultaAtletas.jsp").forward(request, response);
                 
               }finally{
                    sesion.close();
               }
             
            }else{   if(accion.equals("delete")){
                         // SessionFactory sf=HibernateUtil.getSessionFactory();
                         // Session sesion=sf.openSession();
                         // sesion.beginTransaction();   
                          
                          int id=Integer.parseInt(request.getParameter("id"));
                          atleta a=(atleta)sesion.load(atleta.class,id);   
                          System.out.println(""+a.getNombre());
                            
                          sesion.delete(a);
                          
                          sesion.getTransaction().commit();
                          sesion.close();
                          
                          response.sendRedirect("ATLETAS?accion=consultar");
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
