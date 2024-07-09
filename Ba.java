package P1;

import java.io.IOException;
import java.sql.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Ba
 */
@WebServlet("/Ba")
public class Ba extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public Ba() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int k = 0;
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection co = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankingsystem", "root", "Ulsa@123");
            Statement st = co.createStatement();
            ResultSet rs = st.executeQuery("select * from acdetails");
            while (rs.next()) {
                int l = rs.getInt(4);

                if (l == Integer.parseInt(request.getParameter("b"))) {
                    k = 1;
                    int f = rs.getInt(3);
          
                    request.setAttribute("a", f);
                    RequestDispatcher rss = request.getRequestDispatcher("BE.jsp");
                    rss.forward(request, response);
                    response.sendRedirect("BE.jsp");
                    break;
                }
            }
            if (k == 0) {
                response.sendRedirect("De.jsp");
            }
            rs.close();
            st.close();
            co.close();
        } catch (Exception e) {
            e.printStackTrace();
            //response.sendRedirect("error.jsp");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
