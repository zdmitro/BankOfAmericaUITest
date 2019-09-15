package pages;

import data.Data;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HomePage extends BasePage {

    private By header = By.xpath("//*[@id='navChecking']/span[2]");

    private By loginField = By.xpath("//*[@id='onlineId1']");
    private By passwordField = By.xpath("//*[@id='passcode1']");
    private By loginBtn = By.xpath("//*[@id='signIn']");
    private By loginErrorMessage = By.id("signin-message");
    private By passcodeErrorMessage = By.id("signin-message");
   // private By incorrectLoginMessage = By.xpath("/html/body/div[1]/div/div/div[1]/div[4]/div[2]/div/li/text()[1]");

    private By incorrectLoginMessage = By.xpath("//*[@id'Vipaa_Action_0']");

    public HomePage(WebDriver driver) {
        super(driver);
    }
    public HomePage goToHomePage() {
        getDriver().get(Data.URL);
        return this;
    }

    public HomePage checkForGoToHomePage() {
        List<String> navMenuList = new ArrayList<>();

        List<WebElement> navList = getDriver().findElements(By.className("main-nav-top-large"));
        WebElement e = navList.get(0);
        List<WebElement> ulList = e.findElements(By.tagName("ul"));
        List<WebElement> liList = ulList.get(0).findElements(By.tagName("li"));

        String text = ""; //Initialize string text, so we do not have to do it inside for

        for (WebElement element : liList) {
            text = element.getText();
            navMenuList.add(text);
        }

        List<String> expectedNavMenuList = Arrays.asList(
                "Personal", "Small Business", "Wealth Management", "Businesses & Institutions", "About Us");

        System.out.println();

        //assertEquals();
        return this;
    }

    public HomePage login(String login, String password) {

        writeText(this.loginField, login);
        writeText(this.passwordField, password);
        click(this.loginBtn);

        return this;
    }

    public HomePage validateLoginError() {
        assertEquals(this.loginErrorMessage,"Your Online ID is missing. Please try again.");
        return this;
    }

    public HomePage validatePasscodeError() {
        assertEquals(this.passcodeErrorMessage,"Your Passcode is missing. Please try again.");
        return this;
    }

    public HomePage validateIncorrectLoginInfoError() {
        assertEquals(this.incorrectLoginMessage,"The Online ID or Passcode you entered does not match our records. You have 2 more tries remaining.");
        return this;
    }

    public HomePage isInnerElementVisible(String text) {
        WebElement a = getDriver().findElement(incorrectLoginMessage).findElement(By.tagName("li"));
        String tagText = a.getText();
        Assert.assertEquals(tagText, text);
        return this;
    }

}
