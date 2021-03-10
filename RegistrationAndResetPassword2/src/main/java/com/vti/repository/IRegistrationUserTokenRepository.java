package com.vti.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.vti.entity.RegistrationUserToken;

public interface IRegistrationUserTokenRepository extends JpaRepository<RegistrationUserToken, Integer> {

	public RegistrationUserToken findByToken(String token);
//get token by user_id
	@Query(" SELECT token" 
	+ "	FROM 	RegistrationUserToken " 
	+ " WHERE 	user.id = :userId")
	public String findByUserId(int userId);
//	delete 
	@Transactional
	@Modifying
	@Query(	  "	DELETE 							"
			+ "	FROM 	RegistrationUserToken 	"
			+ " WHERE 	user.id = :userId")
	public void deleteByUserId(int userId);
}
