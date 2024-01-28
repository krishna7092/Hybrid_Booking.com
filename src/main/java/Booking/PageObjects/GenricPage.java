package Booking.PageObjects;

import Booking.BaseTest.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;

public class GenricPage extends BaseClass {
    WebDriverWait explicitwait;

    WebDriver driver;


    public GenricPage(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(this.driver,this);
        System.out.println("Generic initalized            >>>>>>>>>>>>>>>>>          " + "BASE class driver :" +super.driver);

        explicitwait =new WebDriverWait(this.driver,Duration.ofSeconds(4));
    }

    protected void wait(WebElement element,int maxsec){
        explicitwait =new WebDriverWait(this.driver,Duration.ofSeconds(maxsec));
        explicitwait.until(ExpectedConditions.visibilityOf(element));

    }

    protected void wait(WebElement element){
        explicitwait =new WebDriverWait(this.driver,Duration.ofSeconds(3));
        explicitwait.until(ExpectedConditions.visibilityOf(element));

    }
}
