package gb.dao;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.List;

import gb.util.DBConnectionPool;
import gb.vo.Board;
public class BoardDao {
	DBConnectionPool connPool;
	
	public void setDbConnectionPool(DBConnectionPool connPool){
		this.connPool = connPool;
	}
	
	
	public List<Board> selectList() throws Exception{
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try{
			conn = connPool.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT BNO,EMAIL,CONTENT,MOD_DATE FROM BOARD ORDER BY BNO DESC");
			
			ArrayList<Board> boards = new ArrayList<Board>();
			
			while(rs.next()){
				boards.add(new Board()
						.setNo(rs.getInt("BNO"))
						.setEmail(rs.getString("EMAIL"))
						.setContent(rs.getString("CONTENT"))
						.setModDate(rs.getString("MOD_DATE")));
			}
			
			return boards;
		}catch (Exception e){
			throw e;
		}
		finally{
			try{if(rs != null) rs.close();}catch(Exception e) {}
			try{if(stmt != null) stmt.close();}catch(Exception e){}
			if(conn != null) connPool.returnConnection(conn);
		}
	}
	
}
