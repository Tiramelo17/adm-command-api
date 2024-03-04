package com.adm.command.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.adm.command.models.Item;
import com.adm.command.services.ItemService;

@RestController
public class ItemController {
	@Autowired
	ItemService itemService;
	
	@GetMapping("/item")
	public List<Item> findItemByName(@RequestParam(name = "name") String name) {
		return itemService.findItemByName(name);
	}
	
	@PostMapping("/item/create")
	public Item insertNewItem(@RequestBody Item item) {
		return itemService.insertNewItem(item);
	}
}
