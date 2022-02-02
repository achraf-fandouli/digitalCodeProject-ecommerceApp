package com.digitalcode.smartmunue.controller;

import com.digitalcode.smartmunue.service.CategoryService;
import com.digitalcode.smartmunue.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class HomeController {

    @Autowired
    CategoryService categoryService;

    @Autowired
    ProductService productService;

    @GetMapping({"/", "/home"})
    public String home(Model model) {
        return "index";
    }

    @GetMapping({"/shop"})
    public String shop(Model model) {
        model.addAttribute("categories", categoryService.getAllCategory());
        model.addAttribute("products", productService.getAllProduct());
        return "shop";
    }

    @GetMapping({"/shop/category/{id}"})
    public String shopByCategory(Model model, @PathVariable int id) {
        model.addAttribute("categories", categoryService.getAllCategory());
        model.addAttribute("products", productService.getAllProductByCategoryId(id));
        return "shop";
    }

    /**
     *public String viewProduct(Model model, @PathVariable int id): let to display the product view with all it's details
     * @param model support to add attribute to our model in this case the attribute is : "product"
     * @param id of selected product to display
     * @return the view with product details
     */
    @GetMapping({"/shop/viewproduct/{id}"})
    public String viewProduct(Model model, @PathVariable int id) {
        model.addAttribute("product", productService.getProductById(id).get());
        return "viewProduct";
    }
}
