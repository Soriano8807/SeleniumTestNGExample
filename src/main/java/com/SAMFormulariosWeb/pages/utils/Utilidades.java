package com.SAMFormulariosWeb.pages.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.qameta.allure.Attachment;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utilidades extends BasePage {
	//private static WebDriver driver;
	
	public Utilidades(WebDriver driver) {
		super(driver);
		
		}

    public static void waitInMs(Integer milliseconds)  {
        try {
           Thread.sleep(milliseconds);
        } catch (Exception e) {}
    }
    
    public static void seleccionarKeyBoard(WebElement field) {
		field.sendKeys(Keys.UP);	
	    field.click();
		field.sendKeys(Keys.ENTER);
	}
    
   public static void takeSnapShot(WebDriver webdriver, String nombrePantalla) throws IOException {
	   try {   	
    	
    	Date fecha = new Date(); 
    	SimpleDateFormat formato = new SimpleDateFormat("YYYYMMddHHmmss");
    	
    	File screenshotFile =((TakesScreenshot)webdriver).getScreenshotAs(OutputType.FILE);
    	File f= new File("D:\\Proyectos\\SAMFormulariosWeb\\snapshots\\"+nombrePantalla+formato.format(fecha)+".png");
    	com.google.common.io.Files.copy(screenshotFile, f);   
	    
           } catch (Exception e) {}
	   }
   
   @Attachment(value = "Screenshot", type = "image/png")
   public static byte[] screenshot() {
       return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
   }
   
   public static void ByPixel() {

       JavascriptExecutor js = (JavascriptExecutor) driver;
       driver.manage().window().maximize();
       js.executeScript("window.scrollBy(0,1000)");
   }
   
   public static void saltodepagina () {
	   driver.switchTo().defaultContent();
		
		driver.switchTo().window(driver.getWindowHandle());
		
		Object[] parentHandle = driver.getWindowHandles().toArray();
		
		driver.switchTo().window((String) parentHandle[1]);
		
		driver.manage().window().maximize();
   }
   
   public static void cargarArchivo(String archivo, By element) {
	   
	   File file = new File(archivo);
	   WebElement ruta = driver.findElement(element);
	   ruta.sendKeys(file.getAbsolutePath());

   }
}
