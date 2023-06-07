package HWSeleniumClass7;

import Utils.CommonMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task1 extends CommonMethods {

    public static void main(String[] args) {


        //specify path to chromedriver executable file
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");

        //create an instance of ChromeDriver
        WebDriver driver = new ChromeDriver();

        //navigate to login page
        driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");

        //locate and enter the username and password fields
        WebElement usernameField = driver.findElement(By.id("txtUsername"));
        usernameField.sendKeys("Admin");
        WebElement passwordField = driver.findElement(By.id("txtPassword"));
        passwordField.sendKeys("Hum@nhrm123");
        //locate and click the login button
        WebElement loginButton = driver.findElement(By.id("btnLogin"));
        loginButton.click();

        //locate and click the PIM button
        WebElement PIMButton = driver.findElement(By.id("menu_pim_viewPimModule"));
        PIMButton.click();
        //locate the table and get the number of rows
        WebElement table = driver.findElement(By.id("resultTable"));
        int rowCount = table.findElements(By.tagName("tr")).size();

        //iterate over the rows to find the desired row
        for (int i = 1; i < rowCount; i++) {
            WebElement row = driver.findElement(By.xpath("//table[@id='resultTable']/tbody/tr[" + i + "]"));
            if (row.getText().contains("desiredID")) {
                System.out.println("The row for ID desiredID is: " + i);
                break;
            }
        }
        //close the browser
        driver.quit();














    }
}
