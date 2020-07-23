package com.vj.bindings;

import java.util.Date;

import lombok.Data;

@Data
public class User {

	private Integer userId;
	private String firstName;
	private String lastName;
	private String userEmail;
	private String userPhone;
	private Date userDob;
	private String userGender;
	private Integer countryId;
	private Integer stateId;
	private Integer cityId;
	private String accountStatus;
	private Date createdDate;
	private Date updatedDate;
	private String userPassword;

}
/**
 DB columns : 

  1. user_id
  2. first_name
  3. last_name
  4. user_email
  5. user_phone
  6. user_dob
  7. user_gender
  8. country_id
  9. state_id
  10. city_id
  11. account_status
  12. created_date
  13. updated_date
  14. user_password
  
 */
