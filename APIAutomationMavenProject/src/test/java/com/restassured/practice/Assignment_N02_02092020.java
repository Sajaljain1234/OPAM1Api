package com.restassured.practice;

import java.util.ArrayList;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Assignment_N02_02092020 {
@Test
public void fetchDataByTitle() {
	String reqTitle="Turing Machines with Sublogarithmic Space";
	Response resp = RestAssured.get("https://www.googleapis.com/books/v1/volumes?q=turing");
	ArrayList<Object> allTitle = resp.jsonPath().get("items.volumeInfo.title");
	if(allTitle.contains(reqTitle)) {
	int index=allTitle.indexOf(reqTitle);
	Object pageCount = resp.jsonPath().get("items.volumeInfo.pageCount["+index+"]");
	Object publishedDate = resp.jsonPath().get("items.volumeInfo.publishedDate["+index+"]");
	Object retailPrice = resp.jsonPath().get("items.saleInfo.retailPrice.amount["+index+"]");	
	System.out.println("Title:"+reqTitle+"\nPage count:"+pageCount+"\nPublished date:"+publishedDate+"\nRetail price:"+retailPrice);
	}else {
		System.out.println(reqTitle+" is not present");
	}
}
}
