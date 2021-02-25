package com.junitmockito.code.codetestwithjunitmockito.spike;

import org.json.JSONException;
import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;

public class JSONAssertTest {
	
	String actualResponse = 
		"{\"id\":1,\"name\":\"Ball\",\"price\":10,\"quantity\":100}";

	@Test
	public void jsonAssert_StrictTrue() throws JSONException {
		String expectedResponse = "{\"id\":1,\"name\":\"Ball\",\"price\":10,\"quantity\":100}";
		JSONAssert.assertEquals(expectedResponse, actualResponse, true);
		
	}
	
	@Test
	public void jsonAssert_StrictFalse() throws JSONException {
		String expectedResponse = "{\"id\":1,\"name\":\"Ball\",\"price\":10}";
		JSONAssert.assertEquals(expectedResponse, actualResponse, false);
		
	}
	
	@Test
	public void jsonAssert_StrictFalse_removeEscapeCharacters() throws JSONException {
		String expectedResponse = "{id:1,name:Ball,price:10}";
		JSONAssert.assertEquals(expectedResponse, actualResponse, false);
		
	}
}
