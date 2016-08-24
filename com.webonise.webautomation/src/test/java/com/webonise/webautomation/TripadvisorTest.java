package com.webonise.webautomation;


import java.util.List;
import java.util.Random;

import com.webonise.webautomation.DataGetter;

import io.ddavison.conductor.Browser;
import io.ddavison.conductor.Config;
import io.ddavison.conductor.Locomotive;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


@Config(
        browser = Browser.CHROME,
        url     = "http://www.tripadvisor.in"
)

public class TripadvisorTest extends Locomotive {
    @Test
    public void test() throws InterruptedException{
    	
    	DataGetter datagetter=new DataGetter("data.txt");
    	validatePresent(HomePage.FLIGHTSTAB);
    	WebDriverWait wait = new WebDriverWait(driver, 30);
    	click(HomePage.FLIGHTSTAB);
    	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id="+"'FLIGHT_FORM_META'"+"]")));
    	validatePresent(HomePage.SOURCEAIRPORT);
    	setText(HomePage.SOURCEAIRPORT,datagetter.getSource());
    	driver.findElement(HomePage.SOURCEAIRPORT).sendKeys(Keys.ENTER);
    	setText(HomePage.DESTINATIONAIRPORT,datagetter.getDestination());
    	driver.findElement(HomePage.SOURCEAIRPORT).sendKeys(Keys.ENTER);
    	WebElement SourceCalender=driver.findElement(By.xpath("//div[@class='sprite-calendar-ylw']"));
    	SourceCalender.click();
    	WebElement DestinationCalender=driver.findElement(By.xpath("//span[@id='metaCheckOutSpan']//div"));
    	DestinationCalender.click();
    	Random rand = new Random();
        int randomNum = rand.nextInt((5 - 1) + 1) + 1;
        Select dropdown = new Select(driver.findElement(By.id("fadults")));
        dropdown.selectByIndex(randomNum);
        Thread.sleep(2000);
        driver.findElement(By.id("SUBMIT_FLIGHTS")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ui_close_x")));
        driver.findElement(By.className("ui_close_x")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("sort_container")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='sort_container']//label[text()='More']")));
        driver.findElement(By.xpath("//iframe/..//span[contains(@class,'sort_item')][4]/label")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='sort_sub_items']")));
        WebElement element=driver.findElement(HomePage.SORTBYF);
        element.click();
        Thread.sleep(3000);
        wait.until(ExpectedConditions.invisibilityOfElementWithText(By.className("loadingMsg"),"Updating list..."));
        driver.findElement(HomePage.PRICEBUTTON).click();
    }
}
