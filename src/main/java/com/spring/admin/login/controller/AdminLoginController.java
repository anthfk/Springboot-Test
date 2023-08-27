package com.spring.admin.login.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.admin.login.service.AdminLoginService;
import com.spring.admin.login.vo.AdminLoginVO;

import lombok.Setter;

@Controller
@SessionAttributes("adminLogin")
@RequestMapping("/admin/*")
public class AdminLoginController {
	
	@Setter(onMethod_ = @Autowired)
	private AdminLoginService adminLoginService;
	
	// 로그인 화면 메서드
	@GetMapping("/main")
	public String loginForm() {
		return "admin/main";
	}
	
	// 로그인 메서드
	@PostMapping("/login")
	public String loginProcess(Model model, AdminLoginVO login, RedirectAttributes ras) {
		AdminLoginVO adminLogin = adminLoginService.loginProcess(login);
		
		if(adminLogin != null) {
			model.addAttribute("adminLogin",adminLogin);
		} else {
			ras.addFlashAttribute("errorMsg", "로그인 실패");
		}
		
		return "redirect:/admin/login";
	}
	
	// 로그아웃 메서드
	@GetMapping("/logout")
	public String logout(SessionStatus sessionStatus) {
		sessionStatus.setComplete();
		return "redirect:/admin/login";
	}
	
	
	
	
	
	
}
