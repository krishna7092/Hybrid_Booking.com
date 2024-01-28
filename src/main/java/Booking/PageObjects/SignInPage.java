package Booking.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class SignInPage extends GenricPage{

    SignInPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver,this);

    }


    @FindBy(id = "username")
    WebElement Username;

    @FindBy(xpath ="//button[@type=\"submit\"]")
    WebElement SignInbutton;

    @FindBy(name = "password")
    WebElement password;



    public void SiginWithUserandPass(String email,String Password) throws IOException {
        Username.sendKeys(email);
        screenshot("usernameentered",driver,"Evidence");
        SignInbutton.click();
        wait(password);
        password.sendKeys(Password);

    }

    public void passlogin(){
        SignInbutton.click();
    }
}
