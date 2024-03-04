package com.adm.command.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.adm.command.models.Item;
import com.adm.command.repositories.ItemRepository;

import jakarta.transaction.Transactional;

@Component
public class ItemService {
	@Autowired
	private ItemRepository itemRepository;
	
	
	public List<Item> findItemByName(String name) {
		return itemRepository.findItemByName(name);
	}
	
	@Transactional
	public Item insertNewItem(Item item) {
		return itemRepository.save(item);
	}
}
