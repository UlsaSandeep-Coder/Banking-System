package P1;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LS
 */
@WebServlet("/LS")
public class LS extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LS() {
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
		String Password=request.getParameter("b");
		int c=0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection co = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankingsystem", "root","Ulsa@123");
			Statement st =co.createStatement();
			  ResultSet rs =st.executeQuery("select * from details");
			  while(rs.next())
			  {
				  String name=rs.getString(1);
				  String password =rs.getString(3);
				  if(name.equals(Name) && password.equals(Password))
				  {
					  c=1;
				          response.sendRedirect("S.jsp");
				          break;
				  }
				  else
				  {
					 continue;
				  }
			  }
			  if(c==0)
			  {
				  response.sendRedirect("E.jsp");
			  }
			//PreparedStatement ps =co.prepareStatement("insert into acdetails values(?,?,?,?)");
		}
		catch (Exception e) {
			
			// TODO: handle exception
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
