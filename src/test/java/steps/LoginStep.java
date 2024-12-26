package steps;

import pages.LoginPage;
import utils.PropertyReader;

public class LoginStep {

    LoginPage loginPage;
    String user = System.getProperty("user", PropertyReader.getProperty("user"));
    String password = System.getProperty("password", PropertyReader.getProperty("password"));

    public LoginStep() {
        loginPage = new LoginPage();
    }

    public void login() {
        loginPage.openPage()
                .login(user, password);
    }
}
