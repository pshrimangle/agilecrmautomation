package com.agileCrmautomation;

import com.AgileCrmAutomation.BaseClass;
import com.AgileCrmAutomation.LoginPage;

public class LoginAgileCrmTestCase extends BaseClass{

	public static void main(String[] args) {
	 LoginAgileCrmTestCase login=new LoginAgileCrmTestCase();
	 login.launchBrowser("chrome");
	 driver.navigate().to("https://testingqa.agilecrm.com/login");
	 LoginPage loginpage=new LoginPage();
	 loginpage.login("Test@Test1234", "Test1234");
	 loginpage.login("2648%#$$@1234", "#^#^#^%$$");
	 loginpage.login("2648%#$$@1234", "#^#^#^%$$");

	}

}
