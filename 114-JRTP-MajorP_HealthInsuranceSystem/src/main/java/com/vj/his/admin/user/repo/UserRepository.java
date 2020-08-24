package com.vj.his.admin.user.repo;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vj.his.admin.user.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Serializable> {

	public UserEntity findByUserEmail(String userEmail);

	public UserEntity findByUserPassword(String tempPazzword);

	public UserEntity findByUserEmailAndUserPassword(String userEmail, String userPassword);

	public UserEntity findByUserId(Integer userId);

}
