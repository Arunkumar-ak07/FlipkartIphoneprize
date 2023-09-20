package org.flip.test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FlipSaleDetails {

	public static void main(String[] args) {
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts()
.implicitlyWait(Duration.ofSeconds(5));		
		driver.get("https://www.flipkart.com/");
		
		
		WebElement txtsearch = driver.findElement(By.name("q"));
		txtsearch.sendKeys("iphone"+Keys.ENTER);
		List<WebElement> iphonePrize = driver.findElements(By.xpath("//div[@class=\"_30jeq3 _1_WHN1\"]"));
	
	Map<WebElement, Integer> map=new HashMap<WebElement,Integer>();
		  for(int i=0;i<iphonePrize.size();i++) {
			  
			 
			  
		   if(iphonePrize.get(i).getText() != "") {
			  
		map.put(iphonePrize.get(i), Integer.parseInt(iphonePrize.get(i).getText().replaceAll("₹", "").replaceAll(",", "")));
			 
		  }
			
			
		  } 
		  
			
		  List<Entry<WebElement,Integer>> li=new ArrayList<Map.Entry<WebElement,Integer>>(map.entrySet());
			  
			  li.sort(Entry.comparingByValue());
			  
			  for(Entry e:li) {
				  System.out.println(e.getValue());
				  
			  }
			  li.get(li.size()-1).getKey().click();
			  
			  
			  
			  
	}  
		  }
	