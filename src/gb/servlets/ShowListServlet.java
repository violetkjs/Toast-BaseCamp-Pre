package gb.servlets;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.ServletContext;

import gb.dao.BoardDao;
@WebServlet("/list")
public class ShowListServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest request,HttpServletResponse response) 
			throws ServletException,IOException{
		try{
			ServletContext sc = this.getServletContext();
			BoardDao boardDao = (BoardDao)sc.getAttribute("boardDao");
			
			request.setAttribute("boardList", boardDao.selectList());
			response.setContentType("text/html; charset=UTF-8");
			
			RequestDispatcher rd = request.getRequestDispatcher("/view/BoardList.jsp");
			rd.include(request, response);
		}catch(Exception e){
			e.printStackTrace();
			request.setAttribute("error", e);
			RequestDispatcher rd = request.getRequestDispatcher("/error/Error.jsp");
			rd.forward(request, response);
		}
		
	}

}
