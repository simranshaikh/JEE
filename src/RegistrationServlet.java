

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public RegistrationServlet() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String user=request.getParameter("username");
		String pwd=request.getParameter("password");
		//int id = Integer.parseInt(request.getParameter("empid"));
		 PrintWriter pw = response.getWriter();
		 try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
System.out.println("driver loaded successfully");
			
			Connection conn=DriverManager.getConnection(
                 "jdbc:oracle:thin:@localhost:1521:xe",
                 "system",
                 "system");

			
			
			Statement st=conn.createStatement();
			
			String query="insert into login values('"+user+"','"+pwd+"')";
			st.executeUpdate(query);
			String query1="select * from login";
			ResultSet rs = st.executeQuery(query1);
			
			
			while(rs.next())
			{
				
				String n=rs.getString(1);
				String d=rs.getNString(2);
				pw.print("<h1>"+user +":"+n+":"+d);
				pw.print("<h1>"+pwd+":"+n+":"+d);
				pw.print("records inserted successfully");
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
			
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
