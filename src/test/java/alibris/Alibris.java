package alibris;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
public class Alibris {
    private WebDriver driver;
    private Map<String, Object> vars;
    JavascriptExecutor js;
    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "drivers/chrome/90/chromedriver.exe");
        driver = new ChromeDriver();
        js = (JavascriptExecutor) driver;
        vars = new HashMap<String, Object>();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(6000, TimeUnit.MILLISECONDS);
    }
    @After
    public void tearDown() {
        driver.quit();
    }
    @Test
    public void testealibri() {
        driver.get("https://www.alibris.com/");

        driver.findElement(By.id("searchBox")).click();
        driver.findElement(By.id("searchBox")).sendKeys("the art of software testing");
        driver.findElement(By.id("searchBox")).sendKeys(Keys.ENTER);
        assertThat(driver.findElement(By.cssSelector("li:nth-child(1) > .right .price")).getText(), is("$1.45"));
    }
}
