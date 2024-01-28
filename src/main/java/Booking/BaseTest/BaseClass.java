package Booking.BaseTest;

import Booking.PageObjects.HomePage;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class BaseClass {

    public BaseClass(){
            System.out.println("Base class got initated :");
    }

    public WebDriver driver;

    public HomePage homepage;
    public static Properties properties;


    static {
        try {
            properties =new Properties();
            properties.load(new FileReader("C:\\Users\\welcome\\IdeaProjects\\BookingAPP\\src\\main\\resources\\EnviromentVaraibles\\Global.properties"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Properties loaded ");
    }

    @BeforeMethod
    public void intialize(){
        String browser = properties.getProperty("Browser");
        if(browser.equalsIgnoreCase("Chrome")){
            driver=new ChromeDriver();
        }else{
            driver=new EdgeDriver();
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        driver.manage().window().maximize();
        driver.get(properties.getProperty("URL"));
        System.out.println("Browser intialized");
        homepage =new HomePage(driver);
    }

    @AfterMethod
    public void teardown(){
        driver.quit();
    }

    public void screenshot(String name, WebDriver driver,String Foldername) throws IOException {
        TakesScreenshot driver1 = (TakesScreenshot) driver;
        driver1.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(driver1.getScreenshotAs(OutputType.FILE),new File(System.getProperty("user.dir") +"/Reports/Screenshots/" +Foldername + "/" +name+".png"));

    }

}
