package pkgConnection;

public class mainTesteBanco {

	public static void main(String[] args) {
		
		InvestimentoDAO investimento = new InvestimentoDAO();
		investimento.listarInvestimentos();
		
		System.out.println(investimento.getNomeInvestimentos());
		
		//ConnectionMysql connection = new ConnectionMysql();
		//connection.getConnectionMysql();
		//System.out.println("hello");

	}

}
