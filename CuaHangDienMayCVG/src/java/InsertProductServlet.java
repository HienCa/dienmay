
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 * Servlet implementation class newProductServlet
 */
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 10,
        maxFileSize = 1024 * 1024 * 50,
        maxRequestSize = 1024 * 1024 * 100
)
@WebServlet("/InsertProductServlet")
public class InsertProductServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private static final String UPLOAD_DIR = "Images";

    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertProductServlet() {
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
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
// TODO Auto-generated method stub
        response.getWriter().append("Served at: ").append(request.getContextPath());
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection conn = null; //connect SQL
        try {
            request.setCharacterEncoding("utf-8");
            response.setCharacterEncoding("utf-8");
            conn = MySQLConntUtils.getMySQLConnection();
            //xử lý tham số từ form
            String MaSP = request.getParameter("MaSP").toUpperCase();
            String NameSp = request.getParameter("NameSp");
            String TypeSP = request.getParameter("TypeSP");
            //String Thumbnail = request.getParameter("thumbnail");
            String Thumbnail = "";
            Part part = request.getPart("thumbnail");
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
            request.setAttribute("ColorSP", ColorSP);
            request.setAttribute("Price", Price);
            request.setAttribute("Card", Card);
            request.setAttribute("Screen", Screen);
            request.setAttribute("Pin", Pin);
            request.setAttribute("CPU", CPU);
            request.setAttribute("OS", OS);
            request.setAttribute("SizeWeight", SizeWeight);
            request.setAttribute("RAM", RAM);
            request.setAttribute("HardDrive", HardDrive);
            //thêm đối tượng vào CSDL
            if (MaSP.length() < 4 || MaSP.length() > 10) {

                String CheckMaSP = "Độ dài phải từ 4-10 ký tự và đúng format SP**";
                request.setAttribute("CheckMaSP", CheckMaSP);
                request.getRequestDispatcher("/InsertProduct.jsp").forward(request, response);
            } else if (NameSp.length() < 10 || NameSp.length() > 200) {

                String CheckNameSp = "Vui lòng mô tả chi tiết hơn, không quá 200 ký tự";
                request.setAttribute("CheckNameSp", CheckNameSp);
                request.getRequestDispatcher("/InsertProduct.jsp").forward(request, response);
            } else if (Screen.length() < 10 || Screen.length() > 200) {

                String CheckScreen = "Vui lòng mô tả chi tiết hơn, không quá 200 ký tự";
                request.setAttribute("CheckScreen", CheckScreen);
                request.getRequestDispatcher("/InsertProduct.jsp").forward(request, response);
            } else if (RAM.length() < 3 ||RAM.length() > 200) {

                String CheckRAM = "Vui lòng mô tả chi tiết hơn";
                request.setAttribute("CheckRAM", CheckRAM);
                request.getRequestDispatcher("/InsertProduct.jsp").forward(request, response);
            }  else if (Card.length() < 5 || Card.length() > 200) {

                String CheckCard = "Vui lòng mô tả chi tiết hơn, không quá 200 ký tự";
                request.setAttribute("CheckCard", CheckCard);
                request.getRequestDispatcher("/InsertProduct.jsp").forward(request, response);
            } else if (Pin.length() < 4 || Pin.length() > 200) {

                String CheckPin = "Vui lòng mô tả chi tiết hơn, không quá 200 ký tự";
                request.setAttribute("CheckPin", CheckPin);
                request.getRequestDispatcher("/InsertProduct.jsp").forward(request, response);
            } else if (CPU.length() < 5 || CPU.length() > 200) {

                String CheckCPU = "Vui lòng mô tả chi tiết hơn, không quá 200 ký tự";
                request.setAttribute("CheckCPU", CheckCPU);
                request.getRequestDispatcher("/InsertProduct.jsp").forward(request, response);
            } else if (SizeWeight.length() < 5 || SizeWeight.length() > 200) {

                String CheckSizeWeight = "Vui lòng mô tả chi tiết hơn, không quá 200 ký tự";
                request.setAttribute("CheckSizeWeight", CheckSizeWeight);
                request.getRequestDispatcher("/InsertProduct.jsp").forward(request, response);
            } else if (HardDrive.length() < 5 || HardDrive.length() > 200) {

                String CheckHardDrive = "Vui lòng mô tả chi tiết hơn, không quá 200 ký tự";
                request.setAttribute("CheckHardDrive", CheckHardDrive);
                request.getRequestDispatcher("/InsertProduct.jsp").forward(request, response);
            }/*else if (Price.length() < 5) {

                String CheckPrice = "Vui lòng mô tả chi tiết hơn";
                request.setAttribute("CheckPrice", CheckPrice);
                request.getRequestDispatcher("/InsertProduct.jsp").forward(request, response);
            }*/  else if (DBUtils.findMaspProductBoolean(conn, product)) {
                request.setAttribute("e", "Sản phẩm có mã là: " + "'" + MaSP + "'" + " đã tồn tại.");
                request.getRequestDispatcher("/InsertProduct.jsp").forward(request, response);
            } else {
                DBUtils.insertProduct(conn, product);

                request.setAttribute("success", "Successfull Insert!...");
                request.getRequestDispatcher("/InsertProduct.jsp").forward(request, response);
            }

            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SignInServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(SignInServlet.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(SignInServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }
        doGet(request, response);
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
}
