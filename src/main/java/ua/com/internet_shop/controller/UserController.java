package ua.com.internet_shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ua.com.internet_shop.editor.UserEditor;
import ua.com.internet_shop.entity.User;
import ua.com.internet_shop.service.*;

import java.security.Principal;
import java.util.UUID;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	@Autowired
	private MailSenderService mailSenderService;
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private PagesService pagesService;
	@Autowired
	private NewsService newsService;
	@Autowired
	private ZakazService zakazService;
	@Autowired
	private CartService cartService;
	
	@InitBinder
	public void InitBinder(WebDataBinder binder){
		binder.registerCustomEditor(User.class, new UserEditor(userService));
	}
	
	@RequestMapping(value = "/registration")
	public String newUser(Model model){
		model.addAttribute("user", new User());

		model.addAttribute("categories", categoryService.findAll());
		model.addAttribute("pages", pagesService.findAll());
		model.addAttribute("allNews", newsService.findAll());
		return "views-base-registration";
	}
	
	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public String saveUser(@ModelAttribute User user, Model model){
		
		String uuid = UUID.randomUUID().toString();
		user.setUuid(uuid);
		
		try {
			userService.save(user);
		} catch (Exception e) {
			model.addAttribute("exeptions", e.getMessage());
			return "views-base-registration";
		}
		
		String theme = "thank's for registration";
//		String mailBody = "gl & hf  http://localhost:8080/SpringMvcJstlSpringDataHome/confirm/" + uuid;
		String mailBody = "gl & hf  http://localhost:8080/confirm/" + uuid;

		mailSenderService.sendMail(theme, mailBody, user.getEmail());
		
		return "redirect:/";
	}
	
	@RequestMapping(value = "/confirm/{uuid}", method = RequestMethod.GET)
	public String confirm(@PathVariable String uuid){
		User user = userService.findByUuid(uuid);
		user.setEnabled(true);
		userService.update(user);
		return "redirect:/home";
	}
	
	@RequestMapping(value = "/profile")
	public String profile(Principal principal, Model model){
		model.addAttribute("user", userService.findOne(Integer.parseInt(principal.getName())));
		model.addAttribute("categories", categoryService.findAll());
		model.addAttribute("pages", pagesService.findAll());
		model.addAttribute("allNews", newsService.findAll());
		if (principal != null && !principal.getName().equals("admin")){
			model.addAttribute("loadCart", cartService.totalQuantityAndPrice(Integer.parseInt(principal.getName())));
		}
		return "views-base-profile";
	}

	@Transactional
	@RequestMapping(value = "/updateUser", method = RequestMethod.POST)
	public String updateUser(
			Principal principal,
			@RequestParam String name,
			@RequestParam String surname,
			@RequestParam String city,
			@RequestParam String address,
			@RequestParam String phone
			) {
		User user = userService.findOne(Integer.parseInt(principal.getName()));
		user.setName(name);
		user.setSurname(surname);
		user.setCity(city);
		user.setAddress(address);
		user.setPhone(phone);

		try {
			userService.save(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/profile";
	}
	
	@RequestMapping(value = "/saveImage", method = RequestMethod.POST)
	public String saveImage(Principal principal, @RequestParam MultipartFile image){
		userService.saveImage(principal, image);
		return "redirect:/profile";
	}

	@RequestMapping(value = "/userOrders")
	public String userOrders(Principal principal, Model model){
		model.addAttribute("userOrders", zakazService.findZakazByUser(Integer.parseInt(principal.getName())));
		model.addAttribute("categories", categoryService.findAll());
		model.addAttribute("pages", pagesService.findAll());
		model.addAttribute("allNews", newsService.findAll());
		if (principal != null && !principal.getName().equals("admin")){
			model.addAttribute("loadCart", cartService.totalQuantityAndPrice(Integer.parseInt(principal.getName())));
		}
		return "views-base-userOrders";
	}
	
	
	
}
