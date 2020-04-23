package Utils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
public class Driver {
    private static WebDriver driver;
    private Driver(){}
    public static WebDriver getDriver(String driverName)  {
        if(driver==null){
            switch (driverName){
                case "chrome":
//                    WebDriverManager.chromedriver().setup();
//                    driver=new ChromeDriver();
                    try{
                        String nodeUrl="http://13.59.23.13:5555/wd/hub";
                        //chrome driver file location inEC2 machine
                        File file=new File("C:\\Users\\Administrator\\Downloads.exe");
                        System.setProperty("webdriver.chrome.driver",file.getAbsolutePath());
                        DesiredCapabilities cap=DesiredCapabilities.chrome();
                        cap.setBrowserName("chrome");
                        cap.setPlatform(Platform.ANY);
                        driver=new RemoteWebDriver(new URL(nodeUrl),cap);
                    }catch (MalformedURLException e){
                        e.printStackTrace(); }
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver=new FirefoxDriver();
                    break;
                default:
                    WebDriverManager.chromedriver().setup();
                    driver=new ChromeDriver();
                    break; } }
        return driver;
    }
}