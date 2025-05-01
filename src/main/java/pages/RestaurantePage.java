package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;

import utils.Actions;
import utils.Log;

public class RestaurantePage {

	private WebDriver driver;
	private Actions actions;

	public RestaurantePage(WebDriver driver) {
		this.driver = driver;
		this.actions = new Actions(this.driver);
	}

	public void qaKing(int prato) {
		actions.clicarBotaoPegandoPeloId("restaurante-qa-king");
		actions.esperar(500);
		
		switch (prato) {
		case 1:
		default:
			actions.clicarBotaoPegandoPeloId("item-hamburguer-hamburger-test");
			break;
		case 2:
			actions.clicarBotaoPegandoPeloId("item-hamburguer-double-debug-burger");
			break;
		case 3:
			actions.clicarBotaoPegandoPeloId("item-refeicao-qa-meal-box");
			break;
		}
	}
	
	public void mcBugs(int prato) {
		actions.clicarBotaoPegandoPeloId("restaurante-mc-bugs");
		actions.esperar(500);
		
		switch (prato) {
		case 1:
		default:
			actions.clicarBotaoPegandoPeloId("item-hamburguer-bug-deluxe");
			break;
		case 2:
			actions.clicarBotaoPegandoPeloId("item-hamburguer-chicken-exception");
			break;
		case 3:
			actions.clicarBotaoPegandoPeloId("item-refeicao-combo-nullpointer");
			break;
		}
	}
	
	public void tests(int prato) {
		actions.clicarBotaoPegandoPeloId("restaurante-tests");
		actions.esperar(500);
		
		switch (prato) {
		case 1:
		default:
			actions.clicarBotaoPegandoPeloId("item-pizza-pizza-unit-test");
			break;
		case 2:
			actions.clicarBotaoPegandoPeloId("item-pizza-pizza-integration");
			break;
		case 3:
			actions.clicarBotaoPegandoPeloId("item-massas-pasta-system");
			break;
		}
	}
	
	public void categorias(String opcao) {

		switch (opcao) {
		case "pizza":
		default:
			actions.clicarBotaoPegandoPeloId("categoria-pizza");
			break;
		case "hamburguer":
			actions.clicarBotaoPegandoPeloId("categoria-hamburguer");
			break;
		case "massas":
			actions.clicarBotaoPegandoPeloId("categoria-massas");
			break;
		case "salada":
			actions.clicarBotaoPegandoPeloId("categoria-salada");
			break;
		case "doces":
			actions.clicarBotaoPegandoPeloId("categoria-doces");
			break;	
		case "refeicao":
			actions.clicarBotaoPegandoPeloId("categoria-refeicao");
			break;	
			
		}
	}
	
	public void observacao(String obs) {
		actions.escreverPegandoPeloId("observacao-pedido", obs);
	}
	
	public void btnAdicionarCarrinho() {
		actions.clicarBotaoPegandoPeloId("btn-adicionar-carrinho");
	}
	
	public void selecionarAcrescimo(List<String> acrescimos) {
		for (String acrescimo : acrescimos) {
			switch (acrescimo.toLowerCase()) {
				case "queijo extra":
					actions.clicarBotaoPegandoPeloId("acrescimo-queijo-extra");
					break;
				case "bacon":
					actions.clicarBotaoPegandoPeloId("acrescimo-bacon");
					break;
				case "cebola caramelizada":
					actions.clicarBotaoPegandoPeloId("acrescimo-cebola-caramelizada");
					break;
				case "molho especial":
					actions.clicarBotaoPegandoPeloId("acrescimo-molho-especial");
					break;
				case "borda recheada":
					actions.clicarBotaoPegandoPeloId("acrescimo-borda-recheada");
					break;
				case "azeitona":
					actions.clicarBotaoPegandoPeloId("acrescimo-azeitona");
					break;
				default:
					Log.registrar("Acréscimo não reconhecido: " + acrescimo);
			}
		}
	}

}
