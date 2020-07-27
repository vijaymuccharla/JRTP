package com.vj.services;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vj.bindings.Login;
import com.vj.bindings.UnlockUser;
import com.vj.bindings.User;
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

	/**
	 > Here save method works as polymorphic method to update the 
	   record with new Account status : UNLOCKED
	 */
	@Override
	public boolean validateTempPwd(UnlockUser user) {
		//getUserByPassword using temp password
		UserEntity userToUnlock = userRepo.findByUserPassword(user.getTempPazzword());

		if (userToUnlock != null) {
			//set account status to Unlocked & update with new password
			userToUnlock.setAccountStatus("Unlocked");
			userToUnlock.setUserPassword(user.getConfirmPazzword());
			//update the same User enitity with new Account Status : Unlocked
			UserEntity updatedUser = userRepo.save(userToUnlock);
			if (updatedUser.getAccountStatus().equalsIgnoreCase("unlocked"))
				return true;
		}
		return false;
	}

	/**
	 * Authenticating Login user details by Email and Password from Login Binding obj
	 */
	@Override
	public UserEntity validateLoginCredentials(Login login) {
		//user repo 
		UserEntity userFound = userRepo.findByUserEmailAndUserPassword(login.getUserEmail(), login.getUserPassword());
		if (userFound != null)
			return userFound;
		else
			return null;
	}

	/**
	 * check wheather user account is unlocked or not
	 */
	@Override
	public boolean accountUnlockedOrNot(UserEntity entity) {
		if (entity.getAccountStatus().equalsIgnoreCase("locked"))
			return false;
		else
			return true;
	}

	@Override
	public void sendPasswordTo(String registeredEmail) {
		UserEntity foundUser = userRepo.findByUserEmail(registeredEmail);
		User user = new User();
		BeanUtils.copyProperties(foundUser, user);
		emailUtil.sendEmail(foundUser.getUserEmail(), user);
	}
}
