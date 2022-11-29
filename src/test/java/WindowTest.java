import org.junit.jupiter.api.Test;
import org.openqa.selenium.WindowType;

public class WindowTest extends AbstractTest {
    @Test
    void test() throws InterruptedException{
        System.out.println(getDriver().getWindowHandle());
        String originalWindow = getDriver().getWindowHandle();

        getDriver().switchTo().newWindow(WindowType.WINDOW);// Открываем новое окно
        getDriver().navigate().to("https://www.google.com");// и в этом окне открываем страницу

        Thread.sleep(10000);
        getDriver().switchTo().window(originalWindow);

        for (String windowHandle: getDriver().getWindowHandles()){
            System.out.println(windowHandle);
        }
        getDriver().close();
    }
}
