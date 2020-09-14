package com.restassured.practice;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.*;
import io.restassured.specification.*;

public class InsertDataToPosts {
@Test
public void addData() {
	//set the preconditoin for request
	RequestSpecification reqsp=RestAssured.given();
	
	//create a JSONObject by using JSONObject class
	JSONObject jobj=new JSONObject();
	jobj.put("id", 10);
	jobj.put("name", "sajal");
	jobj.put("skill", "Automation");
	
	//convert a java object into JSON form
	String jsonData=jobj.toJSONString();
	
	//keep the jsonData inside the body part of request
	reqsp.body(jsonData);
	
	//set the content type for request
	reqsp.contentType(ContentType.JSON);
	
	//apply or attach the pre condition on a request
	RequestSender sender = reqsp.when();
	
	//send the request on particular api
	Response resp = sender.post("http://localhost:3000/posts");
	
	//used to fetch complete response
	ValidatableResponse vr = resp.then();
	vr.log().all();
}
}
