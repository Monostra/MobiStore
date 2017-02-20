package ua.com.internet_shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ua.com.internet_shop.dto.DtoUtilMapper;
import ua.com.internet_shop.entity.Category;
import ua.com.internet_shop.service.CartService;
import ua.com.internet_shop.service.CategoryService;
import ua.com.internet_shop.service.NewsService;
import ua.com.internet_shop.service.PagesService;

import java.security.Principal;

@Controller
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private PagesService pagesService;
	@Autowired
	private NewsService newsService;
	@Autowired
	private CartService cartService;

	@RequestMapping(value = "/allCategory")
	public String allCategory(Model model){
		model.addAttribute("allCategories", categoryService.findAll());
		return "admin-allCategory";
	}

	@RequestMapping(value = "/changeCategory{id}")
	public String changeCatgory(Model model, @PathVariable int id){
		model.addAttribute("category", categoryService.findOne(id));
		return "admin-changeCategory";
	}

	@Transactional
	@RequestMapping(value = "/updateCategory", method = RequestMethod.POST)
	public String updateCategory(@RequestParam String visible,
								 @RequestParam String position,
								 @RequestParam String name,
								 @RequestParam String parents,
								 @RequestParam int id){
		Category category = categoryService.findOne(id);
		category.setVisible(Boolean.parseBoolean(visible));
		category.setPosition(Short.parseShort(position));
		category.setName(name);
		category.setParents(Integer.parseInt(parents));
		categoryService.save(category);
		return "redirect:/allCategory";
	}

	@RequestMapping(value="/newCategory", method=RequestMethod.GET)
	public String newCat(Model model){
//		model.addAttribute("cat", categoryService.findAll());
//		model.addAttribute("cats", categoryService.findCatWithGoods());
		model.addAttribute("catDto", DtoUtilMapper.categoryToCategoryDto(categoryService.findAll()));
		
		model.addAttribute("category", new Category());
		return "admin-newCategory";
	}
	
	@RequestMapping(value="/saveCategory", method=RequestMethod.POST)
	public String saveCategory(@ModelAttribute Category category,
			@RequestParam String position){
		category.setPosition(Short.parseShort(position));
		categoryService.save(category);
		return "redirect:/allCategory";
	}
	
	@RequestMapping(value="/deleteCategory/{id}", method=RequestMethod.GET)
	public String deleteCategory(@PathVariable int id){
		categoryService.delete(id);
		return "redirect:/allCategory";
	}
	
//	@RequestMapping(value = "/allCategories", method = RequestMethod.POST)
//	public @ResponseBody List<CategoryDto> allCategories(){
//		return DtoUtilMapper.categoryToCategoryDto(categoryService.findAll());
//	}

	@RequestMapping(value = "/category{id}")
	public String category(Model model, @PathVariable int id, Principal principal){
		if (principal != null && !principal.getName().equals("admin")){
			model.addAttribute("loadCart", cartService.totalQuantityAndPrice(Integer.parseInt(principal.getName())));
		}
		model.addAttribute("cat", categoryService.findOne(id));
		model.addAttribute("category", categoryService.findCategoryWithGoodsById(id));
		model.addAttribute("categories", categoryService.findAll());
		model.addAttribute("pages", pagesService.findAll());
		model.addAttribute("allNews", newsService.findAll());
		return "views-base-category";
	}
	
	
}
