package com.example;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import com.se_project.ProjectWebApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ProjectWebApplication.class,properties = "server.port=9000", webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class LoginTest {
	WebDriver webDriver;
	
	@Before
	public void setUp(){
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Amr\\Downloads\\chromedriver_win32\\chromedriver.exe");
		webDriver = new ChromeDriver();
		
	}
	
	@Test
	public void loginTest(){
		webDriver.get("localhost:9000/");
		webDriver.findElement(By.linkText("LOG IN")).click();
		webDriver.findElement(By.name("username")).sendKeys("teacher");
		webDriver.findElement(By.name("password")).sendKeys("123456");
		webDriver.findElement(By.name("submit")).click();
		assertEquals("teacher", webDriver.findElement(By.id("username")).getText());
		
		webDriver.close();
	}
	
	
}
