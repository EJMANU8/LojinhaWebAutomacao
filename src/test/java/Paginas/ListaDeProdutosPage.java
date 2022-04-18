package Paginas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ListaDeProdutosPage {

    private WebDriver navegador;

    public ListaDeProdutosPage(WebDriver navegador){
        this.navegador = navegador;

    }

    public FormularioDeAdicaoDeProdutoPege acessarFormularioAdicaoNovoProduto() {
        navegador.findElement(By.linkText("ADICIONAR PRODUTO")).click();

        return new FormularioDeAdicaoDeProdutoPege(navegador);
    }

    public  String capturarMensagemApresentado() {
        return navegador.findElement(By.cssSelector(".toast.rounded")).getText();
    }
}
