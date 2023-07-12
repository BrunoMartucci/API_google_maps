import java.io.IOException;
import java.net.URISyntaxException;

import javax.swing.JOptionPane;

/**
 * Classe responsavel pelo fluxo principal do projeto
 * @author Bruno Martucci
 *
 */
public class Main {

	public static void main(String[] args) throws IOException, URISyntaxException {
		
		String nomeDoLugar = tela("Qual o Nome do Lugar? ");
		Lugar rissul = new Lugar(nomeDoLugar);
		
		while(true){
			try {
			String avaliacaoString = tela("Qual a Avaliaçao? ");
			Integer avaliacao  = Integer.parseInt(avaliacaoString);
			rissul.addAvaliacao(avaliacao);
			}catch (NumberFormatException e) {
				break;
			}catch (Exception e) {
				JOptionPane.showMessageDialog(null, e);
				break;
			}
		}
		
		telaMensagem(rissul);
		rissul.mostraNoMapa();

	}
	/**
	 * Exibe tela com resumo de um lugar 
	 * @param rissul um lugar qualquer
	 */
	private static void telaMensagem(Lugar rissul) {
		JOptionPane.showMessageDialog(null, rissul);
	}
	/**
	 * Exibe uma mensagem na tela e espera o input do usuario
	 * @param stringDisplay string que será exibida na tela
	 * @return
	 */
	private static String tela(String stringDisplay ) {
		return JOptionPane.showInputDialog(stringDisplay);
	}

	

}
