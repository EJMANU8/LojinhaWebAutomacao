package Paginas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FormularioDeAdicaoDeProdutoPege {
    private WebDriver navegador;

    public FormularioDeAdicaoDeProdutoPege(WebDriver navegador) {
        this.navegador = navegador;

    }

    public FormularioDeAdicaoDeProdutoPege informarNomeDoProduto(String ProdutoNome) {
        navegador.findElement(By.id("produtonome")).sendKeys(ProdutoNome);

        return this;
    }

    public FormularioDeAdicaoDeProdutoPege informarvalorDoProduto(String produtoValor) {
        navegador.findElement(By.name("produtovalor")).sendKeys(produtoValor);

        return this;
    }

    public FormularioDeAdicaoDeProdutoPege informarCoresDoProduto(String produtoCores) {
        navegador.findElement(By.id("produtocores")).sendKeys(produtoCores);

        return this;
    }

    public ListaDeProdutosPage submeterFormularioDeAdicaoComErro() {
        navegador.findElement(By.cssSelector("button[type='submit'")).click();

        return new ListaDeProdutosPage(navegador);
    }
}
