package tests;

import java.util.Arrays;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.openqa.selenium.WebDriver;

import data.Access;
import data.Info;
import drivers.Browser;
import pages.CheckoutPage;
import pages.RestaurantePage;
import pages.CarrinhoPage;
import pages.PedidoPage;
import utils.Actions;
import utils.Log;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PedidoTest {
	private static WebDriver driver;
	private static Actions actions;
	private static CheckoutPage checkout;
	private static RestaurantePage restaurante;
	private static CarrinhoPage carrinho;
	private static PedidoPage pedido;

	@BeforeAll
	public static void antes() {
		Log.criarArquivoLog("Log.PedidoTest");

		driver = Browser.iniciarNavegador(Access.navegador, Access.headless);
		driver.get(Access.url);
		actions = new Actions(driver);
		checkout = new CheckoutPage(driver);
		restaurante = new RestaurantePage(driver);
		carrinho = new CarrinhoPage(driver);
		pedido = new PedidoPage(driver);
	}

	@AfterAll
	public static void depois() {
		Browser.fecharNavegador(Access.fecharNavegador);
		Log.encerrarLog();
	}

	@Test
	@Order(1)
	public void adicionarPedidoCarrinho() {
		Log.registrar(" TESTE REALIZADO - Adicionar Pedido ao Carrinho");

		restaurante.mcBugs(1);
		restaurante.selecionarAcrescimo(Arrays.asList("bacon", "molho especial", "borda recheada"));
		restaurante.observacao("Ao ponto, Por Favor!");
		restaurante.btnAdicionarCarrinho();
	}

	@Test
	@Order(2)
	public void confirmarPedidoCarrinho() {
		Log.registrar(" TESTE REALIZADO - Confirmar Pedido no Carrinho");
		carrinho.validarPreco("35.96");
		carrinho.btnFinalizarPedido();
	}

	@Test
	@Order(3)
	public void preencherEnderecoEntrega() {
		Log.registrar(" TESTE REALIZADO - Preencher Endereço da Entrega");

		actions.esperar(0); 
		checkout.enderecoEntrega(
			Info.rua,
			Info.numero,
			Info.bairro,
			Info.CEP
		);
	}

	@Test
	@Order(4)
	public void preencherDadosPagamento() {
		Log.registrar(" TESTE REALIZADO - Preencher Dados de Pagamento");

		checkout.dadosPagamento(
			Info.numeroCartaoCredito,
			Info.vencimento,
			Info.CVV,
			Info.nomeCartao
		);
	}

	@Test
	@Order(5)
	public void finalizarPedido () {
		checkout.btnConfirmarPagamento();
		
		pedido.validarMensagemPreparo("Nosso chef está preparando seu pedido");
	}

	@Test
	@Order(6)
	public void validarPreparoPedido () {
		pedido.validarEntregaSendoRealizada("Seu pedido está a caminho!");
	}

	@Test
	@Order(7)
	public void entregando () {
		pedido.validarPedidoEntregue("Pedido entregue com sucesso!");
	}
}
