package com.junitmockito.code.codetestwithjunitmockito.data;

import org.springframework.data.jpa.repository.JpaRepository;

import com.junitmockito.code.codetestwithjunitmockito.model.Item;

public interface ItemRepository extends JpaRepository<Item, Integer>{

}
