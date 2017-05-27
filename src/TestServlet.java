

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public TestServlet() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		 PrintWriter out = response.getWriter();
	        // code to fetch / retrieve cookie 
	        Cookie ck[] = request.getCookies();
	        if(ck!=null)
	        {
	            System.out.println(ck.length);
	            for(int i=0;i<ck.length;i++)
	            {
	                out.print("ck name : "+ck[i].getName());
	                out.print("<br>ck value : "+ck[i].getValue());
	            }
	        }
	        else
	        {
	            out.print("cookies are not added for you");
	        }

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
