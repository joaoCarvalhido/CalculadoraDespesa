package pkgCalculadora;

//import java.util.ArrayList;

public class Invest_X_Desp {
	private double totalDespesa;
	private double totalAdiantamentoDespesa;
	private double totalInvestido;
	private double parcela;
	private int qntMeses;
	private int cadaMes;
	private int cadaParcela;
	
	public void setTotalDespesa(double totalDespesa) {
		this.totalDespesa = totalDespesa;
	}
	
	
	public double getTotalAdiantamentoDespesa() {
		return totalAdiantamentoDespesa;
	}
	public void setTotalAdiantamentoDespesa(double totalAdiantamentoDespesa) {
		this.totalAdiantamentoDespesa = totalAdiantamentoDespesa;
	}
	public double getTotalInvestido() {
		return totalInvestido;
	}
	public void setTotalInvestido(double totalInvestido) {
		this.totalInvestido = totalInvestido;
	}
	public double getParcela() {
		return parcela;
	}
	public void setParcela(double parcela) {
		this.parcela = parcela;
	}
	public int getQntMeses() {
		return qntMeses;
	}
	public void setQntMeses(int qntMeses) {
		this.qntMeses = qntMeses;
	}
	public int getCadaMes() {
		return cadaMes;
	}
	public void setCadaMes(int cadaMes) {
		this.cadaMes = cadaMes;
	}
	public int getCadaParcela() {
		return cadaParcela;
	}
	public void setCadaParcela(int cadaParcela) {
		this.cadaParcela = cadaParcela;
	}
	
	public double calculaDiferenca() {
		return totalInvestido - totalDespesa;
	}
	

	public String toString() {
		return  "Divida: \t" + totalDespesa + "\n" +
			    "investimento: \t" + totalInvestido + "\n" + 
				"diferença: \t" + String.valueOf(calculaDiferenca());
	}
}
