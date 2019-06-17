
import com.google.common.io.Resources;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.BeforeClass;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.*;
import java.net.URL;
import java.util.Properties;

import static io.github.bonigarcia.wdm.DriverManagerType.CHROME;
import static org.junit.Assert.assertEquals;


public class LoginTest {
    private WebDriver driver;
    Properties prop = new Properties();
    @BeforeClass
    public static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @Before
    public void setupTest() {
        driver = new ChromeDriver();
    }

    @Test
    public void Login(){

        URL url = Resources.getResource("properties.properties");

        try (InputStream input = new FileInputStream(url.getPath())) {



            // load a properties file
            prop.load(input);

            // get the property value and print it out
            System.out.println(prop.getProperty("prop1"));


        } catch (IOException ex) {
            ex.printStackTrace();
        }
    //Step 1- Driver Instantiation: Instantiate driver object as FirefoxDriver
        WebDriverManager.getInstance(CHROME).setup();
        String x = prop.getProperty("prop1");
        //Step 2- Navigation: Open a website
        driver.navigate().to(x);

        //Step 3- Assertion: Check its title is correct
        //assertEquals method Parameters: Expected Value, Actual Value, Assertion Message
            //assertEquals("Title check failed!","Software Test Academy", driver.getTitle());

        //Step 4- Close Driver
        driver.close();

        //Step 5- Quit Driver
        driver.quit();

    }
}
