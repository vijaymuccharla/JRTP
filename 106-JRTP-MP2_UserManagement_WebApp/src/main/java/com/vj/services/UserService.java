package com.vj.services;

import java.util.Map;

import com.vj.bindings.Login;
import com.vj.bindings.UnlockUser;
import com.vj.bindings.User;
import com.vj.entities.UserEntity;

public interface UserService {

	/**
	 * Returns (key,value) -> (countryId,countryName) of the countries in a Map.
	 * @return
	 */
	public Map<Integer,String> getAllCountries();
	
	/**
	 * Returns (key,value) -> (stateId,stateName) of a country in a Map 
	 * based on countryId. 
	 * @param countryId
	 * @return
	 */
	public Map<Integer,String> getAllStatesByCountryId(Integer countryId);
	
	/**
	 * Returns (key,value) -> (cityId,cityName) of a state in a Map 
	 * based on stateId. 
	 * @param stateId
	 * @return
	 */
	public Map<Integer,String> getAllCitiesByStateId(Integer stateId);
	
	/**
	 * return  
	 * @param email
	 * @return
	 */
	public boolean getUserByEmail(String email);

	/**
	 * 
	 * @param user
	 * @return
	 */
	public boolean insertNewUser(User user);
	
	/**
	 * Validate user temp pwd to unlock user
	 * @param tempPwd
	 * @return
	 */
	public boolean validateTempPwd(UnlockUser user);
	
	/**
	 * Validate user email and password by Login binding obj
	 * @param login
	 * @return
	 */
	public UserEntity validateLoginCredentials(Login login);

	public boolean accountUnlockedOrNot(UserEntity entity);

	public void sendPasswordTo(String registeredEmail);
}
