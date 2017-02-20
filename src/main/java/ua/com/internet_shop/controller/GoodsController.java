package ua.com.internet_shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ua.com.internet_shop.dto.DtoUtilMapper;
import ua.com.internet_shop.dto.GoodsDto;
import ua.com.internet_shop.editor.CategoryEditor;
import ua.com.internet_shop.editor.EyesStoppersEditor;
import ua.com.internet_shop.entity.Category;
import ua.com.internet_shop.entity.EyesStoppers;
import ua.com.internet_shop.entity.Goods;
import ua.com.internet_shop.service.*;

import java.security.Principal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Controller
public class GoodsController {
	
	@Autowired
	private GoodsService goodsService;
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private EyesStoppersService eyesStoppersService;
	@Autowired
	private CartService cartService;
	@Autowired
	private NewsService newsService;
	@Autowired
	private PagesService pagesService;

	
	
	@InitBinder
	public void InitBinder(WebDataBinder binder){
		binder.registerCustomEditor(Category.class, new CategoryEditor(categoryService));
		binder.registerCustomEditor(EyesStoppers.class, new EyesStoppersEditor(eyesStoppersService));
	}

	@RequestMapping(value = "/allGoods")
	public String allGoods(Model model){
		model.addAttribute("goods", new Goods());
//		model.addAttribute("showGoods", goodsService.findAll());
		model.addAttribute("showGoods", goodsService.findGoodsWithMainImg());


		return "admin-allGoods";

	}
	
	@RequestMapping(value="/newGood", method=RequestMethod.GET)
	public String newGood(Model model){
		model.addAttribute("goods", new Goods());
		model.addAttribute("categories", categoryService.findAll());
		model.addAttribute("eyesStoppers", eyesStoppersService.findAll());
		return "admin-newGood";
	}

	@RequestMapping(value = "/changeGood{id}")
	public String changeGood(Model model, @PathVariable int id){
//		model.addAttribute("goods", new Goods());
		model.addAttribute("good", goodsService.findGood(id));
		model.addAttribute("categories", categoryService.findAll());
		model.addAttribute("eyesStoppers", eyesStoppersService.findAll());
		return "admin-changeGood";
	}

	@Transactional
	@RequestMapping(value = "/updateGood", method=RequestMethod.POST)
	public String updateGood(
			@ModelAttribute Goods good
//			@RequestParam int id,
//			@RequestParam String date
			){
//		good.setDiscountDate(LocalDate.now().plusDays(Long.parseLong(date)));
		good.setDateTime(LocalDateTime.now());
		goodsService.save(good);
		return "redirect:/allGoods";
	}

	@RequestMapping(value="/saveGood", method=RequestMethod.POST)
	public String saveGood(
			@ModelAttribute Goods goods,
			@RequestParam String price,
			@RequestParam String discount,
			@RequestParam String date,
			@RequestParam MultipartFile[] image,
			@RequestParam String mainImg
				){

//		LocalDate localDate = LocalDate.now().plusDays(Long.parseLong(discountDate));
//		LocalDateTime localDateTime = LocalDateTime.now();
//		LocalDateTime localDateTime
		goods.setDateTime(LocalDateTime.now());
//		goods.setDiscountDate(LocalDate.parse(date));
		goods.setDiscountDate(LocalDate.now().plusDays(Long.parseLong(date)));
		goods.setPrice(Float.parseFloat(price));
		goods.setDiscount(Float.parseFloat(discount));

		goodsService.save(goods);
		Goods goods1 = (Goods) goodsService.saveAndFlash(goods);
		int goodsId = goods1.getId();
		if (!image[0].isEmpty()){
			goodsService.saveGoodImg(goodsId, image, mainImg);
		}
		return "redirect:/allGoods";
	}
	
	@RequestMapping(value="/deleteGood/{id}", method=RequestMethod.GET)
	public String deleteCat(@PathVariable int id){
		goodsService.delete(id);
		return "redirect:/allGoods";
	}

	@RequestMapping(value = "/good{id}")
	public String good(@PathVariable int id, Principal principal, Model model){
		model.addAttribute("good", goodsService.findOneGoodsWithImg(id));
//		model.addAttribute("good", goodsService.findOne(id));
		if (principal != null && !principal.getName().equals("admin")){
			model.addAttribute("loadCart", cartService.totalQuantityAndPrice(Integer.parseInt(principal.getName())));
		}
		model.addAttribute("categories", categoryService.findAll());
		model.addAttribute("pages", pagesService.findAll());
		model.addAttribute("allNews", newsService.findAll());
		return "views-base-good";
	}

	@RequestMapping(value = "/liveSearch", method = RequestMethod.POST)
	public @ResponseBody List<GoodsDto> liveSearch(@RequestBody String search){
		List<Goods> goodsList = goodsService.liveSearch(search);
		return DtoUtilMapper.goodtoGoodsDto(goodsList);
	}



}
