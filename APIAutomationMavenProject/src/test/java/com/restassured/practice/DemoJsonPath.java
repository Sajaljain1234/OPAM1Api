package com.restassured.practice;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class DemoJsonPath {
@Test
public void checkJsonPath() {
	Response resp = RestAssured.get("http://localhost:3000/posts");
	Object o = resp.jsonPath().get("employee.skills.manual");
	System.out.println(o);
}
}
