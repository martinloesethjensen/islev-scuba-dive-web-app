package com.theopensourcerers.islevwebapplication3rdsemesterexamproject.controller;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Configuration
@RequestMapping("event")
public class EventController {

  @GetMapping("")
  public String event(){
    return "event/index";
  }
}
