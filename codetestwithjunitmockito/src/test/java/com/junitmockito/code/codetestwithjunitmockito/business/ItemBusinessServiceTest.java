package com.junitmockito.code.codetestwithjunitmockito.business;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.junitmockito.code.codetestwithjunitmockito.data.ItemRepository;
import com.junitmockito.code.codetestwithjunitmockito.model.Item;

@RunWith(MockitoJUnitRunner.class)
public class ItemBusinessServiceTest {

	@InjectMocks
	ItemBusinessService business;
	
	@Mock
	ItemRepository repository;
	
	@Test
	public void retrieveAllItems() {
		when(repository.findAll()).thenReturn(Arrays.asList(new Item(2, "Ball2", 20, 200), 
				new Item(3, "Ball3", 30, 300)));
		List<Item> items = business.retrieveAllItems();
		assertEquals(4000, items.get(0).getValue());
		assertEquals(9000, items.get(1).getValue());
	}
	
}
