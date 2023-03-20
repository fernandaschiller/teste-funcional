package ada.funcional;

import io.cucumber.java.After;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class StepDefinitions {

    WebDriver driver;

    @After()
    public void closeBrowser() {
        driver.quit();
    }

    @Dado("que usuario acessa pagina home")
    public void que_usuario_acessa_pagina_home() {
        System.setProperty("webdriver.http.factory", "jdk-http-client");

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.google.com");
        driver.findElement(By.id("W0wltc")).click();
    }
    @Quando("digitar {string}")
    public void digitar(String palavra) {
        driver.findElement(By.name("q")).sendKeys(palavra);
    }
    @Quando("clicar no botao pesquisar")
    public void clicar_no_botao() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.className("gNO89b")).click();
    }
    @Entao ("deve retornar {string}")
    public void deve_retornar(String palavra) throws InterruptedException {
        Thread.sleep(4000);
        String title = driver.getTitle();
        Assertions.assertTrue(title.contains(palavra));
    }

    @Quando("submeter formulário")
    @E("teclar enter")
    public void teclar_enter() {
        driver.findElement(By.className("gNO89b")).submit();
    }

}
