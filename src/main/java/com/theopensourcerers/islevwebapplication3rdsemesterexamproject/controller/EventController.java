package com.theopensourcerers.islevwebapplication3rdsemesterexamproject.controller;

import com.theopensourcerers.islevwebapplication3rdsemesterexamproject.authentication.WebSecurityConfig;
import com.theopensourcerers.islevwebapplication3rdsemesterexamproject.base.Member;

import org.springframework.context.annotation.Configuration;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

@Configuration
@RequestMapping("event")
public class EventController {

  @GetMapping("")
  public String event(Model model){
    model.addAttribute("LOGGED_IN", WebSecurityConfig.isLoggedIn());
    model.addAttribute("members", new ArrayList<Member>());
    return "event/index";
  }
}