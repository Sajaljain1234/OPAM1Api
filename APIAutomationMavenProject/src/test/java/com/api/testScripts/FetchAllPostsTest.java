package com.api.testScripts;

import org.testng.annotations.Test;

import com.api.genericLib.BaseClass;

import io.restassured.response.Response;

public class FetchAllPostsTest extends BaseClass{
	@Test
	public void getData() throws Exception{
		String apiTestData=config.getApiTestData("getAllPosts");
		Response resp=config.executeRequest(apiTestData);
		resp.then().log().all();
	}

}
