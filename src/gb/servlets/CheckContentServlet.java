package gb.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;

import gb.dao.BoardDao;
import gb.vo.Board;
@WebServlet("/check")
public class CheckContentServlet extends HttpServlet {
	public void doPost(HttpServletRequest request,HttpServletResponse response)
	throws IOException,ServletException{
		try{
			ServletContext sc = this.getServletContext();
			BoardDao boardDao = (BoardDao)sc.getAttribute("boardDao");
			
			if(boardDao.CheckInfo(Integer.parseInt(request.getParameter("no")), request.getParameter("email"),
					request.getParameter("pwd")) == true){
				
				Board board = boardDao.selectOne(Integer.parseInt(request.getParameter("no")));
				
				if(board != null){
					request.setAttribute("board", board);
					request.setAttribute("bno", request.getParameter("no"));
					RequestDispatcher rd = request.getRequestDispatcher("/view/UpdateContentForm.jsp");
					rd.forward(request, response);
				}
				
			}
			else{
				request.setAttribute("no", request.getParameter("no"));
				request.setAttribute("email", request.getParameter("email"));
				RequestDispatcher rd = request.getRequestDispatcher("/error/FindError.jsp");
				rd.forward(request, response);
			}
			
		}catch(Exception e){
			e.printStackTrace();
			request.setAttribute("error", e);
			RequestDispatcher rd = request.getRequestDispatcher("/error/ErrorPage.jsp");
			rd.forward(request, response);
		}
	}

}
