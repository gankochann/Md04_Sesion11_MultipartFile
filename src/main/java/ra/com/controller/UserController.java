package ra.com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ra.com.dto.UserRegisterDto;
import ra.com.dto.UserloginDto;
import ra.com.model.Product;
import ra.com.model.User;
import ra.com.model.UserLogin;
import ra.com.service.ProductService;
import ra.com.service.UserService;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private ProductService productService;
    @GetMapping("/register")
    public String showFormRegister(Model model){
        UserRegisterDto userRegisterDto = new UserRegisterDto();
        model.addAttribute("userRegisterDto",userRegisterDto);
        return "register";
    }

    @PostMapping("/register")
    public String register(@Valid @ModelAttribute("userRegisterDto") UserRegisterDto userRegisterDto, BindingResult bindingResult,Model model){
        if(bindingResult.hasErrors()){
            return "register";
        }
        boolean result = userService.createUser(userRegisterDto,bindingResult);
        if(!result){
            return "register";
        }else {
            return "redirect:/user/login";
        }
    }

    @GetMapping("/login")
    public String showFormlogin(Model model){
        UserloginDto userloginDto = new UserloginDto();
        model.addAttribute("userloginDto",userloginDto);
        return "login";
    }

    @PostMapping("/login")
    public String login(@Valid @ModelAttribute("userloginDto") UserloginDto userloginDto, BindingResult bindingResult,Model model){
        if(bindingResult.hasErrors()){
            return "login";
        }
        User user = userService.login(userloginDto);
        if(user == null) {
            model.addAttribute("userloginDto", userloginDto);
            return "login";
        }else {
            UserLogin.user = user;
            return "redirect:/product/findall";
        }
    }

}
