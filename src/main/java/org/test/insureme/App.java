package org.test.insureme;

import java.io.File;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws InterruptedException, IOException
    {
        System.out.println( "script started" );
        WebDriverManager.chromedriver().setup();
      
       // System.setProperty("webdriver.chrome.driver","C:/Users/SRI RAKSHA/Downloads/chromedriver-win64/chromedriver.exe");
        //System.setProperty("webdriver.chrome.driver","/usr/bin/chromedriver");
        ChromeOptions chromeOptions = new ChromeOptions();
       chromeOptions.addArguments("--headless");
        System.out.println("Driver opening up the url in browser");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.get("http://18.212.237.110:8081/contact.html");
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        System.out.println("Enter details in the form");
        driver.findElement(By.id("inputName")).sendKeys("sam");
        Thread.sleep(1000);
        driver.findElement(By.id("inputNumber")).sendKeys("8964527364");
        driver.findElement(By.id("inputMail")).sendKeys("sam@xyz.com");
        driver.findElement(By.id("inputMessage")).sendKeys("hello");
        driver.findElement(By.id("my-button")).click();
        String response = driver.findElement(By.id("response")).getText();
        System.out.println(response);
        System.out.println("test script executed");
        TakesScreenshot scrShot = ((TakesScreenshot)driver);
        File scrFile = scrShot.getScreenshotAs(OutputType.FILE);
        File destFile = new File(" /var/lib/jenkins/workspace/insureme-test-scripts/test-report.jpg");
        FileUtils.copyFile(scrFile,destFile);
        
           
        driver.quit();
        
        
        
        
    }

	
	}

