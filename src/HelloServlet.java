

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class HelloServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

   
    public HelloServlet() 
    {  
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
	
		 String num = request.getParameter("empid");
	        int id = Integer.parseInt(num);
	        PrintWriter pw = response.getWriter();
	        pw.print("EMP Confirmation");
	        
	        // If emp id is valid, then transfer control to 2nd Servlet
	        // valid: num is between 101 - 104
	        if ((id >= 101) && (id <= 104)) {
	            // valid user
	            RequestDispatcher rd = request.getRequestDispatcher("/Second");
	            rd.include(request, response);
	           // rd.forward(request, response);
	            
	        } else {
	            // invalid user
	            //PrintWriter pw = response.getWriter();
	            pw.print("<b>Invalid Emp ID</b>");
	            //response.sendRedirect("https://www.google.com");
	            //pw.close();
	        }
	        pw.close();
	}
		//fetching data from request object
	/*	 int id = Integer.parseInt(request.getParameter("empid"));
		 PrintWriter pw = response.getWriter();
		 try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
System.out.println("driver loaded successfully");
			
			Connection conn=DriverManager.getConnection(
                 "jdbc:oracle:thin:@localhost:1521:xe",
                 "system",
                 "system");

			
			
			Statement st=conn.createStatement();
			
			String query="Select * from emp where id="+id;
			ResultSet rs = st.executeQuery(query);
			
			
			while(rs.next())
			{
				int empid=rs.getInt(1);
				String n=rs.getString(2);
				String d=rs.getNString(3);
				System.out.println(id +":"+n+":"+d);
				pw.print("<h1>"+empid+":"+n+":"+d);
			}
			rs.close();
			st.close(); 
			conn.close();
			pw.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
			
	        ServletConfig config = getServletConfig();
	        String user = config.getInitParameter("username");
	        String pwd = config.getInitParameter("password");
	        
	        ServletContext context = getServletContext();
	        String path = context.getInitParameter("databasePath");
		//String name=request.getParameter("user");
		//ServletConfig config
	        
	        }*/ 
	        
	        //pw.close();
	    
	        
	        
	        
	        /*pw.print("<h1><marquee>Welcome " + name + " to my first web application</marquee></h1>");
	        pw.print("<br/>User: " + user + " <br/>Password: " + pwd);
	        pw.print("<br/>DB Path: " + path );*/
	        
	


	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
	}

}
