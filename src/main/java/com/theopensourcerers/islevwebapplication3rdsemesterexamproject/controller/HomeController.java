package com.theopensourcerers.islevwebapplication3rdsemesterexamproject.controller;

import com.theopensourcerers.islevwebapplication3rdsemesterexamproject.authentication.WebSecurityConfig;
import com.theopensourcerers.islevwebapplication3rdsemesterexamproject.base.Member;
import com.theopensourcerers.islevwebapplication3rdsemesterexamproject.repository.SessionRepository;
import org.dom4j.rule.Mode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping("/")
	public String index(Model model) {
//      ---------------------------------------------------------------------------------------------------------
//     | For menu (nav bar):                                                                                     |
//      ---------------------------------------------------------------------------------------------------------
		model.addAttribute("PREFIX", WebSecurityConfig.getPrefixURL());
		model.addAttribute("LOGGED_IN", WebSecurityConfig.isLoggedIn());
//      ---------------------------------------------------------------------------------------------------------
		return "frontpage";
	}

	@GetMapping("/login")
	public String loginView() {
		return "login";
	}

	@GetMapping("/register")
	public String registerView(Model model) {
		model.addAttribute("member", new Member());
		return "createMember";
	}

	@GetMapping("training")
	public String training(Model model){
		model.addAttribute("PREFIX", WebSecurityConfig.getPrefixURL());
		model.addAttribute("LOGGED_IN", WebSecurityConfig.isLoggedIn());
		return "training/index";
	}
}
