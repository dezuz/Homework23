package com.mateacademy.controller;

import com.mateacademy.model.Product;
import com.mateacademy.service.ProducerServiceImpl;
import com.mateacademy.service.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping(path = "/product")
public class ProductController {

    @Autowired
    private ProductServiceImpl productService;

    @Autowired
    private ProducerServiceImpl producerService;

    @GetMapping("/create")
    public ModelAndView createProductPage(ModelAndView modelAndView) {
        modelAndView.setViewName("createProduct");
        modelAndView.addObject("product", new Product());
        modelAndView.addObject("producers", producerService.findAllProducers());
        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView createProduct(@ModelAttribute Product product, ModelAndView modelAndView) {
        modelAndView.setViewName("productCreatedPage");
        modelAndView.addObject("create", productService.addProduct(product));
        return modelAndView;
    }

    @GetMapping("/update")
    public ModelAndView updateProductPage(ModelAndView modelAndView) {
        modelAndView.setViewName("updateProduct");
        modelAndView.addObject("product", new Product());
        modelAndView.addObject("products", productService.findAllProducts());
        modelAndView.addObject("producers", producerService.findAllProducers());
        return modelAndView;
    }

    @PostMapping("/update")
    public ModelAndView updateProduct(@ModelAttribute Product product, ModelAndView modelAndView) {
        modelAndView.setViewName("productUpdatedPage");
        modelAndView.addObject("update", productService.update(product));
        return modelAndView;
    }

    @GetMapping("/delete")
    public ModelAndView deleteProductPage(ModelAndView modelAndView) {
        modelAndView.setViewName("deleteProduct");
        modelAndView.addObject("product", new Product());
        modelAndView.addObject("products", productService.findAllProducts());
        return modelAndView;
    }

    @PostMapping("/delete")
    public ModelAndView deleteProduct(@ModelAttribute Product product, ModelAndView modelAndView) {
        modelAndView.setViewName("productDeletedPage");
        modelAndView.addObject("delete", productService.getById(product.getId()));
        productService.delete(product.getId());
        return modelAndView;
    }
}
