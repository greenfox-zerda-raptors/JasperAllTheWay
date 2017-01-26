package com.example.Controllers;

import com.example.Services.ChatServices;
import com.example.Domains.ChatMessage;
import com.example.Domains.User;
import com.example.Services.TohotomServices;
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
    @Autowired
    ChatServices chatServices;

    @Autowired
    TohotomServices tohotomServices;

    User user;

    @GetMapping("/main")
    private String addName(Model model){
        addUser(model);
        return "main";
    }
    @PostMapping("/main")
    private String submitName(@ModelAttribute @Valid User username, BindingResult bindingResult){
        submitUser(username, bindingResult);
        return "redirect:/tohotom";
    }

    @GetMapping("/tohotom")
    private String addNewMessage(Model model){
        model.addAttribute("messagesList", chatServices.getMessages());
        model.addAttribute("user", user);
        chatServices.addMessage(model);
        return "chatbot";
    }
    @PostMapping("/tohotom")
    private String sumbitMessage(@ModelAttribute @Valid ChatMessage chatMessage, BindingResult bindingResult){
        chatServices.submitMessage(chatMessage, bindingResult);
        tohotomServices.answerToLastMessage();
        return "redirect:/tohotom";
    }






    private void addUser(Model model) {
        model.addAttribute("username", new User());
    }

    private void submitUser(User user, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            System.out.println("error");
        }else{
            this.user = user;
        }
    }


}
