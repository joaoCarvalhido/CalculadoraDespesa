package pkgCalculadora;

import java.util.ArrayList;

//import java.util.ArrayList;

//import pkgConnection.InvestimentoDAO;

public class Investimento {
	private int idInvestimento;
	private String nomeInvestimento;
	private String tipoInvestimento;
	private double valorInicial;
	private double rendimentoMensal;
	private int temLiquidez;
	private int qntLiquidez;
	private String valorTempoLiquidez;
	private ArrayList<Double> rendimentoParcelas = new ArrayList<Double>();
	private ArrayList<Double> valoresAplicados = new ArrayList<Double>();
	private ArrayList<Double> apenasRendimento = new ArrayList<Double>();
	private double totalInvestido;
	private int qntMeses;
	private double parcela;
	private double totalFinal;
	

	
	public int getIdInvestimento() {
		return idInvestimento;
	}
	public void setIdInvestimento(int idInvestimento) {
		this.idInvestimento = idInvestimento;
	}
	public String getNomeInvestimento() {
		return nomeInvestimento;
	}
	public void setNomeInvestimento(String nomeInvestimento) {
		this.nomeInvestimento = nomeInvestimento;
	}
	public String getTipoInvestimento() {
		return tipoInvestimento;
	}
	public void setTipoInvestimento(String tipoInvestimento) {
		this.tipoInvestimento = tipoInvestimento;
	}
	public double getValorInicial() {
		return valorInicial;
	}
	public void setValorInicial(double valorInicial) {
		this.valorInicial = valorInicial;
	}
	public double getParcela() {
		return parcela;
	}
	public void setParcela(double parcela) {
		this.parcela = parcela;
	}
	public double getRendimentoMensal() {
		return rendimentoMensal;
	}
	public void setRendimentoMensal(double rendimentoMensal) {
		this.rendimentoMensal = rendimentoMensal;
	}
	public int getTemLiquidez() {
		return temLiquidez;
	}
	public void setTemLiquidez(int temLiquidez) {
		this.temLiquidez = temLiquidez;
	}
	public int getQntLiquidez() {
		return qntLiquidez;
	}
	public void setQntLiquidez(int qntLiquidez) {
		this.qntLiquidez = qntLiquidez;
	}
	public ArrayList<Double> getApenasRendimento() {
		return apenasRendimento;
	}
	public void setApenasRendimento(ArrayList<Double> apenasRendimento) {
		this.apenasRendimento = apenasRendimento;
	}
	public String getValorTempoLiquidez() {
		return valorTempoLiquidez;
	}
	public void setValorTempoLiquidez(String valorTempoLiquidez) {
		this.valorTempoLiquidez = valorTempoLiquidez;
	}

	public ArrayList<Double> getRendimentoParcela() {
		return rendimentoParcelas;
	}

	public void setRendimentoParcela(int meses, double parcela) {
		setParcela(parcela);
		//System.out.println(rendimentoParcelas.size());
		double parcelaAtual = 0;
		double rendimento = 0;
		for(int i = 0; i < meses; i++){
			valoresAplicados.add(parcela);
			parcelaAtual = (parcelaAtual + parcela) * rendimentoMensal + (parcelaAtual + parcela);
		
			rendimentoParcelas.add(parcelaAtual);
			apenasRendimento.add(rendimentoParcelas.get(i));
		}
		setTotalInvestido(qntMeses, parcela);
		setTotalFinal(rendimentoParcelas.get(rendimentoParcelas.size()-1));
	}

	public double getTotalInvestido() {
		return totalInvestido;
	}

	public void setTotalInvestido(int meses, double parcela) {
		double total = qntMeses * parcela;
		this.totalInvestido = total;
	}
	

	public double getTotalFinal() {
		return totalFinal;
	}

	public void setTotalFinal(double totalFinal) {
		this.totalFinal = totalFinal;
	}
	
	public ArrayList<String> isMuitasParcelas(ArrayList<Double> arrayDouble) {
		ArrayList<String> printaVetor = new ArrayList<String>();
			for (int i = 0; i < arrayDouble.size() - 1; i++) {
				printaVetor.add(String.valueOf(arrayDouble.get(i)));
			}
			for (int tamanho = printaVetor.size(); tamanho > 6; tamanho--) {
				printaVetor.remove(printaVetor.size()-1);
			}
			
			if(printaVetor.size() == 6) {
				printaVetor.add("...+");
			}
			
			return printaVetor;
		}
	
	public String toString() {
		return
				"Rendendo um total de: " + rendimentoMensal + " reais ao mês" + "\n" + 
				"Parcelas do investimento: " + isMuitasParcelas(getRendimentoParcela()) +  "\n" + 
				"No ultimo mês, você vai ter um total de: " + getTotalFinal() +  "\n" + 
				"Seu dinheiro rendeu um total de: " + apenasRendimento.get(apenasRendimento.size()-1);
	}
		
	
}
