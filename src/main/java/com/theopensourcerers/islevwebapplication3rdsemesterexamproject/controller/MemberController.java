package com.theopensourcerers.islevwebapplication3rdsemesterexamproject.controller;

import com.theopensourcerers.islevwebapplication3rdsemesterexamproject.base.Member;
import com.theopensourcerers.islevwebapplication3rdsemesterexamproject.base.Session;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("member")
public class MemberController {

    @GetMapping("")
    public String hej(Model model) {
        model.addAttribute("member", new Member());
        return "member/index";
    }

    @GetMapping("create")
    public String create(Model model) {
        model.addAttribute("member", new Member());
        model.addAttribute("session", new Session());
        return "createMember";
    }
}
