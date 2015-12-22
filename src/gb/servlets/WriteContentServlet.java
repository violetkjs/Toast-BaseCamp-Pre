package gb.servlets;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.annotation.WebServlet;

@WebServlet("/add")
public class WriteContentServlet extends HttpServlet {
	public void doGet(HttpServletRequest request,HttpServletResponse response)
	throws IOException,ServletException{
		RequestDispatcher rd = request.getRequestDispatcher("/view/WriteForm.jsp");
		rd.forward(request, response);
	}

}
