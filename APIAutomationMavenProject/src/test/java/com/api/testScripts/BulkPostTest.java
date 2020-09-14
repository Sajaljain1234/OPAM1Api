package com.api.testScripts;

import org.testng.annotations.Test;

import com.api.genericLib.BaseClass;

import io.restassured.response.Response;

public class BulkPostTest extends BaseClass{
	@Test
	public void addBulkData() throws Exception{
		String apiTestData=config.getApiTestData("InsertBulkData");
		Response resp=config.executeRequest(apiTestData);
		resp.then().log().all();
	}

}
