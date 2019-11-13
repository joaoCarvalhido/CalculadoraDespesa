package pkgConnection;

import java.sql.Connection; 
import java.sql.DriverManager; 
import java.sql.PreparedStatement; 
import java.sql.ResultSet; 
import java.sql.SQLException; 
import java.util.logging.Level; 
import java.util.logging.Logger;

public class ConnectionMysql {
	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/PI2";
	private static final String USER = "root";
	private static final String PASS = "";
	
	public static Connection getConnectionMysql() {
		Connection conn = null;
		try {
			//Class.forName(DRIVER);
			conn = DriverManager.getConnection(URL, USER, PASS);
			System.out.println("Conectado com sucesso!");
			
		}catch(SQLException ex) {
			System.out.println(ex.getMessage());
		}
		return conn;
	}
	
	
	
	//public static Connection void closeConnectionMysql(Connection conn) {
		//try {
			//if(conn != null) {
				//conn.close();
			//}
		//}catch(SQLException ex) {
			//System.err.print("Erro ao fechar conexao: ");
			//ex.getMessage();
		//}
	//}
	
	
	
	
}

