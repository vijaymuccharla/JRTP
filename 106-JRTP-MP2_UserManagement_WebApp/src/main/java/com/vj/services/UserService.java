package com.vj.services;

import java.util.Map;

import com.vj.bidings.User;
import com.vj.repositories.UserRepository;

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
	
		
}
