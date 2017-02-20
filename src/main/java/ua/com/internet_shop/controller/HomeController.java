package ua.com.internet_shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ua.com.internet_shop.service.*;

import java.security.Principal;

@Controller
public class HomeController {
	
	@Autowired
	private GoodsService goodsService;
	@Autowired
	private UserService userService;
	@Autowired
	private CartService cartService;
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private PagesService pagesService;
	@Autowired
	private NewsService newsService;
	
//	@RequestMapping(value="/", method=RequestMethod.GET)
//	public String home(Model model){
//		model.addAttribute("max", Integer.MAX_VALUE);
//		return "home";
//	}
	
//	@RequestMapping(value="/link", method=RequestMethod.GET)
//	public String link(@RequestParam String someInput){
//		System.out.println(someInput);
//		return "redirect:/";
//	}

	
	@RequestMapping(value={"/", "home"}, method=RequestMethod.GET)
	public String home(Model model, Principal principal){
		if (principal != null && !principal.getName().equals("admin")){
			model.addAttribute("loadCart", cartService.totalQuantityAndPrice(Integer.parseInt(principal.getName())));
		}
		model.addAttribute("categories", categoryService.findAll());
		model.addAttribute("pages", pagesService.findAll());
		model.addAttribute("allNews", newsService.findAll());

		model.addAttribute("goods", goodsService.findAllGoods());
		return "views-base-home";
	}

	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public String search(Model model, @RequestParam String search, Principal principal){
		if (principal != null && !principal.getName().equals("admin")){
			model.addAttribute("loadCart", cartService.totalQuantityAndPrice(Integer.parseInt(principal.getName())));
		}
		model.addAttribute("search", goodsService.liveSearch(search));
		model.addAttribute("categories", categoryService.findAll());
		model.addAttribute("pages", pagesService.findAll());
		model.addAttribute("allNews", newsService.findAll());
		return "views-base-search";
	}

	@RequestMapping(value = "/home", method = RequestMethod.POST)
	public String loginprocesing(){
		return "redirect:/home";
	}
	
	@RequestMapping(value = "/loginpage")
	public String login(Model model){
		model.addAttribute("categories", categoryService.findAll());
		model.addAttribute("pages", pagesService.findAll());
		model.addAttribute("allNews", newsService.findAll());
		return "views-base-loginpage";
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.POST)
	public String logout(){
		return "redirect:/";
	}
}
