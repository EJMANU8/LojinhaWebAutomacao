package Modulos.Produtos;

import Paginas.LoginPage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

@DisplayName("Testes Web do Modulo de Produtos")

public class ProdutosTest {

    private  WebDriver navegador;
    @BeforeEach
    public void beforeEach() {
        // Abri o Navegador
        System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver_win32\\chromedriver.exe");
        this.navegador = new ChromeDriver();

        //Maximixar tela
        this.navegador.manage().window().maximize();

        // Definir um tempo de espera de 5 segundos
        this.navegador.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        //Ir para a lojinha web
        navegador.get("http://165.227.93.41/lojinha-web/v2/");

    }
    @Test
    @DisplayName("Nao e permitido registrar um produto com valor zero")
    public void testNaoEPPermitidoRegistrarPprodutosComVvalorZero() {

        // Fazer Login
        String mensagemApresentado = new LoginPage(navegador)
                .informarOUsuario("admin")
                .informarASenha("admin")
                .submeterFormularioDeLogin()
                .acessarFormularioAdicaoNovoProduto()
                .informarNomeDoProduto("Consola PDC")
                .informarvalorDoProduto("000")
                .informarCoresDoProduto("azul, verde")
                .submeterFormularioDeAdicaoComErro()
                .capturarMensagemApresentado();

        Assertions.assertEquals("O valor do produto deve estar entre R$ 0,01 e R$ 7.000,00", mensagemApresentado);

    }

    @Test
    @DisplayName("Nao e Permitido Registar Produto Com Valor Acima De 7.000,00")
    public void testNaoEPermitidoRegistarProdutoComValorAcimaDeSeteMil() {

        String mensagemApresentada = new LoginPage(navegador)
                .informarOUsuario("admin")
                .informarASenha("admin")
                .submeterFormularioDeLogin()
                .acessarFormularioAdicaoNovoProduto()
                .informarNomeDoProduto("PS 5")
                .informarvalorDoProduto("700007")
                .informarCoresDoProduto("Laranja, Vermelho")
                .submeterFormularioDeAdicaoComErro()
                .capturarMensagemApresentado();

        Assertions.assertEquals("O valor do produto deve estar entre R$ 0,01 e R$ 7.000,00", mensagemApresentada);

    }

    @AfterEach
    public void afterEach() {
        // Fechar o navegador
        navegador.quit();

    }
}
