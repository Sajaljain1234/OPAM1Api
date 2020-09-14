package com.restassured.practice;

import java.util.ArrayList;
import java.util.Iterator;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Assignment_N01_02092020 {
@Test
public void fetchDataByCurrencyCode() {
	String reqCurrencyCode="[AFN]";
	boolean flag=false;
	Response resp=RestAssured.get("https://restcountries.eu/rest/v2/all");
	ArrayList<Object> allCurrencyCode=resp.jsonPath().get("currencies.code");
	System.out.println(allCurrencyCode.contains(reqCurrencyCode));
	Iterator<Object> itr=allCurrencyCode.iterator();
	int count=0;
	while(itr.hasNext()) {
	Object obj=itr.next();
	System.out.println(obj);
	if(obj.equals(reqCurrencyCode)) {
	Object capital = resp.jsonPath().get("capital["+count+"]");
	Object population = resp.jsonPath().get("callingCodes["+count+"]");
	Object callingCode = resp.jsonPath().get("population["+count+"]");
System.out.println("Currenycode:"+reqCurrencyCode+"\nCapital:"
+capital+"\nPopulation:"+population+"\nCallingCode:"+callingCode);
			flag=true;
			break;
		}
		count++;
	}
	if(!flag) {
		System.out.println(reqCurrencyCode+" is not present");
	}
}
}
