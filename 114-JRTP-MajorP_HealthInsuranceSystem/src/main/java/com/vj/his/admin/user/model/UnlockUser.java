package com.vj.his.admin.user.model;

import lombok.Data;

@Data
public class UnlockUser {

	private String userEmail;
	private String tempPazzword;
	private String newPazzword;
	private String confirmPazzword;
}
