package mainPackage.DataLayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.StringTokenizer;

public class ConnectDB {
	public Connection conn;
	public ResultSet backUp=null;
	public ConnectDB(){
		// 1. GET A CONNECTION
		String url = "jdbc:mysql://localhost:3306/Momin";
		String user = "Momin";
		String pass = "1234";
		try {
			conn = DriverManager.getConnection(url,user,pass);
			System.out.println("Connected Successfully to " + user + "\n");
		}
		catch(Exception exc) {
			exc.printStackTrace();
		}
		
	}
	
	public Statement connect() {
		try {
			
			// CREATE A STATEMENT
			Statement stmt = conn.createStatement();
			return stmt;
			
		}
		
		catch(Exception exc) {
			exc.printStackTrace();
			return null;
		}
	}
	
	public PreparedStatement connectPrep(String sql) {	// FOR PREPARED SQL QUERIES
		
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			return stmt;
		}
		
		catch(Exception exc) {
			exc.printStackTrace();
			
		}
		
		return null;
		
	}
	
	public boolean ExecuteUpdate(String query) {
		Statement stmt = connect();
		if (stmt!=null) {
			try {
				System.out.println("EXECUTING UDPDATE: "+query);
				int rowsAffected = stmt.executeUpdate(query);
				StringTokenizer st = new StringTokenizer(query," ");  	// PRINT FIRST WORD OF THE QUERY
				String Action = st.nextToken();
				System.out.println(Action + " SUCCESSFUL");		// INSERT/UPDATE/DELETE...
				
				if (Action.equalsIgnoreCase("delete")) {
					System.out.println("ROWS AFFECTED: " + rowsAffected);
				}
			}
			catch (Exception exc) {
				exc.printStackTrace();
				return false;
			}
		}
		else {
			System.out.println("NO STATEMENT FOUND");
			return false;
		}
		return true;
	}
	
	public ResultSet ExecuteQueryRS(String query) {
		Statement stmt = connect();	// RECEIVE A BLANK STATEMENT AFTER CONNECTION
		ResultSet rs = null;
		if (stmt!=null) {
			
			try {
				System.out.println("Executing Query: " + query + "\n");
				rs = stmt.executeQuery(query);	// OBTAIN RESULT OF QUERY
				ResultSetMetaData rsm = rs.getMetaData();	// TO GET INFO ABOUT ResultSet of DATABASE
				return rs;
			}
			
			catch (Exception exc) {
				exc.printStackTrace();
			}
		}
		
		else {
			System.out.println("NO STATEMENT FOUND");
			
		}
		return rs;
	}
		
	
	public void ExecuteQuery(String query) {
		Statement stmt = connect();	// RECEIVE A BLANK STATEMENT AFTER CONNECTION
		
		if (stmt!=null) {
			
			try {
				System.out.println("Executing Query: " + query + "\n");
				ResultSet rs = stmt.executeQuery(query);	// OBTAIN RESULT OF QUERY
				ResultSetMetaData rsm = rs.getMetaData();	// TO GET INFO ABOUT ResultSet of DATABASE
				int columns = rsm.getColumnCount();
				
				
				while (rs.next()) {
					//System.out.println(rs.getString("id") + " " + rs.getString("name") + " ");
					for (int i=1; i<columns; i++)
						System.out.print(rs.getString(i) + " ");
					System.out.println();
				}
			}
			
			catch (Exception exc) {
				exc.printStackTrace();
			}
		}
		
		else {
			System.out.println("NO STATEMENT FOUND");
		}
		
	}
}
