package experiments;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class CssSelectors {
    WebDriver driver = new ChromeDriver();

    @Test
    public void selectorsHomePage() {
        //driver.navigate().to("https://demoqa.com/");
        //driver.navigate().back();
        driver.get("https://demoqa.com/");
        driver.manage().window().maximize();
        hideBanner();
        hideFooter();

        pause(3);

        WebElement imgTools = driver.findElement(By.cssSelector("img[src='/images/Toolsqa.jpg']"));
        System.out.println(imgTools.getTagName());
        System.out.println(imgTools.getAttribute("src"));

        WebElement footer = driver.findElement(By.tagName("footer"));
        pause(5);
        WebElement divElements = driver.findElement(By.cssSelector(".card-up"));
        divElements.click();

        pause(5);
        //driver.close();
        driver.quit();
    }

    public void pause(int time) {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void hideBanner() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.querySelector('#fixedban').style.display='none'");
    }

    public void hideFooter() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.querySelector('footer').style.display='none'");
    }

}
