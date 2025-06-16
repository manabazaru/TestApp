package com.example.demo.control;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.example.demo.entity.Member;
import com.example.demo.form.LoginForm;
import com.example.demo.service.SearchMember;

@Controller
public class LoginController {
	
	private SearchMember searchMember;
	
	public LoginController(SearchMember searchMember) {
		this.searchMember = searchMember;
	}
	
	@GetMapping("")
	public String start(Model model) {
    	model.addAttribute("loginForm", new LoginForm());
        return "customer-top";
    }

    @GetMapping("/login")
    public String login(Model model) {
    	model.addAttribute("loginForm", new LoginForm());
        return "login";
    }
    
    @GetMapping("/goTopFromLogin")
    public String enterLogin(@ModelAttribute LoginForm loginForm, Model model) {
    	
    	String id = loginForm.getId();
    	String password = loginForm.getPassword();
    	
    	Member member = searchMember.searchMember(id);
    	
    	if(member == null) {
    		model.addAttribute("message", "ユーザがいません");
    	}else if(!member.getPassword().equals(password)) {
    		model.addAttribute("message", "パスワードが違います。"+password + " " + member.getPassword());
    	}else {
    		model.addAttribute("message", "成功");
    		return "customer-top";
    	}
    	
    	return "login";
    }
    
    @GetMapping("goTop")
    public String goTop() {
    	return "customer-top";
    }
}