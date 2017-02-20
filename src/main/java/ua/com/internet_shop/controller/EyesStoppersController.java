package ua.com.internet_shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import ua.com.internet_shop.entity.EyesStoppers;
import ua.com.internet_shop.service.*;

import java.security.Principal;

@Controller
public class EyesStoppersController {

    @Autowired
    private EyesStoppersService eyesStoppersService;
    @Autowired
    private PagesService pagesService;
    @Autowired
    private NewsService newsService;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private CartService cartService;

//    @RequestMapping(value = "/newEyesStoppers")
//    public String neweye(Model model){
//
//    }

    @RequestMapping(value = "/newEyesStoppers")
    public String eyestop(Model model){
        model.addAttribute("eyes", new EyesStoppers());
        model.addAttribute("showEyes", eyesStoppersService.findAll());
        return "admin-newEyesStoppers";
    }

    @RequestMapping(value = "/saveEye")
    public String saveEye(@ModelAttribute EyesStoppers eyesStoppers){
        eyesStoppersService.save(eyesStoppers);
        return "redirect:/newEyesStoppers";
    }

    @RequestMapping(value = "/top")
    public String top(Model model, Principal principal){
        if (principal != null && !principal.getName().equals("admin")){
            model.addAttribute("loadCart", cartService.totalQuantityAndPrice(Integer.parseInt(principal.getName())));
        }
        model.addAttribute("tops", eyesStoppersService.findGoodsByTop());
        model.addAttribute("categories", categoryService.findAll());
        model.addAttribute("pages", pagesService.findAll());
        model.addAttribute("allNews", newsService.findAll());
        return "views-base-top";
    }

    @RequestMapping(value = "/new")
    public String showNew(Model model, Principal principal){
        if (principal != null && !principal.getName().equals("admin")){
            model.addAttribute("loadCart", cartService.totalQuantityAndPrice(Integer.parseInt(principal.getName())));
        }
        model.addAttribute("showNew", eyesStoppersService.findGoodsByNew());
        model.addAttribute("categories", categoryService.findAll());
        model.addAttribute("pages", pagesService.findAll());
        model.addAttribute("allNews", newsService.findAll());
        return "views-base-new";
    }

    @RequestMapping(value = "/discount")
    public String discount(Model model, Principal principal){
        if (principal != null && !principal.getName().equals("admin")){
            model.addAttribute("loadCart", cartService.totalQuantityAndPrice(Integer.parseInt(principal.getName())));
        }
        model.addAttribute("discounts", eyesStoppersService.findGoodsByDiscount());
        model.addAttribute("categories", categoryService.findAll());
        model.addAttribute("pages", pagesService.findAll());
        model.addAttribute("allNews", newsService.findAll());
        return "views-base-discount";
    }

}
