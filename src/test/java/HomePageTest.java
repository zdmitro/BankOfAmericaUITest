import org.testng.annotations.Test;
import pages.HomePage;

import static data.Data.LOGIN;
import static data.Data.PASSWORD;

public class HomePageTest extends  BaseTest{

    @Test
    public void validHomeTest_OpenHomePage() {
        HomePage homePage = new HomePage(getDriver());
        homePage
                .goToHomePage()
                .checkForGoToHomePage();
    }

    @Test(priority = 1)
    public void LogIn() {
        HomePage homePage = new HomePage(getDriver());
        homePage
                .goToHomePage()
                .login(LOGIN,PASSWORD);
    }

    @Test(priority = 2)
    public void loginNegTest_BothFieldsBlank() {
        HomePage homePage = new HomePage(getDriver());
        homePage
                .goToHomePage()
                .login("","")
                .validateLoginError();
    }

    @Test(priority = 3)
    public void loginNetTest_PasswordFieldBlank() {
        HomePage homePage = new HomePage(getDriver());
        homePage
                .goToHomePage()
                .login("a","")
                .validatePasscodeError();
    }

    @Test(priority = 4)
    public void loginNegTest_IncorectLoginAndPassowrd() {
        HomePage homePage = new HomePage(getDriver());
        homePage
                .goToHomePage()
                .login("a","a")
                .isInnerElementVisible("The Online ID or Passcode you entered does not match our records. You have 2 more tries remaining.");
    }
}
