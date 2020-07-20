package com.vj.services;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vj.bidings.User;
import com.vj.constants.UserManagemetConstants;
import com.vj.entities.CityEntity;
import com.vj.entities.CountryEntity;
import com.vj.entities.StateEntity;
import com.vj.entities.UserEntity;
import com.vj.repositories.CityRepository;
import com.vj.repositories.CountryRepository;
import com.vj.repositories.StateRepository;
import com.vj.repositories.UserRepository;
import com.vj.utils.EmailUtil;
import com.vj.utils.RandomPasswordUtil;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private CountryRepository countryRepo;

	@Autowired
	private StateRepository stateRepo;

	@Autowired
	private CityRepository cityRepo;

	@Autowired
	private UserRepository userRepo;

	@Autowired
	EmailUtil emailUtil;

	/**
	 * 
	 */
	@Override
	public Map<Integer, String> getAllCountries() {
		//create an empty LinkedHasMap obj
		Map<Integer, String> cMap = new LinkedHashMap<Integer, String>();
		//use Country Repository
		List<CountryEntity> countries = countryRepo.findAll();
		//iterate countries amd put id and value in Map
		countries.forEach(country -> {
			cMap.put(country.getCountryId(), country.getCountryName());
		});
		//return map
		return cMap;
	}

	@Override
	public Map<Integer, String> getAllStatesByCountryId(Integer countryId) {
		//create an empty Map<key,value>
		Map<Integer, String> sMap = new LinkedHashMap<Integer, String>();
		//use stateRepo
		List<StateEntity> states = stateRepo.findAllByCountryId(countryId);
		//put stateId,stateName in map
		states.forEach(state -> {
			sMap.put(state.getStateId(), state.getStateName());
		});
		//return map
		return sMap;
	}

	@Override
	public Map<Integer, String> getAllCitiesByStateId(Integer stateId) {
		Map<Integer, String> cityMap = new LinkedHashMap<Integer, String>();
		List<CityEntity> cities = cityRepo.findAllByStateId(stateId);
		cities.forEach(city -> {
			cityMap.put(city.getCityId(), city.getCityName());
		});
		//return map
		return cityMap;
	}

	@Override
	public boolean getUserByEmail(String email) {
		UserEntity userEntity = userRepo.findByUserEmail(email);
		if (userEntity != null)
			return true;
		else
			return false;
	}

	@Override
	public boolean insertNewUser(User user) {
		//set account status to LOCKED using UserManagemetConstants(C)
		user.setAccountStatus(UserManagemetConstants.getLockedStatus());
		//set random / temp password by using RandomPasswordUtil(C)
		user.setUserPassword(RandomPasswordUtil.generatePassword(UserManagemetConstants.getPasswordLngth()));
		//Send an email with the Temp password and Unlock link
		emailUtil.sendEmail(user.getUserEmail(), user);
		//new User Entity obj
		UserEntity entity = new UserEntity();
		//convert Binding obj to Entity
		BeanUtils.copyProperties(user, entity);
		if (userRepo.save(entity).getUserId() != null)
			return true;
		else
			return false;
	}

}
