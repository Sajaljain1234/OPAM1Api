package com.restassured.practice;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSender;
import io.restassured.specification.RequestSpecification;

public class UpdateDataToPostsCompletely {
@Test
public void updateData() {
	RequestSpecification reqsp=RestAssured.given();
	JSONObject jobj=new JSONObject();
	jobj.put("id", 11);
	jobj.put("name", "jain");
	String jsonData=jobj.toJSONString();
	reqsp.body(jsonData);
	reqsp.contentType(ContentType.JSON);
	RequestSender sender=reqsp.when();
	Response resp=sender.put("http://localhost:3000/posts/10");
	ValidatableResponse vr = resp.then();
	vr.log().all();
}
}
