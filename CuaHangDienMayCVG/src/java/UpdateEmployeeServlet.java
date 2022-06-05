
import java.io.File;
import java.io.IOException;
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
 * Servlet implementation class editProductServlet
 */
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 10,
        maxFileSize = 1024 * 1024 * 50,
        maxRequestSize = 1024 * 1024 * 100
)
@WebServlet("/UpdateEmployeeServlet")
public class UpdateEmployeeServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateEmployeeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @param request
     * @param response
     * @throws javax.servlet.ServletException
     * @throws java.io.IOException
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     * response)
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
// TODO Auto-generated method stub
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.getWriter().append("Served at: ").append(request.getContextPath());
        String employeeCode = request.getParameter("employeeCode");

        try {
            Connection conn = MySQLConntUtils.getMySQLConnection();
            Employee employee = DBUtils.OneEmployee(conn, employeeCode);

            request.setAttribute("employee", employee);
            request.getRequestDispatcher("/UpdateEmployee.jsp").forward(request, response);
        } catch (SQLException | ClassNotFoundException e) {
        }
        // TODO Auto-generated catch block

    }

    /**
     * @param request
     * @param response
     * @throws javax.servlet.ServletException
     * @throws java.io.IOException
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     * response)
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        Connection conn = null; //connect SQL
        try {
            conn = MySQLConntUtils.getMySQLConnection();
            request.setCharacterEncoding("UTF-8");
            String employeeCode = request.getParameter("employeeCode").toUpperCase();
            String fullnameEmployee = request.getParameter("fullnameEmployee").toUpperCase();
            //String thumbnail = request.getParameter("thumbnail");

            String thumbnail = "";
            Part part = request.getPart("thumbnail");
            String fileName = extractFileName(part);
            fileName = new File(fileName).getName();
            part.write("C:/Users/PC/Documents/NetBeansProjects/CuaHangDienMayCVG/build/web/images/" + fileName);
            thumbnail = fileName;

            String gender = request.getParameter("gender");
            String cccd = request.getParameter("cccd");
            String dateOfBirth = request.getParameter("date");
            String tel = request.getParameter("tel");
            String email = request.getParameter("email");
            String address = request.getParameter("address");
            String nation = request.getParameter("nation");
            Employee employee = new Employee(employeeCode, fullnameEmployee, thumbnail, dateOfBirth, gender, cccd, tel, email, address, nation);
            if (employeeCode.length() < 4 || employeeCode.length() > 10) {

                String CheckEmployeeCode = "Độ dài phải đủ 4-10 ký tự và đúng format NV**";
                request.setAttribute("CheckEmployeeCode", CheckEmployeeCode);
                request.getRequestDispatcher("/InsertEmployee.jsp").forward(request, response);
            } else if (fullnameEmployee.length() < 5 || fullnameEmployee.length() > 200) {

                String CheckFullname = "Vui lòng nhập đủ họ và tên hợp lệ";
                request.setAttribute("CheckFullname", CheckFullname);
                request.getRequestDispatcher("/InsertEmployee.jsp").forward(request, response);
            } /*if (dateOfBirth.length() < 10 || dateOfBirth.length() > 10) {

                String CheckDate = "Độ dài phải đủ 10 ký tự và đúng format dd/mm/yyyy";
                request.setAttribute("CheckDate", CheckDate);
                request.getRequestDispatcher("/InsertEmployee.jsp").forward(request, response);
            }*/ else if (cccd.length() < 9 || cccd.length() > 12) {

                String CheckCCCD = "Độ dài từ 9 ký tự, không quá 12 ký tự";
                request.setAttribute("CheckCCCD", CheckCCCD);
                request.getRequestDispatcher("/InsertEmployee.jsp").forward(request, response);
            } else if (tel.length() < 10 || tel.length() > 50) {

                String CheckTel = "Độ dài phải từ 10-50 ký tự";
                request.setAttribute("CheckTel", CheckTel);
                request.getRequestDispatcher("/InsertEmployee.jsp").forward(request, response);
            } else if (address.length() < 10 || address.length() > 200) {

                String CheckAddress = "Địa chỉ gồm số nhà/ ấp/ xã/ huyện/ tp";
                request.setAttribute("CheckAddress", CheckAddress);
                request.getRequestDispatcher("/InsertEmployee.jsp").forward(request, response);
            } else if (nation.length() < 2 || nation.length() > 50) {

                String CheckNation = "Độ dài phải đủ 4-10 ký tự và đúng format NV**";
                request.setAttribute("CheckNation", CheckNation);
                request.getRequestDispatcher("/InsertEmployee.jsp").forward(request, response);
            } else {
                DBUtils.updateEmployee(conn, employee);
                request.setAttribute("success", "Successful Update");
                request.getRequestDispatcher("/Employee.jsp").forward(request, response);

            }
        } catch (ClassNotFoundException | SQLException ex) {
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

}
