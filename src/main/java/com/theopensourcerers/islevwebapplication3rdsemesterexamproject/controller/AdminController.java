package com.theopensourcerers.islevwebapplication3rdsemesterexamproject.controller;

import com.theopensourcerers.islevwebapplication3rdsemesterexamproject.authentication.WebSecurityConfig;
import com.theopensourcerers.islevwebapplication3rdsemesterexamproject.base.Course;
import com.theopensourcerers.islevwebapplication3rdsemesterexamproject.repository.CourseRepository;
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

    @Autowired
    CourseRepository courseRepository;

    @GetMapping("/admin/")
    public String adminMemberList(Model model) {
//      ---------------------------------------------------------------------------------------------------------
//     | For menu (nav bar):                                                                                     |
//      ---------------------------------------------------------------------------------------------------------
        model.addAttribute("PREFIX", WebSecurityConfig.getPrefixURL());
        model.addAttribute("LOGGED_IN", WebSecurityConfig.isLoggedIn());
//      ---------------------------------------------------------------------------------------------------------
        return "/admin/index";
    }

    @GetMapping("/admin/members/")
    public String memberList(Model model) {
//      ---------------------------------------------------------------------------------------------------------
//     | For menu (nav bar):                                                                                     |
//      ---------------------------------------------------------------------------------------------------------
        model.addAttribute("PREFIX", WebSecurityConfig.getPrefixURL());
        model.addAttribute("LOGGED_IN", WebSecurityConfig.isLoggedIn());
//      ---------------------------------------------------------------------------------------------------------
        model.addAttribute("success", success);
        success = false;
        return "/admin/memberList";
    }

    @GetMapping("/admin/members/edit/{id}")
    public String updateMember(Model model,
                             @PathVariable("id") Integer id){
//      ---------------------------------------------------------------------------------------------------------
//     | For menu (nav bar): And this is also used with saving the changes on the member.                        |
//      ---------------------------------------------------------------------------------------------------------
        model.addAttribute("PREFIX", WebSecurityConfig.getPrefixURL());
        model.addAttribute("LOGGED_IN", WebSecurityConfig.isLoggedIn());
        model.addAttribute("member", memberRepository.findByIdEquals(id));
//      ---------------------------------------------------------------------------------------------------------
        return "/admin/updateMember";
    }

    @GetMapping("/admin/courses/")
    public String coursesList(Model model) {
//      ---------------------------------------------------------------------------------------------------------
//     | For menu (nav bar):                                                                                     |
//      ---------------------------------------------------------------------------------------------------------
        model.addAttribute("PREFIX", WebSecurityConfig.getPrefixURL());
        model.addAttribute("LOGGED_IN", WebSecurityConfig.isLoggedIn());
//      ---------------------------------------------------------------------------------------------------------
        model.addAttribute("success", success);
        success = false;
        return "/admin/coursesList";
    }

    @GetMapping("/admin/courses/create")
    public String courseCreate(Model model) {
//      ---------------------------------------------------------------------------------------------------------
//     | For menu (nav bar):                                                                                     |
//      ---------------------------------------------------------------------------------------------------------
        model.addAttribute("PREFIX", WebSecurityConfig.getPrefixURL());
        model.addAttribute("LOGGED_IN", WebSecurityConfig.isLoggedIn());
//      ---------------------------------------------------------------------------------------------------------
        model.addAttribute("course", new Course());
        return "/admin/coursesCreate";
    }

    @GetMapping("/admin/courses/edit/{id}")
    public String courseEdit(Model model, @PathVariable("id") Integer id) {
//      ---------------------------------------------------------------------------------------------------------
//     | For menu (nav bar):                                                                                     |
//      ---------------------------------------------------------------------------------------------------------
        model.addAttribute("PREFIX", WebSecurityConfig.getPrefixURL());
        model.addAttribute("LOGGED_IN", WebSecurityConfig.isLoggedIn());
//      ---------------------------------------------------------------------------------------------------------
        model.addAttribute("course", courseRepository.findById(id));
        return "/admin/coursesUpdate";
    }
}
