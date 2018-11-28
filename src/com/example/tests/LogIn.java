package com.example.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LogIn {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
	  System.setProperty("webdriver.chrome.driver", "D:\\UNO\\Fall 2018\\Software Engineering\\P8\\chromedriver_win32\\chromedriver.exe");
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
    Thread.sleep(2000);
  }
  
  @Test
  public void testLogIn() throws Exception {
    driver.get("http://projectgroupa.ddns.net/welcome");
    driver.findElement(By.id("mat-input-0")).clear();
    driver.findElement(By.id("mat-input-0")).sendKeys("test");
    driver.findElement(By.id("mat-input-1")).clear();
    driver.findElement(By.id("mat-input-1")).sendKeys("test");
    Thread.sleep(3000);
    driver.findElement(By.id("mat-input-1")).sendKeys(Keys.ENTER);
    Thread.sleep(2000);
  }
  
  @Test
  public void testAbout() throws Exception {
    driver.get("http://projectgroupa.ddns.net/welcome");
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Home'])[1]/following::span[2]")).click();
    Thread.sleep(3000);
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='GitHub Repo'])[1]/following::span[1]")).click();
    Thread.sleep(2000);
  }
  
  @Test
  public void testAddEventMenu() throws Exception {
    driver.get("http://projectgroupa.ddns.net/welcome");
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='About'])[1]/following::figure[1]")).click();
    driver.findElement(By.id("mat-input-0")).click();
    driver.findElement(By.id("mat-input-0")).clear();
    driver.findElement(By.id("mat-input-0")).sendKeys("test");
    driver.findElement(By.id("mat-input-1")).clear();
    driver.findElement(By.id("mat-input-1")).sendKeys("test");
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='About'])[1]/following::mat-card[1]")).click();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Encrypted with UTF-8!'])[1]/following::button[2]")).click();
    Thread.sleep(2000);
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Day'])[1]/following::span[1]")).click();
    Thread.sleep(2000);
    assertEquals("Add Event", driver.findElement(By.id("mat-dialog-title-0")).getText());
    Thread.sleep(2000);
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='End Date'])[1]/following::span[3]")).click();
    Thread.sleep(2000);
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='About'])[1]/following::span[1]")).click();
    Thread.sleep(2000);
  }
  
  @Test
  public void testEventListView() throws Exception {
    driver.get("http://projectgroupa.ddns.net/welcome");
    driver.findElement(By.id("mat-input-0")).click();
    driver.findElement(By.id("mat-input-0")).clear();
    driver.findElement(By.id("mat-input-0")).sendKeys("test");
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='About'])[1]/following::mat-card[1]")).click();
    driver.findElement(By.id("mat-input-1")).click();
    driver.findElement(By.id("mat-input-1")).clear();
    driver.findElement(By.id("mat-input-1")).sendKeys("test");
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Encrypted with UTF-8!'])[1]/following::mat-card-actions[1]")).click();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Encrypted with UTF-8!'])[1]/following::span[1]")).click();
    Thread.sleep(2000);
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Calendar'])[1]/following::span[1]")).click();
    Thread.sleep(2000);
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Calendar'])[1]/following::span[1]")).click();
    Thread.sleep(2000);
    assertEquals("EditChange", driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Logout'])[1]/following::mat-panel-title[1]")).getText());
    Thread.sleep(2000);
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Home'])[1]/following::button[1]")).click();
    Thread.sleep(2000);
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='About'])[1]/following::button[1]")).click();
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
