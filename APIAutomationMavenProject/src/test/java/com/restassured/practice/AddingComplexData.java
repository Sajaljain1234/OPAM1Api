package com.restassured.practice;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSender;
import io.restassured.specification.RequestSpecification;

public class AddingComplexData {
@Test
public void addData() {
	RequestSpecification reqsp=RestAssured.given();
	JSONObject o=new JSONObject();
	o.put("manual", "average");
	o.put("selenium", "very good");
	o.put("java", "good");
	
	JSONObject o1=new JSONObject();
	o1.put("name", "sajal");
	o1.put("id", 12);
	o1.put("skills", o);
	
	JSONObject o2=new JSONObject();
	o2.put("employee", o1);
	
	String jsonData = o2.toJSONString();
	reqsp.body(jsonData);
	reqsp.contentType(ContentType.JSON);
	RequestSender s = reqsp.when();
	Response resp=s.post("http://localhost:3000/posts");
	ValidatableResponse vr=resp.then();
	vr.log().all();
}
}
