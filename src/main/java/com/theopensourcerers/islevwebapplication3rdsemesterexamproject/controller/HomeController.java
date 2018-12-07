package com.theopensourcerers.islevwebapplication3rdsemesterexamproject.controller;

import com.theopensourcerers.islevwebapplication3rdsemesterexamproject.base.Session;
import com.theopensourcerers.islevwebapplication3rdsemesterexamproject.repository.SessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @Autowired
    SessionRepository sessionRepository;

	@GetMapping("/")
	public String index(){
		return "frontpage";
	}

	@GetMapping("/login")
    public String loginView() {
	    //sessionRepository.save(new Session("admin@admin.dk", "admin", "ADMIN"));
	    //sessionRepository.save(new Session("medlem@medlem.dk", "medlem", "MEDLEM"));

	    return "login";
    }

    @GetMapping("/register")
	public String registerView() {
		return "createMember";
	}
}
