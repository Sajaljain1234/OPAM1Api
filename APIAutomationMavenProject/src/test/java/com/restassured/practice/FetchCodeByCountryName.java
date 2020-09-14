package com.restassured.practice;
/*With the help of country name fetch country code 
1. through logic
2. through inbuilt methods of ArrayList
*/
import java.util.ArrayList;
import java.util.Iterator;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class FetchCodeByCountryName {
	// Approach 1
//@Test
public void FetchCode() {
	String reqCountry="Liechteein";
	boolean flag=false;
	Response resp=RestAssured.get("https://restcountries.eu/rest/v2/all");
	ArrayList<Object> allCountryName=resp.jsonPath().get("name");
	Iterator<Object> itr=allCountryName.iterator();
	int count=0;
	while(itr.hasNext()) {
		Object obj=itr.next();
		if(obj.equals(reqCountry)) {
			Object reqCode=resp.jsonPath().get("currencies.code["+count+"]");
			System.out.println(reqCountry+" is present and country code is "+reqCode);
			flag=true;
			break;
		}
		count++;
	}
	if(!flag) {
		System.out.println(reqCountry+" is not present");
	}
}

// Approach 2

@Test
public void FetchCodeByCN(){
	String reqCountry="India";
	Response resp=RestAssured.get("https://restcountries.eu/rest/v2/all");
	ArrayList<Object> allCountryName=resp.jsonPath().get("name");
	if(allCountryName.contains(reqCountry)) {
		int index=allCountryName.indexOf(reqCountry);
		Object reqCode=resp.jsonPath().get("currencies.code["+index+"]");
		System.out.println(reqCountry+" is present and country code is "+reqCode);
	}else {
		System.out.println(reqCountry+" is not present");
	}
}


}
