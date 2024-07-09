package P1;

import java.io.IOException;
import java.sql.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class De
 */
@WebServlet("/De")
public class De extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public De() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		try{String amo =request.getParameter("a");		
	       int a =Integer.parseInt(amo); int k=0;
	       Class.forName("com.mysql.cj.jdbc.Driver");
			  Connection co =DriverManager.getConnection("jdbc:mysql://localhost:3306/bankingsystem", "root","Ulsa@123");
			  Statement st =co.createStatement();
			  ResultSet rs =st.executeQuery("select * from acdetails");
			  while(rs.next())
			  {
				  int l =rs.getInt(4);
				  
				  if(l==Integer.parseInt(request.getParameter("b")))
				  {
					  k=1;
					  int f =rs.getInt(3);
					  f=f+a;
					  st.executeUpdate("UPDATE acdetails set amount ="+f+" where pin ="+l);
					  request.setAttribute("n",f);
					  RequestDispatcher rds =request.getRequestDispatcher("SSS.jsp");
					  rds.forward(request, response);
					  
			
					
					  
					  break;
				  }
				  else
				  {
					  continue;
				  }
			  }
			  if(k==0)
			  {
				  response.sendRedirect("De.jsp");
			  }
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
