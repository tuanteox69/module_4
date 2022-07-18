package controllers;

import model.Product;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import service.CrudCategory;
import service.CrudProduct;

import java.util.ArrayList;
import java.util.List;

@Controller

public class Home {
    CrudProduct crudProduct = new CrudProduct();
    CrudCategory crudCategory = new CrudCategory();

    public List<Product> products = new ArrayList<>();

    @GetMapping("/home")
    public ModelAndView show() {
        ModelAndView modelAndView = new ModelAndView("home");
        modelAndView.addObject("products", crudProduct.products);
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showCreate() {
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("products", crudProduct.products);
        modelAndView.addObject("categories", crudCategory.categories);

        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView createProduct(@RequestParam int idP, @RequestParam String nameP,
                                       @RequestParam int price,@RequestParam String imgP,
                                      @RequestParam int category) {
        crudProduct.create(new Product(idP, nameP, price, imgP, crudCategory.findCategoryById(category)));
        ModelAndView modelAndView = new ModelAndView("home");
        modelAndView.addObject("products", crudProduct.products);
        return modelAndView;
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable int id) {
        crudProduct.delete(id);
        ModelAndView modelAndView = new ModelAndView("redirect:/home");

        return modelAndView;
    }

    @GetMapping("edit/{id}")
    public ModelAndView edit(@PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView("edit");
        modelAndView.addObject("products", crudProduct.products.get(crudProduct.vtProduct(id)));
        modelAndView.addObject("categories", crudCategory.categories);
        modelAndView.addObject("id", id);
        Boolean[] statusT = {true,false};
        modelAndView.addObject("statusT",statusT);
        return modelAndView;
    }

    @PostMapping("/edit")
    public ModelAndView edit(@RequestParam int idP, @RequestParam String nameP, @RequestParam int price, @RequestParam String imgP,
                             @RequestParam int category) {
        crudProduct.edit(idP, new Product(idP, nameP, price,imgP, crudCategory.findCategoryById(category)));
        ModelAndView modelAndView = new ModelAndView("home");
        modelAndView.addObject("products", crudProduct.products);
        return modelAndView;
    }
}

