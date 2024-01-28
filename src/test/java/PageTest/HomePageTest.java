package PageTest;

import Booking.BaseTest.BaseClass;

import Booking.Listeners.ReportConfiguration;
import Booking.PageObjects.SignInPage;
import GenericUtils.ExcelTestDataGenerator;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class HomePageTest extends BaseClass {
    HomePageTest(){
        super();
    }

       SignInPage Signinpage;

   // @Test
    public void launchbrowser() throws InterruptedException {
        System.out.println("first test");
        homepage.CloseRegisterPopup(3);
        homepage.signbtnclick();

    }

    @DataProvider
    public Object[][] LoginData() throws IOException, InvalidFormatException {
       return ExcelTestDataGenerator.excelTestDataGenerator("LoginTestData");
    }


    @Test(dataProvider="LoginData")
    public void Loginwithvalidcredentials(String username ,String password) throws InterruptedException, IOException {
        homepage.CloseRegisterPopup(3);
        Signinpage= homepage.signbtnclick();
        Signinpage.SiginWithUserandPass(username,password);
        Signinpage.passlogin();
    }


}
