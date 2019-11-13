package pkgConnection;

import java.sql.Connection;

import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//import java.util.ArrayList;

//DAO == Data Acess Object

public class InvestimentoDAO {
	private  ArrayList<String> nomeInvestimentos = new ArrayList<String>();
	private  ArrayList<String> dadosTabela = new ArrayList<String>();



	public void listarInvestimentos() {
		Connection conn = ConnectionMysql.getConnectionMysql();
		PreparedStatement query = null;
		ResultSet rs = null;
		String queryListarInvestimentos = "SELECT * FROM PI2.INVESTIMENTO";
		
		try {
			query = conn.prepareStatement(queryListarInvestimentos);
			rs = query.executeQuery();
			while(rs.next()) {
				String resultadoQuery = rs.getString("nomeInvestimento");
				nomeInvestimentos.add(resultadoQuery);
			}
			
			 conn.close();
		}catch(SQLException ex) {
			System.out.println(ex.getMessage());
			
		}
		
	}
	
	public void puxarTabela(String filtro) {
		Connection conn = ConnectionMysql.getConnectionMysql();
		PreparedStatement query = null;
		ResultSet rs = null;
		String queryPuxarTabela = "SELECT * FROM PI2.INVESTIMENTO WHERE nomeInvestimento LIKE '" + filtro + "' ";
		
		try {
			query = conn.prepareStatement(queryPuxarTabela);
			rs = query.executeQuery();
			if(rs != null) {
				while(rs.next()) {
					String resultadoQuery = rs.getString("idInvestimento");
					dadosTabela.add(resultadoQuery);
					resultadoQuery = rs.getString("nomeInvestimento");
					dadosTabela.add(resultadoQuery);
					resultadoQuery = rs.getString("tipoInvestimento");
					dadosTabela.add(resultadoQuery);
					resultadoQuery = rs.getString("valorInicial");
					dadosTabela.add(resultadoQuery);
					resultadoQuery = rs.getString("rendimentoMensal");
					dadosTabela.add(resultadoQuery);
					resultadoQuery = rs.getString("temLiquidez");
					dadosTabela.add(resultadoQuery);
					resultadoQuery = rs.getString("qntLiquidez");
					dadosTabela.add(resultadoQuery);
					resultadoQuery = rs.getString("valorTempoLiquidez");
					dadosTabela.add(resultadoQuery);
				}		
			}
			conn.close();
		}catch(SQLException ex) {
			System.out.println(ex.getMessage());
			
		}
		
	}
	
	public ArrayList<String> getNomeInvestimentos() {
		return nomeInvestimentos;
	}
	
	public String getNomeInvestimentos(int index) {
		return nomeInvestimentos.get(index);
	}
	
	public int getNomeTamaho() {
		return nomeInvestimentos.size();
	}
	
	public ArrayList<String> getDadosTabela() {
		return dadosTabela;
	}
	
	public String getDadosTabela(int index) {
		return dadosTabela.get(index);
	}
	
	public int getDadosTabelaTamanho() {
		return dadosTabela.size();
	}

}
