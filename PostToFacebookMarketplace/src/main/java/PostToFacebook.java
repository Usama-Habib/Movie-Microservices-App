import org.bouncycastle.jcajce.provider.asymmetric.EC;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.xml.datatype.Duration;
import java.util.concurrent.TimeUnit;



public class PostToFacebook {
    public static final String baseUrl = "https://www.facebook.com";
    public static final String fbNewVehicle = "https://www.facebook.com/marketplace/create/vehicle";
    public static final String chromeDriverLoc = "C:\\WebDriver\\bin\\chromedriver.exe";

    public static void main(String[] args) throws InterruptedException {

        // Setting system properties of ChromeDriver
        System.setProperty("webdriver.chrome.driver",chromeDriverLoc);

        // Creating an object of ChromeDriver
        WebDriver webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();

        //Deleting all the cookies
        webDriver.manage().deleteAllCookies();

        //Specifiying pageLoadTimeout and Implicit wait
        webDriver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        webDriver.get(baseUrl);
        webDriver.findElement(By.id("email")).sendKeys("03113300054");
        webDriver.findElement(By.id("pass")).sendKeys("log500900500");
        Thread.sleep(5000);
        webDriver.findElement(By.name("login")).click();
        Thread.sleep(7000);
        webDriver.navigate().to(fbNewVehicle);

        if(webDriver.getCurrentUrl().equalsIgnoreCase(fbNewVehicle)){
            System.out.println(webDriver.getPageSource());
            webDriver.close();
        }else{
            System.out.println(webDriver.getPageSource());
        }

    }
}
