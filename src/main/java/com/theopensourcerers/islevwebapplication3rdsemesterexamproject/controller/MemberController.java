package com.theopensourcerers.islevwebapplication3rdsemesterexamproject.controller;

import com.theopensourcerers.islevwebapplication3rdsemesterexamproject.authentication.WebSecurityConfig;
import com.theopensourcerers.islevwebapplication3rdsemesterexamproject.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MemberController {

    @Autowired
    MemberRepository memberRepository;

    @GetMapping("/member/")
    public String homepage() {
        return "member/index";
    }

    @GetMapping("/member/my-information")
    public String myInformatonView(Model model) {
        model.addAttribute("info", memberRepository.findBySessionId(WebSecurityConfig.myId));
        return "myInformationView";
    }

    @GetMapping("/member/my-information/edit")
    public String myInformatonEdit(Model model) {
        model.addAttribute("info", memberRepository.findBySessionId(WebSecurityConfig.myId));
        return "myInformationView";
    }
}
