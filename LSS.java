package P1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LSS
 */
@WebServlet("/LSS")
public class LSS extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LSS() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String name=request.getParameter("a");
		String a =request.getParameter("b");
		String k =request.getParameter("c");
		Random r =new Random();
		int n =r.nextInt(((999999999-100000000)+1)+100000000);
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection co =DriverManager.getConnection("jdbc:mysql://localhost:3306/bankingsystem", "root","Ulsa@123");
		PreparedStatement ps =co.prepareStatement("insert into acdetails values(?,?,?,?)");
		ps.setInt(1, n);
		ps.setString(2, name);
		ps.setString(3, a);
		ps.setString(4, k);
		PrintWriter pw =response.getWriter();
		
		int nn =ps.executeUpdate();
		
		ps.close();
		co.close();
		response.sendRedirect("M.jsp");
		}
		catch (Exception e) {
			e.printStackTrace();
			
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
