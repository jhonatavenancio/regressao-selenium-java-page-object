package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.Actions;

public class PedidoPage {

	private WebDriver driver;
	private Actions actions;

	public PedidoPage(WebDriver driver) {
		this.driver = driver;
		this.actions = new Actions(this.driver);
	}

	public void validarMensagemPreparo(String msg) {
		actions.validarTextoElementoContens(By.cssSelector("#root > div > main > div > div > div.animate-pulse.mb-12 > p"), msg);
		actions.esperar(35000);
	}
	
	public void validarEntregaSendoRealizada (String msg) {
		actions.validarTextoElementoContens(By.cssSelector(".text-lg"), msg);
	}
	
	public void validarPedidoEntregue(String msg) {
		actions.esperar(10000);
		actions.validarTextoElementoContens(By.id("mensagem-pedido-entregue"), msg);
	}
}
