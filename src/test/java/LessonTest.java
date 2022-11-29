import org.checkerframework.checker.units.qual.C;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.time.Duration;

public class LessonTest extends AbstractTest {

    @Test
    void myActiontest()throws  InterruptedException{
        new WebDriverWait(getDriver(), Duration.ofSeconds(10)).until(ExpectedConditions.urlContains("https://www.vstu.ru"));
        //Assertions.assertTrue(getDriver().getTitle().contains("Университет"),"Страница входа недоступна");

        //Создадаим экземпляр класса Actions
        Actions search = new Actions(getDriver());

        search.click(getDriver().findElement(By.cssSelector(".sb-icon-search")))
                .pause(1000l)
                .sendKeys(getDriver().findElement(By.cssSelector(".sb-search-input")),"кравец")
                .pause(1000l)
                .click(getDriver().findElement(By.cssSelector(".sb-search-submit")))
                .build()
                .perform();

        Thread.sleep(1000);
    }
    //Пример с использованием java script
    @Test
    void jsTest()throws InterruptedException{
        JavascriptExecutor jsExecutor =(JavascriptExecutor) getDriver();
        long windiwWidth = (long) jsExecutor.executeScript("return window.innerWidth");
        System.out.println("Размер окна"+windiwWidth);
        jsExecutor.executeScript("window.scrollBy(0,500)");

        Thread.sleep(1000);
        getDriver().findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL,Keys.END); //Скорл на странице чтобы попасть в самый низ
    }
    //cookie
    @Test
    void cookieTest(){
        getDriver().manage().addCookie(new Cookie("Promo_code","november2"));//Добовляем cookie в браузер
        for (Cookie cookie: getDriver().manage().getCookies()){
            System.out.println(cookie.getName()+" "+cookie.getExpiry());
        }
        getDriver().manage().deleteCookie(new Cookie("Promo_code","november2"));
    }
    @Test
    @Disabled
    void voidTest(){
        WebElement voidElement = getDriver().findElement(By.cssSelector(".sb-icon-search"));

    }

}
