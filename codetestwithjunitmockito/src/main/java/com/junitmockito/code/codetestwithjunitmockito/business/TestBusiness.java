package com.junitmockito.code.codetestwithjunitmockito.business;

import com.junitmockito.code.codetestwithjunitmockito.model.Item;

public class TestBusiness {
	
	public Item retrieveHardCodedItem() {
		System.out.println("Hi");
		return new Item(1, "Ball", 10, 100);
	}

}
