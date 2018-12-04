package com.theopensourcerers.islevwebapplication3rdsemesterexamproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {
    @GetMapping("/admin/")
    public String adminMemberList() {
        return "/admin/index";
    }

    @GetMapping("/member/")
    public String memberMemberList() {
        return "/member/index";
    }
}
