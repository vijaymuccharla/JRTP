package com.vj.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vj.entities.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {

	public UserEntity findByUserEmail(String userEmail);
	public UserEntity findByUserPassword(String userPassword);
	public UserEntity findByUserEmailAndUserPassword(String userEmail,String userPasswordString);
}
