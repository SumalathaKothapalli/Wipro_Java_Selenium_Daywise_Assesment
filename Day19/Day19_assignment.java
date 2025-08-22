package Sele_pacakage;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day19_assignment {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.saucedemo.com/");
        Thread.sleep(2000);

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        Thread.sleep(2000);

        if(driver.getCurrentUrl().contains("inventory")) System.out.println("Login Test Passed");
        else System.out.println("Login Test Failed");

        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        Thread.sleep(1000);

        int cartCount = driver.findElements(By.className("shopping_cart_badge")).size();
        if(cartCount > 0) System.out.println("Add to Cart Test Passed");
        else System.out.println("Add to Cart Test Failed");

        driver.findElement(By.className("shopping_cart_link")).click();
        Thread.sleep(2000);

        driver.findElement(By.id("checkout")).click();
        Thread.sleep(2000);

        driver.findElement(By.id("first-name")).sendKeys("John");
        driver.findElement(By.id("last-name")).sendKeys("Doe");
        driver.findElement(By.id("postal-code")).sendKeys("12345");
        driver.findElement(By.id("continue")).click();
        Thread.sleep(2000);

        driver.findElement(By.id("finish")).click();
        Thread.sleep(2000);

        String confirmText = driver.findElement(By.className("complete-header")).getText();
        if(confirmText.contains("THANK YOU FOR YOUR ORDER")) System.out.println("Checkout Test Passed");
        else System.out.println("Checkout Test Failed");

        driver.findElement(By.id("react-burger-menu-btn")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("logout_sidebar_link")).click();
        Thread.sleep(2000);

        if(driver.getCurrentUrl().contains("saucedemo.com")) System.out.println("Logout Test Passed");
        else System.out.println("Logout Test Failed");

        driver.quit();
    }
}
