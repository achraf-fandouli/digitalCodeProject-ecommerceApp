package com.digitalcode.smartmunue.controller;

import com.digitalcode.smartmunue.global.GlobalData;
import com.digitalcode.smartmunue.model.Product;
import com.digitalcode.smartmunue.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class CartController {
    @Autowired
    ProductService productService;

    @GetMapping("/addToCart/{id}")
    public String addToCart(@PathVariable int id) {
        GlobalData.cart.add(productService.getProductById(id).get());
        return "redirect:/shop";
    }

    @GetMapping("/cart")
    public String cartGet(Model model) {
        model.addAttribute("cartCount", GlobalData.cart.size());
        model.addAttribute("total", GlobalData.cart.stream().mapToDouble(Product::getPrice).sum());
        model.addAttribute("cart", GlobalData.cart);
        return "cart";
    }

    @GetMapping("/cart/removeItem/{index}")
    public String cartItemRemove(@PathVariable int index) {
        GlobalData.cart.remove(index);
        return "redirect:/cart";
    }

    @GetMapping("/checkout")
    public String checkout(Model model) {
        model.addAttribute("cartCount", GlobalData.cart.size());
        model.addAttribute("total", GlobalData.cart.stream().mapToDouble(Product::getPrice).sum());
        return "checkout";
    }

    @PostMapping("/payNow")
    public String paynow(Model model, @RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName,
                         @RequestParam("address1") String address1, @RequestParam("phone") String phone, @RequestParam("email") String email) {
        model.addAttribute("cartCount", GlobalData.cart.size());
        model.addAttribute("total", GlobalData.cart.stream().mapToDouble(Product::getPrice).sum());
        model.addAttribute("firstName", firstName);
        model.addAttribute("lastName", lastName);
        model.addAttribute("phone", phone);
        model.addAttribute("address1", address1);
        model.addAttribute("email", email);
        //Emty the cart
        GlobalData.cart.clear();
        return "paynow";
    }


}
