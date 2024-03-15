package Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;

public class CommonHelper {
	
	
	
	private static CommonHelper commonHelper;
    
    private static WebDriver driver;
    public final static int TIMEOUT = 5;
       
     private CommonHelper() {
            
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TIMEOUT));
     }      
               
    public static void openPage(String url) {
        driver.get(url);
    }
           
    public static WebDriver getDriver() {
        return driver;              
    }
       
    public static void setUpDriver() {
           
        if (commonHelper==null) {
               
        	commonHelper = new CommonHelper();
        }
    }
       
    public static void tearDown() {
            
        if(driver!=null) {
             driver.close();
             driver.quit();
        }
            
        commonHelper = null;
   } 
       
}

