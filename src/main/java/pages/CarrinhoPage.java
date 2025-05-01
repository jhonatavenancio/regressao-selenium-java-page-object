package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.Actions;

public class CarrinhoPage {

	private WebDriver driver;
	private Actions actions;

	public CarrinhoPage(WebDriver driver) {
		this.driver = driver;
		this.actions = new Actions(this.driver);
	}

	public void btnFinalizarPedido() {
		actions.clicarBotaoPegandoPeloId("btn-finalizar-pedido");
	
	}
	
	public void validarPreco(String preco) {
		actions.validarTextoElementoContens(By.cssSelector("#root > div > main > div > div.bg-white.rounded-lg.shadow-md.overflow-hidden.mb-6 > div.bg-gray-50.px-6.py-4 > div > span.text-xl.text-red-600"), preco);
		
	}
	
}
