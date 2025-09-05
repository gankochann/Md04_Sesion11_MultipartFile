package ra.com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ra.com.model.Product;
import ra.com.service.ProductService;
import ra.com.service.UserService;

import java.rmi.MarshalledObject;
import java.util.List;

@Controller
@RequestMapping("/user/home")
public class HomeController {
    @Autowired
    private UserService userService;

    @Autowired
    private ProductService productService;

    @GetMapping()
    public String home(Model model){
        List<Product> productList = productService.findAll();
        model.addAttribute("productList" , productList);
        return "home";
    }
}
