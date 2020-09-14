package com.restassured.practice;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class FetchDataFromPosts {
	@Test
	public void getData() {
	Response resp = RestAssured.get("http://localhost:3000/posts");
	int statusCode = resp.getStatusCode();
	System.out.println("Status code : "+statusCode);

	String contentType = resp.getContentType();
	System.out.println("Content type is : "+contentType);

	long time = resp.getTime();
	System.out.println("Time for response is : "+time+" ms");

	String body = resp.asString();
	System.out.println("Actual data is \n"+body);
	
}
}
