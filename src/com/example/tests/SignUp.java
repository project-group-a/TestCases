package com.example.tests;

import static org.junit.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SignUp {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
	System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\Zach\\\\Documents\\\\aFall2018\\\\Software Engineering\\\\ProjectGroupA\\\\chromedriver_win32\\\\chromedriver.exe");
    driver = new ChromeDriver();
    baseUrl = "https://www.katalon.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testSignUp() throws Exception {
    driver.get("http://projectgroupa.ddns.net/welcome");
    driver.findElement(By.id("mat-input-2")).click();
    driver.findElement(By.id("mat-input-2")).clear();
    driver.findElement(By.id("mat-input-2")).sendKeys("test@test.com");
    driver.findElement(By.id("signUpUsername")).clear();
    driver.findElement(By.id("signUpUsername")).sendKeys("testtest");
    driver.findElement(By.id("mat-input-4")).clear();
    driver.findElement(By.id("mat-input-4")).sendKeys("test");
    driver.findElement(By.id("mat-input-5")).clear();
    driver.findElement(By.id("mat-input-5")).sendKeys("test");
    Thread.sleep(3000);
    driver.findElement(By.id("mat-input-5")).sendKeys(Keys.ENTER);
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
