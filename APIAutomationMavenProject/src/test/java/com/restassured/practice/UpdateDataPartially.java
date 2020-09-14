package com.restassured.practice;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSender;
import io.restassured.specification.RequestSpecification;

public class UpdateDataPartially {
@Test
public void partialUpdate() {
	RequestSpecification reqsp=RestAssured.given();
	JSONObject jobj=new JSONObject();
	jobj.put("salary", 80000);
	jobj.put("skill","manual");
	String jsonData=jobj.toJSONString();
	reqsp.body(jsonData);
	reqsp.contentType(ContentType.JSON);
	RequestSender sender=reqsp.when();
	Response resp=sender.patch("http://localhost:3000/posts/10");
	ValidatableResponse vr=resp.then();
	vr.log().all();
}
}
