package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

/**
 * Created by Zoltán on 2017.01.26..
 */
@Controller
public class HelloController {

    private final String name = "Zoltan";

    @Autowired
    ChatServices chatServices;

    @Autowired
    TohotomServices tohotomServices;

    @GetMapping("/main")
    private String addName(Model model){

        return "greetings";
    }
    @PostMapping("/main")
    private String submitName(@ModelAttribute @Valid String name, BindingResult bindingResult){
        
        return "redirect:/hello";
    }

    @GetMapping("/hello")
    private String addNewMessage(Model model){
        model.addAttribute("messagesList", chatServices.getMessages());
        model.addAttribute("username", name);
        chatServices.addMessage(model);
        return "hello";
    }
    @PostMapping("/hello")
    private String sumbitMessage(@ModelAttribute @Valid ChatMessage chatMessage, BindingResult bindingResult){
        chatServices.submitMessage(chatMessage, bindingResult);
        tohotomServices.answerToLastMessage();
        return "redirect:/hello";
    }






}
