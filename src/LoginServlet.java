

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public LoginServlet() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ServletConfig config = getServletConfig();
        String user = config.getInitParameter("username");
        String pwd = config.getInitParameter("password");
        PrintWriter pw=response.getWriter();
        
        if((user.equals("techm")) && (pwd.equals("tls")))
        {
        	pw.print("you are a valid user");
        }
        else
        	pw.print("You are INVALID user");
        
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
