package com.api.genericLib;

import org.hamcrest.Matchers;
import org.junit.Assert;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class RestAssuredCommonUtils {
public void validateStatusCode(Response resp,int expectedStatusCode) {
	resp.then().assertThat().statusCode(expectedStatusCode);
	System.out.println("status code validation is successful");	
}

public void validateContentType(Response resp) {
	resp.then().assertThat().contentType(ContentType.JSON);
	System.out.println("content type validation is successful");	
}

public void validateResponseTime(Response resp,long rangeOfWithInTime) {
	resp.then().assertThat().time(Matchers.lessThan(rangeOfWithInTime));
	System.out.println("Response time validation is successful");	
}

public void validateKVPair(Response resp,String jsonPath,String expectedValue) {
	Object obj=resp.jsonPath().get(jsonPath);
	String actualValue=obj.toString();
	Assert.assertEquals(actualValue, expectedValue);
}

public String fetchTokenId(Response resp,String jsonPath) {
	Object objToken=resp.jsonPath().get(jsonPath);
	return objToken.toString();
}
}
