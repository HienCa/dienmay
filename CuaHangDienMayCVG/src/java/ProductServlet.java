
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.net.URL;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 * Servlet implementation class editProductServlet
 */
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 10,
        maxFileSize = 1024 * 1024 * 50,
        maxRequestSize = 1024 * 1024 * 100
)
@WebServlet("/ProductServlet")
public class ProductServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
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
    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
// TODO Auto-generated method stub
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.getWriter().append("Served at: ").append(request.getContextPath());
        String MaSP = request.getParameter("MaSP");

        Product product = new Product();
        try {
            Connection conn = MySQLConntUtils.getMySQLConnection();
            product = DBUtils.AllProduct(MaSP);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        request.setAttribute("product", product);
        request.getRequestDispatcher("/UpdateProduct.jsp").forward(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        Connection con = null; //connect SQL
        try {
            request.setCharacterEncoding("utf-8");
            response.setCharacterEncoding("utf-8");
            con = MySQLConntUtils.getMySQLConnection();
            String MaSP = request.getParameter("MaSP").toUpperCase();
            String NameSp = request.getParameter("NameSp");
            String TypeSP = request.getParameter("TypeSP");

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

            String Thumbnail = "";
            Part part = request.getPart("thumbnail");
            String fileName = extractFileName(part);
            fileName = new File(fileName).getName();
            part.write("C:/Users/PC/Documents/NetBeansProjects/CuaHangDienMayCVG/build/web/images/" + fileName);
            Thumbnail = fileName;
            Product product = new Product(MaSP, NameSp, TypeSP, ColorSP, Price, Thumbnail, Screen, Card, Pin, CPU, OS, SizeWeight, RAM, HardDrive);

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
            } else if (RAM.length() < 4) {

                String CheckRAM = "Vui lòng mô tả chi tiết hơn";
                request.setAttribute("CheckRAM", CheckRAM);
                request.getRequestDispatcher("/UpdateProduct.jsp").forward(request, response);
            } else if (Card.length() < 5 || Card.length() > 200) {

                String CheckCard = "Vui lòng mô tả chi tiết hơn, không quá 200 ký tự";
                request.setAttribute("CheckCard", CheckCard);
                request.getRequestDispatcher("/UpdateProduct.jsp").forward(request, response);
            } else if (Pin.length() < 4) {

                String CheckPin = "Vui lòng mô tả chi tiết hơn, không quá 200 ký tự";
                request.setAttribute("CheckPin", CheckPin);
                request.getRequestDispatcher("/UpdateProduct.jsp").forward(request, response);
            } else if (CPU.length() < 2) {

                String CheckCPU = "Vui lòng mô tả chi tiết hơn, không quá 200 ký tự";
                request.setAttribute("CheckCPU", CheckCPU);
                request.getRequestDispatcher("/UpdateProduct.jsp").forward(request, response);
            } else if (SizeWeight.length() < 5) {

                String CheckSizeWeight = "Vui lòng mô tả chi tiết hơn, không quá 200 ký tự";
                request.setAttribute("CheckSizeWeight", CheckSizeWeight);
                request.getRequestDispatcher("/UpdateProduct.jsp").forward(request, response);
            } else if (HardDrive.length() < 5) {

                String CheckHardDrive = "Vui lòng mô tả chi tiết hơn, không quá 200 ký tự";
                request.setAttribute("CheckHardDrive", CheckHardDrive);
                request.getRequestDispatcher("/UpdateProduct.jsp").forward(request, response);
            } /*else if (Price.length() < 5) {

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
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SignInServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(SignInServlet.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(SignInServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }
        //doGet(request, response);
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

    private void updateProduct(Connection conn, Product pro) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
