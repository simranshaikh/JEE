

import java.awt.print.Printable;
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

import weblogic.webservice.tools.pagegen.jp.result;


public class ProductStoreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	public ProductStoreServlet() {
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

			int number=Integer.parseInt(request.getParameter("no"));
			String name=request.getParameter("name");
			double price=Double.parseDouble(request.getParameter("price"));
			String company=request.getParameter("company");

			String query="insert into product values('"+number+"', '"+name+"','"+price+"', '"+company+"' )";
			ResultSet rs = st.executeQuery(query);
			pw.print("Data entered successfully");
			/*	while (rs.next())
			{
				int num=rs.getInt(1);
				String nm=rs.getString(2);
				double pr=rs.getDouble(3);
				String cmp=rs.getString(4);
				pw.print( num : nm : );

			}*/

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
