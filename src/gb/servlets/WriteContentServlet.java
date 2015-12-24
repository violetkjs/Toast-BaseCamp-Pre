package gb.servlets;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.annotation.WebServlet;

import gb.dao.BoardDao;
import gb.vo.Board;
@WebServlet("/add")
public class WriteContentServlet extends HttpServlet {
	
	public static boolean isCheckEmailCorrect(String email) {
	 
	    String pttn = "^\\D.+@.+\\.[a-z]+";
	    Pattern p = Pattern.compile(pttn);
	    Matcher m = p.matcher(email);
	 
	    if(m.matches()) {
	        return true;
	    }
	 
	    return false;
	}

	
	public void doGet(HttpServletRequest request,HttpServletResponse response)
	throws IOException,ServletException{
		RequestDispatcher rd = request.getRequestDispatcher("/view/WriteForm.jsp");
		rd.forward(request, response);
	}
	public void doPost(HttpServletRequest request,HttpServletResponse response)
	throws IOException,ServletException{
		try{
			ServletContext sc = this.getServletContext();
			BoardDao boardDao = (BoardDao)sc.getAttribute("boardDao");
			if(isCheckEmailCorrect(request.getParameter("email"))){
				boardDao.insert(new Board().setEmail(request.getParameter("email"))
						.setContent(request.getParameter("content"))
						.setPwd(request.getParameter("pwd")));
				
				response.sendRedirect("list");
			}
			else{
				RequestDispatcher rd = request.getRequestDispatcher("/error/InsertError.jsp");
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
