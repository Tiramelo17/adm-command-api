package com.adm.command.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.adm.command.models.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	
	
	@Query()
	public User findUserByUserNameAndPassword(String userName,String  password);
	
	 @Query("SELECT e FROM User e JOIN FETCH e.roles WHERE e.userName LIKE %:userName%")
	 public User findByUsername(@Param("userName") String userName);
}
