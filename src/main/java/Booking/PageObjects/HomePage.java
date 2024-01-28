package Booking.PageObjects;

import net.bytebuddy.implementation.bind.annotation.Super;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends GenricPage {

    @FindBy(css = "[class=\"c0528ecc22\"]")
    WebElement RegisterInterstatial;

    @FindBy(css="[class=\"c0528ecc22\"] span span")
    WebElement CloseRegister;

    @FindBy(xpath = "//*[@data-testid=\"header-sign-in-button\"]")
    WebElement SignBtn;



    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public void CloseRegisterPopup(int maxttowait) throws InterruptedException {
        try{
            wait(RegisterInterstatial,maxttowait);
            CloseRegister.click();
        }catch (Exception e){
            //screenshoot
            System.out.println(" Popup not occurs");
        }
    }

    public SignInPage signbtnclick(){

        SignBtn.click();
        return new SignInPage(driver);

    }





}
