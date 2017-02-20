package ua.com.internet_shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ua.com.internet_shop.entity.Pages;
import ua.com.internet_shop.service.CartService;
import ua.com.internet_shop.service.CategoryService;
import ua.com.internet_shop.service.NewsService;
import ua.com.internet_shop.service.PagesService;

import java.security.Principal;

@Controller
public class PagesController {

    @Autowired
    private PagesService pagesService;
    @Autowired
    private CartService cartService;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private NewsService newsService;

    @RequestMapping(value = "/pages")
    public String pages(Model model){
        model.addAttribute("pages", pagesService.findAll());
        return "admin-pages";
    }

    @RequestMapping(value = "/newPage")
    public String newPage(Model model){
        model.addAttribute("pages", new Pages());
        return "admin-newPage";
    }

    @RequestMapping(value = "/changePage{id}")
    public String changePage(Model model, @PathVariable int id){
        model.addAttribute("page", pagesService.findOne(id));
        return "admin-changePage";
    }

    @Transactional
    @RequestMapping(value = "/updatePage", method = RequestMethod.POST)
    public String updatePage(
            @ModelAttribute Pages page,
            @RequestParam String visible){
        page.setVisible(Boolean.parseBoolean(visible));
//        pagesService.save(page);
        return "redirect:/pages";
    }

    @RequestMapping(value = "/savePage")
    public String savePage(@ModelAttribute Pages pages){
        pagesService.save(pages);
        return "redirect:/pages";
    }

    @RequestMapping(value = "/deletePage/{id}")
    public String deletPage(@PathVariable int id){
        pagesService.delete(id);
        return "redirect:/pages";
    }

    @RequestMapping(value = "/page{id}")
    public String page(Model model, @PathVariable int id, Principal principal){
        model.addAttribute("page",pagesService.findOne(id));
        if (principal != null && !principal.getName().equals("admin")){
            model.addAttribute("loadCart", cartService.totalQuantityAndPrice(Integer.parseInt(principal.getName())));
        }
        model.addAttribute("categories", categoryService.findAll());
        model.addAttribute("pages", pagesService.findAll());
        model.addAttribute("allNews", newsService.findAll());
        return "views-base-page";
    }
}
