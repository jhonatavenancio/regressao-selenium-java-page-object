# 🍽️ Testes Automatizados com Java + Selenium (Page Object)

Este projeto realiza testes automatizados em um sistema de **delivery de comida** semelhante ao iFood, utilizando as ferramentas **Java**, **Selenium WebDriver**, **JUnit 5** e **Faker** para geração de dados dinâmicos. Os testes são estruturados com o padrão **Page Object Model (POM)**, promovendo legibilidade e reutilização de código.

> 🔗 **Site do sistema testado:**  
> https://creative-boba-f63c57.netlify.app/restaurant/qa-king
> (Código do sistema no repositório)

---

## 📌 Funcionalidades testadas

O sistema simula um fluxo completo de um pedido de comida, passando por:

1. Seleção de um restaurante e itens do menu  
2. Adição de acréscimos e observações ao pedido  
3. Validação de preço no carrinho  
4. Preenchimento do endereço de entrega  
5. Pagamento com dados gerados por **Faker**  
6. Acompanhamento do status do pedido (em preparo, em entrega, entregue)

---

## 📁 Estrutura do Projeto

```plaintext
iComidas/
├── src/
│   ├── main/java/
│   │   ├── data/               # Dados como URL, cartão, endereço (alguns com Faker)
│   │   ├── drivers/            # Inicialização do WebDriver
│   │   ├── pages/              # Page Objects organizados por tela
│   │   ├── utils/              # Classe de Ações comuns e Logs
│   ├── test/java/
│   │   ├── tests/              # Classe principal de testes (PedidoTest)
│   │   ├── logs/               # Logs de execução gerados dinamicamente
├── pom.xml                     # Gerenciador de dependências (Maven)
```

---

## 🧪 Exemplo de Execução

Abaixo, um trecho dos testes com anotações de execução ordenada utilizando `@Order` do JUnit:

```java
@Test
@Order(1)
public void adicionarPedidoCarrinho() {
    restaurante.mcBugs(1);
    restaurante.selecionarAcrescimo(Arrays.asList("bacon", "molho especial", "borda recheada"));
    restaurante.observacao("Ao ponto, Por Favor!");
    restaurante.btnAdicionarCarrinho();
}
```

🗂️ Os testes seguem um fluxo ordenado de:

1. Adicionar item ao carrinho  
2. Finalizar carrinho  
3. Preencher endereço  
4. Preencher dados de pagamento  
5. Finalizar pedido  
6. Validar preparo  
7. Validar entrega

![image](https://github.com/user-attachments/assets/920690f5-55b8-47b3-a435-26b26e04683f)


---

## ⚙️ Tecnologias Utilizadas

- **Java 11+**
- **JUnit 5**
- **Selenium WebDriver**
- **Faker (Java Faker)**  
- **Maven** (para gerenciamento de dependências)
- **Log personalizado** (via classe `Log.java`)
- **Execução Headless configurável**

---


## 🧠 Boas práticas aplicadas

- Padrão **Page Object Model** para modularidade
- Uso de **JUnit 5 com ordenação explícita** (`@Order`)
- **Dados dinâmicos** gerados com **Faker**, evitando colisões e tornando os testes mais robustos
- **Execução configurável** via `Access.java` (modo headless, navegador, URL)
- **Logs customizados** por classe de teste, facilitando debugging

---

## 🤖 Sistema gerado por IA

O site testado é uma simulação de delivery criada por IA para fins educacionais e de teste. Nenhuma transação real ocorre.


