/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author PC
 */
@WebServlet(urlPatterns = {"/UpdateProductServlet"})
public class UpdateProductServlet extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet UpdateProductServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UpdateProductServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
        Connection con = null;
        try {
            con = MySQLConntUtils.getMySQLConnection();
            request.setCharacterEncoding("UTF-8");
            String MaSP = request.getParameter("MaSP").toUpperCase();
            String NameSp = request.getParameter("NameSp");
            String TypeSP = request.getParameter("TypeSP");
            //String Thumbnail = request.getParameter("thumbnail");
            String Thumbnail = "";
            Part part = request.getPart("Image");
            String fileName = extractFileName(part);
            fileName = new File(fileName).getName();
            part.write("C:/Users/PC/Documents/NetBeansProjects/CuaHangDienMayCVG/build/web/images" + fileName);
            Thumbnail = fileName;
            int Price = Integer.parseInt(request.getParameter("Price"));
            String ColorSP = request.getParameter("ColorSP");
            String Screen = request.getParameter("Screen");
            String Card = request.getParameter("Card");
            String Pin = request.getParameter("Pin");
            String CPU = request.getParameter("CPU");
            String OS = request.getParameter("OS");
            String SizeWeight = request.getParameter("SizeWeight");
            String RAM = request.getParameter("RAM");
            String HardDrive = request.getParameter("HardDrive");

            Product product = new Product(MaSP, NameSp, TypeSP, ColorSP, Price, Thumbnail, Screen, Card, Pin, CPU, OS, SizeWeight, RAM, HardDrive);
            request.setAttribute("MaSP", MaSP);
            request.setAttribute("NameSp", NameSp);
            request.setAttribute("TypeSP", TypeSP);
            request.setAttribute("Price", Price);
            request.setAttribute("ColorSP", ColorSP);
            request.setAttribute("Screen", Screen);
            request.setAttribute("Card", Card);
            request.setAttribute("Pin", Pin);
            request.setAttribute("CPU", CPU);
            request.setAttribute("OS", OS);
            request.setAttribute("SizeWeight", SizeWeight);
            request.setAttribute("RAM", RAM);
            request.setAttribute("HardDrive", HardDrive);
            //update

            if (MaSP.length() < 4 || MaSP.length() > 10) {

                String CheckMaSP = "Độ dài phải từ 4-10 ký tự và đúng format SP**";
                request.setAttribute("CheckMaSP", CheckMaSP);
                request.getRequestDispatcher("/UpdateProduct.jsp").forward(request, response);
            } else if (NameSp.length() < 10 || NameSp.length() > 200) {

                String CheckNameSp = "Vui lòng mô tả chi tiết hơn, không quá 200 ký tự";
                request.setAttribute("CheckNameSp", CheckNameSp);
                request.getRequestDispatcher("/UpdateProduct.jsp").forward(request, response);
            } else if (Screen.length() < 10 || Screen.length() > 200) {

                String CheckScreen = "Vui lòng mô tả chi tiết hơn, không quá 200 ký tự";
                request.setAttribute("CheckScreen", CheckScreen);
                request.getRequestDispatcher("/UpdateProduct.jsp").forward(request, response);
            } else if (RAM.length() < 3 ||RAM.length() > 200) {

                String CheckRAM = "Vui lòng mô tả chi tiết hơn";
                request.setAttribute("CheckRAM", CheckRAM);
                request.getRequestDispatcher("/UpdateProduct.jsp").forward(request, response);
            }  else if (Card.length() < 5 || Card.length() > 200) {

                String CheckCard = "Vui lòng mô tả chi tiết hơn, không quá 200 ký tự";
                request.setAttribute("CheckCard", CheckCard);
                request.getRequestDispatcher("/UpdateProduct.jsp").forward(request, response);
            } else if (Pin.length() < 4 || Pin.length() > 200) {

                String CheckPin = "Vui lòng mô tả chi tiết hơn, không quá 200 ký tự";
                request.setAttribute("CheckPin", CheckPin);
                request.getRequestDispatcher("/UpdateProduct.jsp").forward(request, response);
            } else if (CPU.length() < 5 || CPU.length() > 200) {

                String CheckCPU = "Vui lòng mô tả chi tiết hơn, không quá 200 ký tự";
                request.setAttribute("CheckCPU", CheckCPU);
                request.getRequestDispatcher("/UpdateProduct.jsp").forward(request, response);
            } else if (SizeWeight.length() < 5 || SizeWeight.length() > 200) {

                String CheckSizeWeight = "Vui lòng mô tả chi tiết hơn, không quá 200 ký tự";
                request.setAttribute("CheckSizeWeight", CheckSizeWeight);
                request.getRequestDispatcher("/UpdateProduct.jsp").forward(request, response);
            } else if (HardDrive.length() < 5 || HardDrive.length() > 200) {

                String CheckHardDrive = "Vui lòng mô tả chi tiết hơn, không quá 200 ký tự";
                request.setAttribute("CheckHardDrive", CheckHardDrive);
                request.getRequestDispatcher("/UpdateProduct.jsp").forward(request, response);
            }  /*else if (Price.length() < 5) {

                String CheckPrice = "Vui lòng mô tả chi tiết hơn";
                request.setAttribute("CheckPrice", CheckPrice);
                request.getRequestDispatcher("/UpdateProduct.jsp").forward(request, response);
            }*/ else if (DBUtils.findMaspProductBoolean(con, product)) {

                DBUtils.updateProduct(con, product);
                request.setAttribute("success", "Successfull Update!...");
                request.getRequestDispatcher("/Product.jsp").forward(request, response);
            } else {
                request.setAttribute("e", "Update failed!... Không tìm thấy sản phẩm có mã là " + MaSP);
                request.getRequestDispatcher("/UpdateProduct.jsp").forward(request, response);
            }

            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(UpdateProductServlet.class.getName()).log(Level.SEVERE, null, ex);

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UpdateProductServlet.class.getName()).log(Level.SEVERE, null, ex);

        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UpdateProductServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        processRequest(request, response);
    }

    private String extractFileName(Part part) {
        String contentDisp = part.getHeader("content-disposition");
        String[] items = contentDisp.split(";");
        for (String s : items) {
            if (s.trim().startsWith("filename")) {
                return s.substring(s.indexOf("=") + 2, s.length() - 1);
            }
        }
        return "";
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
