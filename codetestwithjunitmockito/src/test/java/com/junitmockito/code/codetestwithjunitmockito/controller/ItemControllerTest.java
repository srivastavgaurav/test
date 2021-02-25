package com.junitmockito.code.codetestwithjunitmockito.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.junitmockito.code.codetestwithjunitmockito.business.ItemBusinessService;
import com.junitmockito.code.codetestwithjunitmockito.model.Item;

@RunWith(SpringRunner.class)
@WebMvcTest(ItemController.class)
public class ItemControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private ItemBusinessService businessService;

	@Test
	public void dummyItem_basics() throws Exception {

		RequestBuilder request = MockMvcRequestBuilders.get("/dummy-item").accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(request).andExpect(status().isOk())
				.andExpect(content().json("{\"id\": 1,\"name\":\"Ball\",\"price\":10}")).andReturn();
		// assertEquals("Hello World", result.getResponse().getContentAsString());
		// JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(),
		// strict);
	}

	@Test
	public void itemFromBusinessService_basics() throws Exception {

		when(businessService.retrieveHardCodedItem()).thenReturn(new Item(2, "Ball2", 20, 200));

		RequestBuilder request = MockMvcRequestBuilders.get("/item-from-business-service")
				.accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(request).andExpect(status().isOk())
				.andExpect(content().json("{id:2,name:Ball2,price:20, quantity:200}")).andReturn();
		// assertEquals("Hello World", result.getResponse().getContentAsString());
		// JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(),
		// strict);
	}

	@Test
	public void retrieveAllItems() throws Exception {

		when(businessService.retrieveAllItems()).thenReturn(Arrays.asList(new Item(2, "Ball2", 20, 200), 
			new Item(3, "Ball3", 30, 300)));

		RequestBuilder request = MockMvcRequestBuilders.get("/all-items-from-database")
				.accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(request).andExpect(status().isOk())
				.andExpect(content().json("[{id:2,name:Ball2,price:20, quantity:200}, "
						+ "{id:3,name:Ball3,price:30, quantity:300}]")).andReturn();
		// assertEquals("Hello World", result.getResponse().getContentAsString());
		// JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(),
		// strict);
	}

}
