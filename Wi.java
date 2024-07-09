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
 * Servlet implementation class Wi
 */
@WebServlet("/Wi")
public class Wi extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Wi() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		try {
			String amo =request.getParameter("a");
		
			
	       int a =Integer.parseInt(amo); int k=0;
	       Class.forName("com.mysql.cj.jdbc.Driver");
			  Connection co =DriverManager.getConnection("jdbc:mysql://localhost:3306/bankingsystem", "root","Ulsa@123");
			  Statement st =co.createStatement();
			  ResultSet rs =st.executeQuery("select * from acdetails");
			 
			  while(rs.next())
			  {
				  int l =rs.getInt(4);
				  int g =Integer.parseInt(request.getParameter("b"));
				  if(l==g)
				  {
					  k=1;
					  int f =rs.getInt(3); 
					  if(a>f)
					  {
						  response.sendRedirect("Is.jsp");
					  }
					  else
					  {
						  f=f-a;
						  ((java.sql.Statement) st).executeUpdate("UPDATE acdetails set amount ="+f+" where pin ="+l);
						  request.setAttribute("a",f);
						  RequestDispatcher rds =request.getRequestDispatcher("SS.jsp");
						 rds.forward(request, response);
						  
						  break; 
					  }  
				  }
				  else
				  {
					  continue;
				  }
			  }
			  if(k==0)
			  {
				  response.sendRedirect("Wi.jsp");
			  }
		}
		catch (Exception e) {
			e.printStackTrace();
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
