
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

/**
 *
 * @author PC
 */
@WebServlet(urlPatterns = {"/SignInServlet"})
public class SignInServlet extends HttpServlet {

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
            out.println("<title>Servlet SignInServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SignInServlet at " + request.getContextPath() + "</h1>");
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

        Connection conn = null;
        request.setCharacterEncoding("UTF-8");
        String username = request.getParameter("username");
        String gender = request.getParameter("gender");
        String email = request.getParameter("email");
        String tel = request.getParameter("tel");
        String dateOfBirth = request.getParameter("date");
        String address = request.getParameter("address");
        String password1 = request.getParameter("password1");
        String password2 = request.getParameter("password2");
        request.setAttribute("username", username);
        request.setAttribute("gender", gender);
        request.setAttribute("email", email);
        request.setAttribute("tel", tel);
        request.setAttribute("date", dateOfBirth);
        request.setAttribute("address", address);
        request.setAttribute("password1", password1);
        if ( dateOfBirth.length() <= 20 && email.length() <= 200 && address.length() <= 200) {

            if (username.length() < 8 || username.length() > 20) {

                String checkUsername = "Độ dài từ 8 đến 20 ký tự";
                request.setAttribute("checkUsername", checkUsername);
                request.getRequestDispatcher("/SignIn.jsp").forward(request, response);
            } else if (password1.length() < 8 || password1.length() > 20) {

                String checkPass = "Độ dài từ 8 đến 20 ký tự";
                request.setAttribute("checkPass", checkPass);
                request.getRequestDispatcher("/SignIn.jsp").forward(request, response);
            } else if (tel.length() < 10 || tel.length() > 20) {

                String checkTel = "Độ dài từ 10-20 ký tự";
                request.setAttribute("checkTel", checkTel);
                request.getRequestDispatcher("/SignIn.jsp").forward(request, response);
            } /*else if (dateOfBirth.length() < 10) {

                String checkDate = "Độ dài phải đủ 10 ký tự và đúng format dd/mm/yyyy";
                request.setAttribute("checkDate", checkDate);
                request.getRequestDispatcher("/SignIn.jsp").forward(request, response);
            }*/ else if (address.length() < 5 || address.length() > 200) {

                String CheckAddress = "Địa chỉ gồm số nhà/ đường/ ấp/ xã/ huyện/ tp(độ dài 8-200 ký tự)";
                request.setAttribute("CheckAddress", CheckAddress);
                request.getRequestDispatcher("/SignIn.jsp").forward(request, response);
            } else if (password1.equals(password2)) {
                try {

                    conn = MySQLConntUtils.getMySQLConnection();
                    UserAccount usr = new UserAccount(username, password1, gender, email, tel, dateOfBirth, address);
                    UserAccount user = new UserAccount(username);
                    boolean u = DBUtils.find(conn, user);
                    if (u) {
                        String exist = "Username: " + username + " đã tồn tại! Bạn vui lòng nhập username độc lạ hơn!";
                        request.setAttribute("exist", exist);
                        request.getRequestDispatcher("/SignIn.jsp").forward(request, response);
                    } else {
                        DBUtils.insertUserAccount(conn, usr);
                        String success = "Chúc mừng bạn đã đăng ký thành công tài khoản có Username là: " + username;
                        request.setAttribute("success", success);
                        request.getRequestDispatcher("/SignIn.jsp").forward(request, response);
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(SignInServlet.class.getName()).log(Level.SEVERE, null, ex);
                    request.setAttribute("exist", ex);
                    request.getRequestDispatcher("/SignIn.jsp").forward(request, response);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(SignInServlet.class.getName()).log(Level.SEVERE, null, ex);
                    request.setAttribute("exist", ex);
                    request.getRequestDispatcher("/SignIn.jsp").forward(request, response);
                } finally {
                    if (conn != null) {
                        try {
                            conn.close();
                        } catch (SQLException ex) {
                            Logger.getLogger(SignInServlet.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
            } else {
                String er = "Confirm password không chính xác! Vui lòng nhập lại!";
                request.setAttribute("er", er);
                request.getRequestDispatcher("/SignIn.jsp").forward(request, response);

            }
        } else {
            String er = "Vui lòng kiểm tra lại độ dài ký tự!";
            String CheckMail = "Độ dài phải đủ 10 ký tự ";
            request.setAttribute("checkDate", CheckMail);
            request.setAttribute("checkeMail", CheckMail);

            request.setAttribute("er", er);
            request.getRequestDispatcher("/SignIn.jsp").forward(request, response);
        }

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
