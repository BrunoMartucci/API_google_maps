import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
/**
 * Representa um lugar no nosso codigo
 * @author Bruno Martucci
 *
 */
public class Lugar {
	private String nome;
	private List<Integer> avaliacoes = new ArrayList<Integer>();
	
	public Lugar(String stringQualquer) {
		this.nome = stringQualquer.toUpperCase();
	}
	
	/**
	 *  Exibe o nome do lugar utilizando a api do google maps
	 * @throws IOException
	 * @throws URISyntaxException
	 */
	public void mostraNoMapa() throws IOException, URISyntaxException {
		String nomeUrl = this.nome.replace(" ", "%20");
		Desktop.getDesktop().browse(new URI("https://www.google.com/maps/search/?api=1&query="+nomeUrl));
		}

	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome.toUpperCase();
	}
	
	/**
	 * Adiciona uma avaliacao na lista de avalia��es do lugar
	 * @param avaliacao
	 * @throws Exception
	 */
	public void addAvaliacao(int avaliacao) throws Exception{
		if(avaliacao < 0 || avaliacao > 5) {
			throw new RuntimeException("Avalia��o dever ter de 1 a 5 estrelas");
		}
		this.avaliacoes.add(avaliacao);
		
	}
	
	/**
	 * Calcula o total de avalia�oes que o lugar teve
	 * @return total de avalia��es
	 */
	public Integer totalDeAvaliacoes() {
		return this.avaliacoes.size();
	}
	
	/**
	 * Calcula a m�dia de avalia��es que o lugar teve
	 * @return m�dia de avalia��es
	 */
	public Double avaliacaoMedia() {
		return somaDasAvaliacoes()/totalDeAvaliacoes();
	}
	
	/**
	 * Calcula a doma de todas as avalia��es que o lugar teve
	 * @return soma de todas as avalia��es
	 */
	private Double somaDasAvaliacoes() {
		Double soma = 0d;
		for (Integer avaliacao : avaliacoes) {
			soma += avaliacao;
		}
		return soma;
	}
	
	/**
	 * Retorna o status da avalia��o
	 * @return
	 */
	public String avaliacaoStatus() {
		Double media = avaliacaoMedia();
		if (media < 3) {
			return "Ruim";
		}else if (media >= 3 && media <= 4) {
			return "Razoavel";
		}else if (media > 4) {
			return "Muito Bom";
		}else {
			return "Status n�o Implementado";
		}
		
	}
	
	@Override
	public String toString() {
		return "Nome: "+nome+"\n"
			 + "Total de Avalia��es: "+totalDeAvaliacoes()+"\n"
			 + "Media: "+ avaliacaoMedia()+"\n"
			 + "Status: "+ avaliacaoStatus();
	}
	
}
