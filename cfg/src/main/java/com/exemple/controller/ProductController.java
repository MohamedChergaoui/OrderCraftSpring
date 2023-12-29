package com.exemple.controller;

import com.exemple.entity.Product;
import com.exemple.service.Product.IProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/Products")
public class ProductController {
    @Autowired
    private IProduct productService;

    @GetMapping
    public String list(ModelMap modelMap) {
        List<Product> products = productService.getProducts();
        modelMap.addAttribute("products", products);
        return "Product/Products";
    }

    @GetMapping("/Edit")
    public String editProduct(long id, Model model) {
        Product product = productService.getProductById(id);
        model.addAttribute("product", product);
        return "Product/Edit";
    }

    @PostMapping("/Save")
    public String saveProduct(long id, String name, String description, double price, int quantity) {
        productService.updateProduct(id, name, description, price, quantity);
        return "redirect:/Products";
    }

    @GetMapping("/Delete")
    public String deleteProduct(long id) {
        productService.deleteProduct(id);
        return "redirect:/Products";
    }

    @GetMapping("/Add")
    public String addProduct() {
        return "Product/AddProduct";
    }

    @PostMapping("/Add")
    public String addProduct(String name, String description, double price, int quantity) {
        productService.addProduct(name, description, price, quantity);
        return "redirect:/Products";
    }
}
