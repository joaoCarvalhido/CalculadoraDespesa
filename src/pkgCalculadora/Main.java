package pkgCalculadora;


//import java.util.Scanner;
//import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import pkgConnection.InvestimentoDAO;


public class Main {

	public static void main(String[] args) {
			// Escolher UseCases "calculaDespesa", "calculaInvestimento", "calculaDespesaxInvestimento"
			String[] opcoes = {"Dívida", "Investimento", "Dívida x Investimemto"};
			Object selectValue = JOptionPane.showInputDialog(null, "Qual opção você deseja calcular?", "Calculadora",
					JOptionPane.INFORMATION_MESSAGE, null, opcoes, opcoes[0]);
			
		//Se escolher despesa
		if(selectValue == opcoes[0] || selectValue == opcoes[1] || selectValue == opcoes[2]) {
			//if(selectValue == opcoes[2]) {
				Invest_X_Desp investXdesp = new Invest_X_Desp();
			//}
			
			if(selectValue == opcoes[0] || selectValue == opcoes[2]) {
			
			Despesa despesa = new Despesa();
			
			
			double dividaOriginal = Double.parseDouble(JOptionPane.showInputDialog("Qual o valor original da sua dívida? "));
			despesa.setValorOriginal(dividaOriginal);
			
			int qntParcelas = Integer.parseInt(JOptionPane.showInputDialog("Vai pagar em quantas parcelas? "));
			despesa.setQntMeses(qntParcelas);
			
			double parcela = Double.parseDouble(JOptionPane.showInputDialog("Quanto é o valor da parcela? "));
			despesa.setParcela(parcela);
			despesa.setParcelas(qntParcelas, parcela);
			
			
			//Se quiser adiantar a parcela da dívida
			String isAdiantarParcela = JOptionPane.showInputDialog("Vai adiantar alguma(s) parcela(s)? [s/n]").toUpperCase();
			int cadaMes = 0;
			int cadaParcela = 0;
			if (isAdiantarParcela.equals("S")){
				cadaMes = Integer.parseInt(JOptionPane.showInputDialog("A cada 2 meses eu consigo adiantar 1 parcela, e você? \n" +
									"Em quantos meses você consegue adiantar 'n' parcelas? ")); 
		
				cadaParcela = Integer.parseInt(JOptionPane.showInputDialog("Quantas parcelas? "));
				
				despesa.setIndicadorAdiantamento(cadaMes, cadaParcela);
				JOptionPane.showMessageDialog(null,despesa.toString(isAdiantarParcela));	
								
			}else{
				JOptionPane.showMessageDialog(null,despesa.toString());
			}
			
			investXdesp.setTotalAdiantamentoDespesa(despesa.getAdiantamento());
			investXdesp.setParcela(parcela);
			investXdesp.setQntMeses(qntParcelas);
			investXdesp.setCadaMes(cadaMes);
			investXdesp.setCadaParcela(cadaParcela);
			investXdesp.setTotalDespesa(despesa.getTotalDivida());
			
		}
			
			//se escolher investimento
		if(selectValue == opcoes[1] || selectValue == opcoes[2]) {
			
		}
					//Escolher opções de renda fixa ou variável
					
					String[] arrayTiposInvestimento = {"Fixa", "Variável"};
					Object selecionaTipoInvestimento = JOptionPane.showInputDialog(null, "Qual opção você deseja calcular?", "Calculadora",
							JOptionPane.INFORMATION_MESSAGE, null, arrayTiposInvestimento, arrayTiposInvestimento[0]);
					
					//Se escolher renda fixa, puxar os valores do Banco de dados
					if(selecionaTipoInvestimento == arrayTiposInvestimento[0]) {
						InvestimentoDAO investimentoDao = new InvestimentoDAO();
						investimentoDao.listarInvestimentos();
						
						//Armazena os valores dos nomes de renda fixa do Banco de dados e atribui a um vetor
						String[] arrayInvestimentoFixo = new String[investimentoDao.getNomeTamaho()];
						for(int i = 0; i < arrayInvestimentoFixo.length; i++) {
							arrayInvestimentoFixo[i] = investimentoDao.getNomeInvestimentos(i);
						}
						
						//Mostra os investimentos fixos do Banco de dados
						Object selecionaInvestimentoFixo = JOptionPane.showInputDialog(null, "Qual renda fixa você deseja?", "Calculadora",
								JOptionPane.INFORMATION_MESSAGE, null, arrayInvestimentoFixo, arrayInvestimentoFixo[0]);
								
						String qualRendaFixa = (String) selecionaInvestimentoFixo;
						
						//Atribui os dados do investimento aos atributos da classe Investimentos
								investimentoDao.puxarTabela(qualRendaFixa);
								
								Investimento investimento = new Investimento();
								
								int i = 0; 
								while(i < investimentoDao.getDadosTabelaTamanho()) {
									investimento.setIdInvestimento(Integer.parseInt(investimentoDao.getDadosTabela(i))); i++;
									investimento.setNomeInvestimento((investimentoDao.getDadosTabela(i))); i++;
									investimento.setTipoInvestimento((investimentoDao.getDadosTabela(i))); i++; 
									investimento.setValorInicial(Double.parseDouble(investimentoDao.getDadosTabela(i))); i++;
									investimento.setRendimentoMensal(Double.parseDouble(investimentoDao.getDadosTabela(i))); i++;
									investimento.setTemLiquidez(Integer.parseInt(investimentoDao.getDadosTabela(i))); i++;
									investimento.setQntLiquidez(Integer.parseInt(investimentoDao.getDadosTabela(i))); i++;
									investimento.setValorTempoLiquidez((investimentoDao.getDadosTabela(i))); i++;
								}
								
								int mesesInvestidos = Integer.parseInt(JOptionPane.showInputDialog("Vai investir por quantos meses? "));
								double parcelaInvestida = Double.parseDouble(JOptionPane.showInputDialog("Qual o valor de cada investimento? "));
								investimento.setRendimentoParcela(mesesInvestidos, parcelaInvestida);
								JOptionPane.showMessageDialog(null,investimento.toString());
								if(selectValue == opcoes[2]) {
									investXdesp.setTotalInvestido(investimento.getTotalFinal());
									investXdesp.calculaDiferenca();
									JOptionPane.showMessageDialog(null,investXdesp.toString());
								}
								
								
								
								
							
			// A FAZER: setar o setTotalInvestido com o getTotalInvestimento de Investimento

						
					//Se escolher renda variável, imprime mensagem
					}else if(selecionaTipoInvestimento == arrayTiposInvestimento[1]) {
						JOptionPane.showMessageDialog(null,"Não tem como calcular, pois não tem como prever a bolsa de valores");
					}
			
		} 
				
	}
}
