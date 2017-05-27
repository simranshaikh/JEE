

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class WelcomeServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

	public WelcomeServlet() {
		super();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		// step 1 - get the name entered by user in string variable
        String name = request.getParameter("username");
        // step 2 - create a cookie
        Cookie ck = new Cookie("uname", name);
        // step 3 - add cookie to response
        response.addCookie(ck);
        //step 4 - prepare the response you want to send to server
        PrintWriter out= response.getWriter();
        out.print("<b>Welcome !!!! "+name);
        out.print("<br>cookies are created for you. "
                            + "click on next button to check");
        out.print("<form action=\"TestServlet\">");
        out.print("<input type=submit value=\"next\"/>");
        out.print("</form>");

	

	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
	}

}
