
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
import javax.servlet.http.HttpSession;

/**
 *
 * @author PC
 */
@WebServlet(urlPatterns = {"/LogInServlet"})
public class LogInServlet extends HttpServlet {

    private static int count = 0;

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
            out.println("<title>Servlet LogInServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet LogInServlet at " + request.getContextPath() + "</h1>");
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
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            request.setAttribute("username", username);
            request.setAttribute("password", password);
            UserAccount user = new UserAccount(username, password);
            DBUtils.findUserAccount(con, user);
            UserAccount u = DBUtils.findUserAccount(con, user);

            /*if (username.length() < 8 || username.length() > 20) {
                request.setAttribute("CheckUsername", "Độ dài từ 8-20 ký tự");
                request.getRequestDispatcher("/LogIn.jsp").forward(request, response);
            } else if (password.length() < 8 || password.length() > 20) {
                request.setAttribute("CheckPassword", "Độ dài từ 8-20 ký tự");
                request.getRequestDispatcher("/LogIn.jsp").forward(request, response);
            }*/

            if (u != null) {
                this.count = 0;
                String greeting = "Hi! " + username;
                request.setAttribute("username", greeting);
                HttpSession sesstion = request.getSession();
                sesstion.setAttribute("user", user);
                request.getRequestDispatcher("/index.jsp").forward(request, response);
            } else if (this.count == 2) {
                this.count = 0;
                request.setAttribute("disabled", "disabled");
                request.setAttribute("e", "WARNING: Bạn đã đăng nhập không thành công quá 3 lần, tạm thời bạn chưa thể tiếp tục đăng nhập!...");
                request.getRequestDispatcher("/LogIn.jsp").forward(request, response);

            } else {
                this.count = this.count + 1;
                request.setAttribute("e", "Incorrect account or password!...");
                request.getRequestDispatcher("/LogIn.jsp").forward(request, response);

            }

            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(SignInServlet.class.getName()).log(Level.SEVERE, null, ex);

        } catch (ClassNotFoundException ex) {
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
