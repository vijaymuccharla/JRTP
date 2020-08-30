package com.vj.services;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vj.entity.SsnMasterEntity;
import com.vj.entity.SsnStateEntity;
import com.vj.model.SsnEnrollmentRequest;
import com.vj.repositories.SsnMasterRepository;
import com.vj.repositories.SsnStateRepository;
import com.vj.repositories.StatesDataRepository;

@Service
public class SsaServiceImpli implements SsaService {

	@Autowired
	private SsnMasterRepository ssnRepo;

	@Autowired
	private SsnStateRepository ssnSttRepo;

	@Autowired
	private StatesDataRepository statesRepo;

	/**
	 * 
	 */
	@Override
	public Long ssnEnrollment(SsnEnrollmentRequest request) {
		//create new Entity obj for inserting record
		SsnMasterEntity entity = new SsnMasterEntity();
		//copy Model to Entity
		BeanUtils.copyProperties(request, entity);
		//insert Ssn Req data
		SsnMasterEntity insertedSsn = ssnRepo.save(entity);
		//get Ssn and return
		if (insertedSsn != null)
			return insertedSsn.getSsn();
		else
			return null;
	}

	/**
	 * 
	 */
	@Override
	public List<String> getAllStates() {
		return statesRepo.findAllStates();
	}

	/**
	 * 
	 */
	@Override
	public String ssnEnrolledOrNot(Long ssn, String stateName) {

		SsnMasterEntity ssnFound = ssnRepo.findBySsnAndStateName(ssn, stateName);
		if (ssnFound != null)
			return "valid";
		else
			return "invalid";
	}

	@Override
	public String ssnFoundOrNot(Long ssn) {

		SsnStateEntity found = ssnSttRepo.findBySsn(ssn);
		if (found!= null)
			return "found";
		else
			return "notfound";
	}

	@Override
	public String ssnSttValidOrNot(Long ssn, String stateName) {

		SsnStateEntity ssnSttFound = ssnSttRepo.findBySsnAndState(ssn, stateName);
		if (ssnSttFound != null)
			return "valid";
		else
			return "invalid";
	}

}
