

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class SimpleIntServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public SimpleIntServlet() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		int principal = Integer.parseInt(request.getParameter("principal"));
		int no_of_years=Integer.parseInt(request.getParameter("noy"));
		int rate=Integer.parseInt(request.getParameter("rate"));
		int si=(principal*no_of_years*rate/100);
		PrintWriter pw=response.getWriter();
		pw.print("the simple interest is"+si);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
