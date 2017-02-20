package ua.com.internet_shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ua.com.internet_shop.entity.News;
import ua.com.internet_shop.service.CartService;
import ua.com.internet_shop.service.CategoryService;
import ua.com.internet_shop.service.NewsService;
import ua.com.internet_shop.service.PagesService;

import java.security.Principal;
import java.time.LocalDate;

@Controller
public class NewsController {

    @Autowired
    private NewsService newsService;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private PagesService pagesService;
    @Autowired
    private CartService cartService;

    @RequestMapping(value = "/allNews")
    public String allNews(Model model){
        model.addAttribute("allNews", newsService.findAll());
        return "admin-allNews";
    }

    @RequestMapping(value = "/newNews")
    public String newNews(Model model){
        model.addAttribute("news", new News());
        return "admin-newNews";
    }

    @RequestMapping(value = "/saveNews")
    public String saveNews(@ModelAttribute News news){
        news.setDate(LocalDate.now());
        newsService.save(news);
        return "redirect:/allNews";
    }

    @RequestMapping(value = "/deleteNews/{id}")
    public String deleteNews(@PathVariable int id){
        newsService.delete(id);
        return "redirect:/allNews";
    }

    @RequestMapping(value = "/showNews")
    public String showNews(Model model, Principal principal){
        model.addAttribute("allNews", newsService.findAll());
        model.addAttribute("categories", categoryService.findAll());
        model.addAttribute("pages", pagesService.findAll());
        if (principal != null && !principal.getName().equals("admin")){
            model.addAttribute("loadCart", cartService.totalQuantityAndPrice(Integer.parseInt(principal.getName())));
        }
        return "views-base-showNews";
    }

    @RequestMapping(value = "/news{id}")
    public String news(Model model,@PathVariable int id, Principal principal){
        model.addAttribute("news", newsService.findOne(id));
        model.addAttribute("categories", categoryService.findAll());
        model.addAttribute("pages", pagesService.findAll());
        model.addAttribute("allNews", newsService.findAll());
        if (principal != null && !principal.getName().equals("admin")){
            model.addAttribute("loadCart", cartService.totalQuantityAndPrice(Integer.parseInt(principal.getName())));
        }
        return "views-base-news";
    }

}
