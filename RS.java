package P1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RS
 */
@WebServlet("/RS")
public class RS extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RS() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String Name=request.getParameter("a");
		String Email=request.getParameter("b");
		String Password =request.getParameter("c");
		
				try{
					Class.forName("com.mysql.cj.jdbc.Driver");
				
				Connection co =DriverManager.getConnection("jdbc:mysql://localhost:3306/bankingsystem", "root","Ulsa@123");
				PreparedStatement ps =co.prepareStatement("insert into details values(?,?,?)");
				ps.setString(1, Name);
				ps.setString(2, Email);
				ps.setString(3, Password);
						
				int n =ps.executeUpdate();
				ps.close();
				co.close();
				if(n==1)
				{	
				response.sendRedirect("Sucess.jsp");
				}
				else
				{
				
					response.sendRedirect("Failure.jsp");
				}
				}
				catch (Exception e) {
					e.printStackTrace();
					response.sendRedirect("Failure.jsp");
				}
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
