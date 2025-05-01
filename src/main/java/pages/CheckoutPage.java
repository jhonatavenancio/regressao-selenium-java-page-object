package pages;

import org.openqa.selenium.WebDriver;

import utils.Actions;

public class CheckoutPage {

	private WebDriver driver;
	private Actions actions;

	public CheckoutPage(WebDriver driver) {
		this.driver = driver;
		this.actions = new Actions(this.driver);
	}

	public void enderecoEntrega(String rua, String numero, String bairro, String cep) {
		actions.escreverPegandoPeloId("input-endereco-rua", rua);
		actions.escreverPegandoPeloId("input-endereco-numero", numero);
		actions.escreverPegandoPeloId("input-endereco-bairro", bairro);
		actions.escreverPegandoPeloId("input-endereco-cep", cep);
	}
	
	public void dadosPagamento(String numeroCartao, String validade, String cvv, String nome) {
		actions.escreverPegandoPeloId("input-cartao-numero", numeroCartao);
		actions.escreverPegandoPeloId("input-cartao-validade", validade);
		actions.escreverPegandoPeloId("input-cartao-cvv", cvv);
		actions.escreverPegandoPeloId("input-cartao-nome", nome);
	}
	
	
	public void btnConfirmarPagamento() {
		actions.clicarBotaoPegandoPeloId("btn-confirmar-pagamento");
	}
	

}
