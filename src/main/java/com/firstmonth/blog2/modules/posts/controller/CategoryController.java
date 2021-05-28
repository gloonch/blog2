package com.firstmonth.blog2.modules.posts.controller;

import com.firstmonth.blog2.modules.posts.model.Category;
import com.firstmonth.blog2.modules.posts.service.CategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/categories")
public class CategoryController {

    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public @ResponseBody
    Category registerCategory(Category category) {
        return categoryService.registerCategory(category);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public @ResponseBody
    List<Category> findAllCategories() {
        return categoryService.findAllCategories();
    }
}
