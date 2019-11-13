package pkgCalculadora;

import java.util.ArrayList;

public class Despesa {
	
	//ATRIBUTOS
	
	//valor inicial da dívida
	private double valorOriginal;
	
	//valor da dívida com juros
	private double totalDivida;
	
	//quantidade de parcelas
	private int qntMeses;
	
	//valor da parcela
	private double parcela;
	
	//juros sobre as parcelas iniciais
	private double juros;
	
	//total do adiantamento das parcelas
	private double adiantamento;
	
	//vetor de parcelas da divida
	private ArrayList<Double> parcelas = new ArrayList<Double>();
	
	//vetor de parcelas com adiantamento
	private ArrayList<Double> parcelasComAdiantamento = new ArrayList<Double>();
	
	//indicador do mes de referencia do adiantamento da parcela
	private ArrayList<Integer> indicadorAdiantamento = new ArrayList<Integer>();
	
	//historico do adiantamento de parcelas
	private ArrayList<Double> evolucaoAdiantamento = new ArrayList<Double>();
	
	
	
	//MÉTODOS

	public double getTotalDivida() {
		return totalDivida;
	}
	
	public void setTotalDivida(int qntMeses, double parcela) {
		double total = qntMeses * parcela;
		this.totalDivida = total;
	}
	public int getQntMeses() {
		return qntMeses;
	}
	public void setQntMeses(int qntMeses) {
		this.qntMeses = qntMeses;
	}
	public double getParcela() {
		return parcela;
	}
	public void setParcela(double parcela) {
		this.parcela = parcela;
	}
	public double getJuros() {
		return juros;
	}
	
	//calculo do juros simples sobre as parcelas
	public void setJuros(double totalDivida, double valorOriginal, int meses) {
		this.juros = ((totalDivida - valorOriginal) / meses) / valorOriginal;
	}
	
	public double getValorOriginal() {
		return valorOriginal;
	}
	public void setValorOriginal(double valorOriginal) {
		this.valorOriginal = valorOriginal;
	}
	
	//quanto o juros por mes aumentou o valor inicial da divida
	private double calculaDiferencaDivida() {
		return this.totalDivida - this.valorOriginal;
	}
	public ArrayList<Double> getParcelas() {
		return parcelas;
	}
		
	public Double getParcelas(int mes) {
			return parcelas.get(mes);
	}
	
	public void setParcelas(int qntMeses, double parcela) {
		for(int i = 0; i < qntMeses; i++){
			parcelas.add(parcela);
			setParcelasComAdiantamento(parcela);
		}
		setTotalDivida(qntMeses, parcela);
		setJuros(this.totalDivida, this.valorOriginal, qntMeses);
	}
	public ArrayList<Integer> getIndicadorAdiantamento() {
		return indicadorAdiantamento;
	}
	
	public double getAdiantamento() {
		return adiantamento;
	}
	public void setAdiantamento(double parcela, int cadaParcela) {
		for(int i = 0; i < indicadorAdiantamento.size(); i++) {
			if(indicadorAdiantamento.get(i) == 1)
				this.adiantamento = this.adiantamento + parcela * cadaParcela;
				this.evolucaoAdiantamento.add(adiantamento);
		}
		
	}
	
	public ArrayList<Double> getParcelasComAdiantamento() {
		return parcelasComAdiantamento;
	}
	
	private void setParcelasComAdiantamento(double parcela) {
		this.parcelasComAdiantamento.add(parcela);
	}
	
	public void setIndicadorAdiantamento(int cadaMes, int cadaParcela) {
		//laço para reduzir as parcelas de acordo com o adiantamento
		//for(int j = 0; j < parcelasComAdiantamento.size(); j++) {
			//if(parcelasComAdiantamento.size() - j > cadaMes)
			//	parcelasComAdiantamento.remove(parcelasComAdiantamento.size()-1);
		//}
		
		//laço para referenciar o mes de referencia do adiantamento de N parcelas
		for(int i = 1; i <= parcelasComAdiantamento.size(); i++) {
			if(i + cadaParcela <= parcelasComAdiantamento.size() + 1) {
				if(i % cadaMes == 0) {
					indicadorAdiantamento.add(1);
					for(int k = 0; k < cadaParcela; k++)
						parcelasComAdiantamento.remove(parcelasComAdiantamento.size()-1);
				}else {
				indicadorAdiantamento.add(0);
				}
			}
		}
		
		setAdiantamento(this.parcela, cadaParcela);
	}
	
	//método pra não imprimir o array inteiro
	public ArrayList<String> isMuitasParcelas(ArrayList<Double> arrayDouble) {
		ArrayList<String> printaVetor = new ArrayList<String>();
			for (int i = 0; i < arrayDouble.size(); i++) {
				printaVetor.add(String.valueOf(arrayDouble.get(i)));
			}
			for (int tamanho = printaVetor.size(); tamanho > 6; tamanho--) {
				printaVetor.remove(printaVetor.size()-1);
			}
			
			if(printaVetor.size() == 6 ) {
				printaVetor.add("...+");
			}
			
			return printaVetor;
		}
	
	public ArrayList<String> isMuitasParcelasInt(ArrayList<Integer> arrayDouble) {
		ArrayList<String> printaVetor = new ArrayList<String>();
			for (int i = 0; i < arrayDouble.size(); i++) {
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
			
		
		
		
	
	//METODOS DE IMPRIMIR RESULTADO (RELATÓRIO)
	
	//imprime se não adiantar nenhuma parcela da dívida:
	public String toString() {
		return
				"\nValor original da dívida: R$ " + valorOriginal + "\n" +
				"Juros ao mês: R$ " + juros *100 + "%" + "\n" +
				"Valor da dívida com juros: R$ " + totalDivida + "\n" +
				"Parcelando, você gastou um total de R$ " + calculaDiferencaDivida() + " a mais do valor original" + "\n\n" +
				"Parcelas da dívida: " + isMuitasParcelas(parcelas) + "\n" +
				"Você vai quitar sua dívida em " + parcelas.size() + " meses";
	}
	
	//imprime se adiantar pelo menos uma parcela da dívida:
	public String toString(String a) {
		return
				"\nValor original da dívida: R$ " + valorOriginal + "\n" +
				"Juros ao mês: R$ " + juros * 100 + "%" + "\n" +
				"Valor da dívida com juros: R$ " + totalDivida + "\n" +
				"Parcelando, você gastou um total de R$ " + calculaDiferencaDivida() + " a mais do valor original" + "\n\n" +
				"Parcelas da dívida:\t\t\t" + isMuitasParcelas(parcelas) + "\n" +
				"Parcelas da dívida com adiantamento:\t" + isMuitasParcelas(parcelasComAdiantamento) + "\n" +
				"Total adiantado: R$ " + adiantamento + "\n" +
				"Você vai quitar sua dívida em " + (parcelasComAdiantamento.size()) + " meses" + "\n" +
				"Vetor de meses adiantados: " + isMuitasParcelasInt(indicadorAdiantamento) + "\n" +
				"Evolução do adiantamento: " + isMuitasParcelas(evolucaoAdiantamento) + "\n";
	}
	
}
