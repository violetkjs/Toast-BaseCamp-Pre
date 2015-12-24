package gb.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebServlet;

import gb.dao.BoardDao;
@WebServlet("/delete")
public class DeleteContentServlet extends HttpServlet {
	public void doGet(HttpServletRequest request,HttpServletResponse response)
			throws IOException,ServletException{
				try{
					ServletContext sc = this.getServletContext();
					BoardDao boardDao = (BoardDao) sc.getAttribute("boardDao");
					
					boardDao.delete(Integer.parseInt(request.getParameter("no")));
					
					response.sendRedirect("list");
				}catch(Exception e){
					e.printStackTrace();
					request.setAttribute("error", e);
					RequestDispatcher rd = request.getRequestDispatcher("/error/ErrorPage.jsp");
					rd.forward(request, response);
				}
				
			}

}
