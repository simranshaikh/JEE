

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class MultiplicationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public MultiplicationServlet() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int n1=Integer.parseInt(request.getParameter("value1"));
		int n2=Integer.parseInt(request.getParameter("value2"));
		int mul=(n1*n2);
		PrintWriter pw=response.getWriter();
		pw.print("Multiplication is "+mul);
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
