package data;

import com.github.javafaker.Faker;

import java.time.LocalDate;
import java.util.Locale;
import java.util.Random;

public class Info {

    private static final Faker faker = new Faker(new Locale("pt-BR"));
    private static final Random random = new Random();

    // Endereço
    public static final String rua = faker.address().streetName();
    public static final String numero = faker.address().buildingNumber();
    public static final String bairro = faker.address().cityName();
    public static final String CEP = gerarCEP();

    // Cartão de Crédito
    public static final String numeroCartaoCredito = gerarNumeroCartaoCredito();
    public static final String vencimento = gerarDataVencimentoCartao();
    public static final String CVV = gerarCVV();
    public static final String nomeCartao = faker.name().fullName();

    private static String gerarCEP() {
        return faker.address().zipCode(); // XXXXX-XXX
    }

    private static String gerarNumeroCartaoCredito() {
        String numero;
        do {
            numero = faker.finance().creditCard().replaceAll("[^0-9]", "");
        } while (numero.length() != 16);
        return numero;
    }


    private static String gerarDataVencimentoCartao() {
        int mes = random.nextInt(12) + 1;
        int ano = LocalDate.now().getYear() % 100 + random.nextInt(5) + 1; // MM/AA
        return String.format("%02d/%02d", mes, ano);
    }

    private static String gerarCVV() {
        return String.format("%03d", random.nextInt(1000)); // 000–999
    }

}
