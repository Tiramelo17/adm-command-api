package com.adm.command.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.adm.command.models.Item;

public interface ItemRepository extends JpaRepository<Item, Integer> {
	
	@Query("select i from Item i where i.name LIKE %:name%")
	List<Item> findItemByName(@Param("name") String name);
}
