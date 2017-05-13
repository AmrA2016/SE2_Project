package com.example;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.ArrayList;

import org.apache.xalan.xsltc.compiler.sym;
import org.aspectj.lang.annotation.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.se_project.ProjectWebApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ProjectWebApplication.class,properties = "server.port=9000", webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class CreateGameTest {

	WebDriver webDriver;
		
	@Before
	public void setUp(){
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Amr\\Downloads\\chromedriver_win32\\chromedriver.exe");
		webDriver = new ChromeDriver();
		webDriver.get("localhost:9000/");
		webDriver.findElement(By.linkText("LOG IN")).click();
		webDriver.findElement(By.name("username")).sendKeys("teacher");
		webDriver.findElement(By.name("password")).sendKeys("123456");
		webDriver.findElement(By.name("submit")).click();
		
		webDriver.findElement(By.linkText("Create new Course")).click();
		webDriver.findElement(By.id("image")).sendKeys("C:\\Users\\Amr\\Pictures\\Banner.jpg");
		webDriver.findElement(By.name("name")).sendKeys("CourseTestingOnly");
		webDriver.findElement(By.id("disc")).sendKeys("This course created automatically by selenium testing");
		webDriver.findElement(By.id("Age")).clear();
		webDriver.findElement(By.id("Age")).sendKeys("15");
		new Select(webDriver.findElement(By.id("category"))).selectByValue("Math");
		webDriver.findElement(By.name("submit")).click();
		
	}
	
	@Test
	public void TestCreateTFGame(){
		webDriver.findElement(By.id("createTFGame")).click();
		webDriver.findElement(By.id("name")).sendKeys("GameTestingOnly");
		webDriver.findElement(By.id("disc")).sendKeys("This game created automatically by selenium testing");
		webDriver.findElement(By.id("image")).sendKeys("C:\\Users\\Amr\\Pictures\\Banner.jpg");
		webDriver.findElement(By.linkText("Add new Question")).click();
		webDriver.findElement(By.linkText("Add new Question")).click();
		webDriver.findElement(By.linkText("Add new Question")).click();
		webDriver.findElement(By.id("question1Title")).sendKeys("TestingQuestion1");
		webDriver.findElement(By.id("question2Title")).sendKeys("TestingQuestion2");
		new Select (webDriver.findElement(By.id("question2Answer"))).selectByValue("false");
		webDriver.findElement(By.id("question3Title")).sendKeys("TestingQuestion3");
		
		webDriver.findElement(By.name("submit")).click();
		assertEquals("GameTestingOnly",webDriver.findElement(By.id("game_name")).getText());
		
//		webDriver.findElement(By.linkText("Delete Course")).click();
		webDriver.close();
	}
	
	@Test
	public void TestCreateMCQGame(){
		webDriver.findElement(By.id("createMCQGame")).click();
		webDriver.findElement(By.id("name")).sendKeys("GameTestingOnly");
		webDriver.findElement(By.id("disc")).sendKeys("This game created automatically by selenium testing");
		webDriver.findElement(By.id("image")).sendKeys("C:\\Users\\Amr\\Pictures\\Banner.jpg");
		webDriver.findElement(By.linkText("Add new Question")).click();
		webDriver.findElement(By.linkText("Add new Question")).click();
		
		webDriver.findElement(By.id("question1Title")).sendKeys("TestingQuestion1");
		webDriver.findElement(By.id("question1Choice1")).sendKeys("ch1");
		webDriver.findElement(By.id("question1Choice2")).sendKeys("ch2");
		webDriver.findElement(By.id("question1Choice3")).sendKeys("ch3");
		webDriver.findElement(By.id("question1Choice4")).sendKeys("ch4");
		new Select (webDriver.findElement(By.id("question1Answer"))).selectByValue("1");
		
		webDriver.findElement(By.id("question2Title")).sendKeys("TestingQuestion2");
		webDriver.findElement(By.id("question2Choice1")).sendKeys("ch1");
		webDriver.findElement(By.id("question2Choice2")).sendKeys("ch2");
		webDriver.findElement(By.id("question2Choice3")).sendKeys("ch3");
		webDriver.findElement(By.id("question2Choice4")).sendKeys("ch4");
		new Select (webDriver.findElement(By.id("question2Answer"))).selectByValue("2");
		
		webDriver.findElement(By.name("submit")).click();
		assertEquals("GameTestingOnly",webDriver.findElement(By.id("game_name")).getText());

		webDriver.findElement(By.linkText("Delete Course")).click();
		webDriver.close();
	}
	
}
