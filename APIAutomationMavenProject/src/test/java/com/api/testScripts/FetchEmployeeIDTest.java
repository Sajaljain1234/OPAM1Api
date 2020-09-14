package com.api.testScripts;

import org.testng.annotations.Test;

import com.api.genericLib.BaseClass;

import io.restassured.response.Response;

public class FetchEmployeeIDTest extends BaseClass{
	@Test
	public void checkEmployeeId() throws Exception{
		String apiTestData=config.getApiTestData("getEmployeeIDTest");
		Response resp=config.executeRequest(apiTestData);
		resp.then().log().all();
	}

}
