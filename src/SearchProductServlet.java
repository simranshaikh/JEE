

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


public class SearchProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public SearchProductServlet() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",
					"system",
					"system");
			Statement st=con.createStatement();
			PrintWriter pw = response.getWriter();
			//String p=request.getParameter("pname");
			String query="select * from product where prodname=Moto M";
			ResultSet rs=st.executeQuery(query);
			pw.print("record found");
			while(rs.next())
			{
				int pno=rs.getInt(1);
				String nm=rs.getString(2);
				double d=rs.getDouble(3);
				String c=rs.getNString(4);
				//System.out.println(pno +":"+n+":"+d);
				pw.print("<h1>"+pno+":"+nm+":"+d+":"+c);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
