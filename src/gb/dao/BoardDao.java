package gb.dao;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.List;

import gb.util.DBConnectionPool;
import gb.vo.Board;
import jdk.nashorn.internal.ir.RuntimeNode.Request;
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
	
	public int insert(Board board) throws Exception{
		Connection conn = null;
		PreparedStatement stmt = null;
		try{
			conn = connPool.getConnection();
			stmt = conn.prepareStatement("INSERT INTO BOARD(EMAIL,PWD,CONTENT,CRE_DATE,MOD_DATE) VALUES(?,?,?,NOW(),NOW())");
			stmt.setString(1, board.getEmail());
			stmt.setString(2, board.getPwd());
			stmt.setString(3, board.getContent());
			return stmt.executeUpdate();
		}catch(Exception e){
			throw e;
		}
		finally{
			try{if(stmt != null) stmt.close();}catch(Exception e){}
			if(conn != null) connPool.returnConnection(conn);
		}
		
	}
	
	public int delete(int no) throws Exception{
		Connection conn = null;
		PreparedStatement stmt = null;
		try{
			conn = connPool.getConnection();
			stmt = conn.prepareStatement("DELETE FROM BOARD WHERE BNO=?");
			stmt.setInt(1, no);
			return stmt.executeUpdate();
		}catch(Exception e){
			throw e;
		}
		finally{
			try{if(stmt != null) stmt.close();}catch(Exception e){}
			if(conn != null) connPool.returnConnection(conn);
		}
	}
	
	public Board selectOne(int no) throws Exception{
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try{
			conn = connPool.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT EMAIL,CONTENT,MOD_DATE FROM BOARD WHERE BNO='" + no +"'");
			if(rs.next()){
				Board board = new Board().setEmail(rs.getString("EMAIL")).setContent(rs.getString("CONTENT"))
						.setModDate(rs.getString("MOD_DATE"));
				return board;
			}
			else{
				return null;
			}
		}catch(Exception e){
			throw e;
		}
		finally{
			try{if (rs != null) rs.close();}catch(Exception e){}
			try{if(stmt != null) stmt.close();}catch(Exception e){}
			if(conn != null) connPool.returnConnection(conn);
		}
	}
	
	public boolean CheckInfo(int no,String email,String pwd) throws Exception{
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try{
			conn = connPool.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT COUNT(*) from board where pwd='" + pwd + "' AND bno='" + no + "' AND email='"
					+ email + "'");
			rs.next();
			if(rs.getInt(1) != 0)
				return true;
			else
				return false;
		}
		catch(Exception e){
			throw e;
		}
		finally{
			try{if(rs != null) rs.close();}catch(Exception e){}
			try{if(stmt != null) stmt.close();}catch(Exception e){}
			if(conn != null) connPool.returnConnection(conn);
		}
	}
	
	public int update(int no,String email,String content) throws Exception{
		Connection conn = null;
		PreparedStatement stmt = null;
		try{
			conn = connPool.getConnection();
			stmt = conn.prepareStatement("UPDATE BOARD SET EMAIL=?,CONTENT=?,MOD_DATE=NOW() WHERE BNO=?");
			stmt.setString(1, email);
			stmt.setString(2, content);
			stmt.setInt(3, no);
			return stmt.executeUpdate();
		}catch(Exception e){
			throw e;
		}
		finally{
			try{if(stmt != null) stmt.close();}catch(Exception e){}
			if(conn != null) connPool.returnConnection(conn);
		}
	}
	
}
