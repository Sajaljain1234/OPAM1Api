package com.api.genericLib;

import static io.restassured.RestAssured.*;

import org.testng.annotations.BeforeSuite;

public class BaseClass {
public ApiConfig config=new ApiConfig();
public RestAssuredCommonUtils raUtils=new RestAssuredCommonUtils();

/*@BeforeSuite
public void configBS() {
	baseURI="https://restcountries.eu";
	basePath="/rest/v2";
}*/
}
