package ra.com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ra.com.model.User;
import ra.com.model.UserDto;
import ra.com.model.UserLogin;
import ra.com.service.UserService;

import javax.validation.Valid;

@Controller
@RequestMapping("/auth")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String showFormLogin(Model model){
        model.addAttribute("userLogin" , new UserLogin());
        return "login";
    }

    @PostMapping("/login")
    public String login(@Valid @ModelAttribute UserLogin userLogin, BindingResult bindingResult,Model model){
        if(bindingResult.hasErrors()){
            return "login";
        }
        User user = userService.login(userLogin);
       if(user != null){
           model.addAttribute("user", user);
           return "redirect:/";
       }else {
           model.addAttribute("userLogin" , userLogin);
           return "login";
       }
    }

    @GetMapping("/register")
    public String showFormRegister(Model model){
        model.addAttribute("userDto", new UserDto());
        return "register";
    }

    @PostMapping("/register")
    public String register(@Valid @ModelAttribute UserDto userDto,BindingResult bindingResult,Model model){
        if(bindingResult.hasErrors()){
            return "register";
        }
        User user = userService.register(userDto);
        if(user != null){
            return "login";
        }
        else {
            return "register";
        }
    }
}
