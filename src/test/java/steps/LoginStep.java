package steps;

import pages.LoginPage;
import utils.PropertyReader;

public class LoginStep {

    LoginPage loginPage;


    public LoginStep() {
        loginPage = new LoginPage();
    }

    public void login(String user, String password) {
        loginPage.openPage()
                .login(user, password);
    }
}
