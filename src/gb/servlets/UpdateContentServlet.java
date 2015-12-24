package gb.servlets;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.annotation.WebServlet;

import gb.dao.BoardDao;
import gb.vo.Board;
@WebServlet("/update")
public class UpdateContentServlet extends HttpServlet {
	public void doPost(HttpServletRequest request,HttpServletResponse response)
	throws IOException,ServletException{
		try{
			ServletContext sc = this.getServletContext();
			BoardDao boardDao = (BoardDao) sc.getAttribute("boardDao");
			
			boardDao.update(Integer.parseInt(request.getParameter("no")), request.getParameter("email"), request.getParameter("content"));
			
			response.sendRedirect("list");
		}catch(Exception e){
			e.printStackTrace();
			request.setAttribute("error", e);
			RequestDispatcher rd = request.getRequestDispatcher("/error/ErrorPage.jsp");
			rd.forward(request, response);
		}
		
	}

}
