package gb.listener;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import gb.util.DBConnectionPool;
import gb.dao.BoardDao;
@WebListener
public class ContextLoaderListener implements ServletContextListener {
	DBConnectionPool connPool;
	
	public void contextInitialized(ServletContextEvent event){
		try{
			ServletContext sc = event.getServletContext();
			
			connPool = new DBConnectionPool(
					sc.getInitParameter("driver"),
					sc.getInitParameter("url"),
					sc.getInitParameter("username"),
					sc.getInitParameter("password"));
			
			BoardDao boardDao = new BoardDao();
			boardDao.setDbConnectionPool(connPool);
			
			sc.setAttribute("boardDao", boardDao);
			
		}catch(Throwable e){
			e.printStackTrace();
		}
	}
	
	public void contextDestroyed(ServletContextEvent event){
		connPool.closeAll();
	}
}
