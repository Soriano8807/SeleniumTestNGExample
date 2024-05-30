package com.SAMFormulariosWeb.pages.utils;


import java.util.ArrayList;
import java.util.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    public static WebDriver driver;
    public WebDriverWait wait;

    public BasePage (WebDriver driver) {
        BasePage.driver = driver;
        wait = new WebDriverWait(driver,20);
    }

    public String readText(By elementLocation) {
        return driver.findElement(elementLocation).getText();
    }

    public void writeText(By elementLocation, String text) {
        driver.findElement(elementLocation).sendKeys(text);
    }

    public WebElement getElement(By element) {
        return driver.findElement(element);
    }
    
    public void click (By elementLocation) {
        driver.findElement(elementLocation).click();
    }
    
    public void clear(By elementLocation) {
    	driver.findElement(elementLocation).clear();
    }
    
    public boolean displayed(By elementLocation) {
    	boolean display = driver.findElement(elementLocation).isDisplayed();
    	return display;
    }
    
    public void selectElementList (By elementLocation, String valorLista){
    	Select lista = new Select (driver.findElement(elementLocation));
    	lista.selectByVisibleText(valorLista);
    }
    
    public void scrollDown(By elementLocation){
    	JavascriptExecutor js = (JavascriptExecutor) driver;
    	js.executeScript("[arguments[0].scrollIntoView();", elementLocation);
    }
    
    public String searchElementGrid(By tableResult, String searchValue){    	
    	String row = null;
    	
    	ArrayList<WebElement> resultado = (ArrayList<WebElement>)driver.findElement(tableResult).findElements(By.tagName("td"));

    	for (Iterator<WebElement> iterator = resultado.iterator(); iterator.hasNext();) {
    		
    		WebElement campo = (WebElement) iterator.next();
    		row = campo.getText();
    		
    		if (row.equals(searchValue)) {
    			break;    			
    		}
    	}
    	return row;
    }
    
    public void clickElementGrid(By tableResult, String searchValue){    	
    	String row = null;
    	
    	ArrayList<WebElement> resultado = (ArrayList<WebElement>)driver.findElement(tableResult).findElements(By.tagName("td"));

    	for (Iterator<WebElement> iterator = resultado.iterator(); iterator.hasNext();) {
    		
    		WebElement campo = (WebElement) iterator.next();
    		row = campo.getText();
    		
    		if (row.equals(searchValue)) {
    			campo.click();
    			break;    			
    		}
    	}
    }
    
    public int cantidadRows(By tableResult){    	
    	
    	ArrayList<WebElement> resultado = (ArrayList<WebElement>)driver.findElement(tableResult).findElements(By.tagName("tr"));
    	return resultado.size()-2;    	
    }
}