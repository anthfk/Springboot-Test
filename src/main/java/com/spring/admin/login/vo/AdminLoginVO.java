package com.spring.admin.login.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdminLoginVO {
	private String a_id;
	private String a_pwd;
	private String a_name;
	private String a_phone;
	private String a_email;
	private String a_date;
}
