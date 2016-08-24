package com.webonise.webautomation;

import org.openqa.selenium.By;

public class HomePage {

	public static final By FLIGHTSTAB=By.xpath("//*[@id='rdoFlights']");
	public static final By SOURCEAIRPORT=By.xpath("//*[@id='metaFlightFrom']");
	public static final By DESTINATIONAIRPORT=By.xpath("//*[@id='metaFlightTo']");
	public static final By FINDFLIGHTS=By.xpath("//iframe/..//button[@id='SUBMIT_FLIGHTS']");
	public static final By SORTBY=By.xpath("//*[@id='taplc_flight_results_sorts_0']/div[1]/span[1]");
	public static final By SORTBYF=By.xpath("//iframe/..//*[@id='sort_sub_items']/div[2]/label");
	public static final By MOREBUTTON=By.xpath("//iframe/..//div[@class='sub_sort_item checked']//label");
	public static final By PRICEBUTTON=By.xpath("//iframe/..//div[@class='purchaseLinkColumn']//span[@class='price']");
	public static final By SOURCEDATE=By.xpath("//iframe/..//div[@class='sprite-calendar-ylw']");
	public static final By DESTINATIONDATE=By.xpath("//iframe/..//div[@class='sprite-calendar-ylw']");
}