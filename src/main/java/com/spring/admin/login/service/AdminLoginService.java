package com.spring.admin.login.service;

import org.springframework.stereotype.Service;

import com.spring.admin.login.vo.AdminLoginVO;

@Service
public interface AdminLoginService {
	public AdminLoginVO loginProcess(AdminLoginVO vo);
}
