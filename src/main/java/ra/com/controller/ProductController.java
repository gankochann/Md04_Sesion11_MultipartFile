package ra.com.controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ra.com.dto.ProductDto;
import ra.com.dto.ProductUpdateDto;
import ra.com.model.Product;
import ra.com.service.ProductService;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/findall")
    public String findAllHome(Model model){
        List<Product> listproduct = productService.findAll();
        model.addAttribute("listProduct" , listproduct);
        return "home";
    }

    @GetMapping("/add")
    public String showFormAddProduct(Model model){
        ProductDto productDto = new ProductDto();
        model.addAttribute("productDto" , productDto);
        return "addProduct";
    }
   @PostMapping("/add")
    public String addProduct(@Valid @ModelAttribute("productDto")ProductDto productDto, BindingResult bindingResult, Model model){
       boolean result = productService.addProduct(productDto , bindingResult);
        if(bindingResult.hasErrors()){
            return "home";
        }
        if(result){
            return "redirect:/product/findall";
        }
        else {
            return "error";
        }

   }

   @GetMapping("/update")
    public String shoeFormUpdateProduct(Model model, @RequestParam("id") long id){
       ProductUpdateDto productUpdateDto = productService.findById(id);
       model.addAttribute("productUpdateDto",productUpdateDto);
       return "updateProduct";
   }

   @PostMapping("/update")
    public String updateProduct(@Valid @ModelAttribute("productUpdateDto") ProductUpdateDto productUpdateDto,BindingResult bindingResult , Model model){
        if(bindingResult.hasErrors()){
            return "home";
        }
        boolean result = productService.update(productUpdateDto);
        if(result){
            return "redirect:/product/findall";
        }
        else {
            return "error";
        }
   }

   @GetMapping("/delete")
    public String deleteProduct(@RequestParam("id") long id){
        boolean result = productService.delete(id);
        if(result){
            return "redirect:/product/findall";
        }
        else {
            return "error";
        }
   }

   @GetMapping("/search")
    public String searchProduct(@RequestParam("search") String search ,Model model){
        List<Product> listproduct = productService.findProductByName(search);
        model.addAttribute("listProduct" , listproduct);
        return "home";
   }

}
