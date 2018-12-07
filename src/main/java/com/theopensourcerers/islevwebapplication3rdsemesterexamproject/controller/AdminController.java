package com.theopensourcerers.islevwebapplication3rdsemesterexamproject.controller;

import com.theopensourcerers.islevwebapplication3rdsemesterexamproject.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class AdminController {
    public static boolean success = false;

    @Autowired
    MemberRepository memberRepository;

    @GetMapping("/admin/")
    public String adminMemberList() {
        return "/admin/index";
    }

    @GetMapping("/admin/members/")
    public String memberList(Model model) {
        model.addAttribute("members", memberRepository.findAll());
        model.addAttribute("success", success);
        success = false;
        return "/admin/memberList";
    }

    @GetMapping("/admin/members/edit/{id}")
    public String updateMember(Model model,
                             @PathVariable("id") Integer id){
        model.addAttribute("member", memberRepository.findByIdEquals(id));

        return "/admin/updateMember";
    }

}
